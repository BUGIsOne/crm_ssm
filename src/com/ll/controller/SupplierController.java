package com.ll.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ll.pojo.Supplier;
import com.ll.pojo.Supplier;
import com.ll.pojo.Supplier;
import com.ll.pojo.Supplier;
import com.ll.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	private static final Log logger = LogFactory.getLog(SupplierController.class);
	@Autowired
	public SupplierService supplierService;

	/*
	 * 查询
	 */
	 @RequestMapping("/find")
	 public String findSupplier(@Param("sname") String sname, HttpSession session, Model model){
		Supplier findSupplier = supplierService.findSupplierBySname(sname);  //根据aitem获取用户详情
		//建立session，处理删除操作是方便传值
		session.setAttribute("supplier", findSupplier);
    	model.addAttribute("findSupplier", findSupplier);
    	logger.info("【操作】：根据sname查询用户详情...");
    	return "supplierFind";
    }
	 /*
	  * 删除
	  */
	 @RequestMapping("/delete")
	 public String delete(Supplier supplier, HttpSession session, Model model) {
		 Supplier supplier2 = (Supplier) session.getAttribute("supplier");
		 supplierService.deleteByPrimaryKey(supplier2.getId());
		 logger.info("删除成功");
		 return "main";
	}
	 /**
	 * 添加新活动
	 */
	@RequestMapping(value="/profile")
	public String profile(@ModelAttribute("supplier") Supplier supplier) {
		if (supplierService.addSupplier(supplier)) {
			logger.info("成功");
			return "main";// 注册成功，跳转到login.jsp
		} else {
			logger.info("失败");
			// 使用@ModelAttribute("supplier")与model.addAttribute("supplier", supplier)功能相同
			// 在register.jsp页面上可以使用EL表达式${supplier.uname}取出ModelAttribute的uname值
			return "supplierProfile";// 返回register.jsp
		}
	}
	
	
	@RequestMapping(value = "/list")
	public String listSuppliers(Model model) {
		List<Supplier> suppliers = supplierService.getSuppliers();
		model.addAttribute("suppliers", suppliers);
		return "supplierList";
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model) {
		return "main";
	}
}
