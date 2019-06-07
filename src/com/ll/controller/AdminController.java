package com.ll.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ll.pojo.Admin;
import com.ll.service.AdminService;


@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Log logger = LogFactory.getLog(AdminController.class);
	@Autowired
	public AdminService adminService;

	/**
	 * 处理登录
	 */
	@RequestMapping("/login")
	public String login(Admin admin, HttpSession session, Model model) {
		Admin foundAdmin = adminService.login(admin);
		if(null != foundAdmin) {
			session.setAttribute("u", foundAdmin);
			logger.info("成功");
			return "main";// 登录成功，跳转到main.jsp
		} else {
			logger.info("失败");
			model.addAttribute("messageError", "登录名或密码错误");
			return "login";
		}
	}
	
	/**
	 * 处理注销
	 */
	@RequestMapping("/logout")
	public String logout(Admin admin, HttpSession session, Model model) {
		session.removeAttribute("u");
		return "login";
	}

	/**
	 * 处理注册
	 */
	@RequestMapping("/register")
	public String register(@ModelAttribute("admin") Admin admin) {
		if (adminService.register(admin)) {
			logger.info("成功");
			return "login";// 注册成功，跳转到login.jsp
		} else {
			logger.info("失败");
			// 使用@ModelAttribute("admin")与model.addAttribute("admin", admin)功能相同
			// 在register.jsp页面上可以使用EL表达式${admin.uname}取出ModelAttribute的uname值
			return "register";// 返回register.jsp
		}
	}
	/*
	 * 查询
	 */
	 @RequestMapping("/find")
	 public String findAdmin(@Param("aname") String aname, HttpSession session, Model model){
		 Admin findAdmin = adminService.findAdminByAname(aname);  //根据ID获取用户详情
    	//处理时间格式
		/*
		 * DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); if
		 * (findAdmin.getCreatedate() != null) { Date createtime =
		 * formatter.format(findAdmin.getCreatedate());
		 * findAdmin.setCreatedate(createtime); }
		 */
		 //新的session来处理删除单个用户
		 session.setAttribute("admin", findAdmin);
    	model.addAttribute("findAdmin", findAdmin);
    	logger.info("【操作】：根据aname查询用户详情...");
    	return "adminFind";
    }
	/*
	 * @RequestMapping(value="/find/{id}",method=RequestMethod.DELETE)
	 * 
	 * @ResponseBody public String deleteAdminById(@PathVariable("id") Integer id) {
	 * adminService.deleteByPrimaryKey(id); logger.info("删除成功"); return "adminFind";
	 * }
	 */
	
	 /*
	  * 删除
	  */
	 @RequestMapping("/delete")
	 public String delete(Admin admin, HttpSession session, Model model) {
		 //永远删除登录的那个用户
		 //Admin admin2 = (Admin) session.getAttribute("u");
		 Admin admin2 = (Admin) session.getAttribute("admin");
		 adminService.deleteByPrimaryKey(admin2.getId());
		 logger.info("删除成功");
		 return "main";
	}
	
	 
	 
	/**
	 * 添加新用户
	 */
	@RequestMapping(value="/profile")
	public String profile(@ModelAttribute("admin") Admin admin) {
		if (adminService.register(admin)) {
			logger.info("成功");
			return "main";// 注册成功，跳转到login.jsp
		} else {
			logger.info("失败");
			// 使用@ModelAttribute("admin")与model.addAttribute("admin", admin)功能相同
			// 在register.jsp页面上可以使用EL表达式${admin.uname}取出ModelAttribute的uname值
			return "adminProfile";// 返回register.jsp
		}
	}
	
	
	@RequestMapping(value = "/list")
	public String listAdmins(Model model) {
		List<Admin> admins = adminService.getAdmins();
		model.addAttribute("admins", admins);
		return "adminList";
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model) {
		return "main";
	}
}
