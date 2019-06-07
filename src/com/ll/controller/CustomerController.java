package com.ll.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ll.pojo.Customer;
import com.ll.pojo.Customer;
import com.ll.pojo.Customer;
import com.ll.pojo.Customer;
import com.ll.pojo.Customer;
import com.ll.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	private static final Log logger = LogFactory.getLog(CustomerController.class);
	@Autowired
	public CustomerService customerService;

	/*
	 * 查询
	 */
	 @RequestMapping("/find")
	 public String findCustomer(@Param("cname") String cname, HttpSession session, Model model){
		Customer findCustomer = customerService.findCustomerByCname(cname);//根据aitem获取用户详情
		//建立session，处理删除操作是方便传值
		session.setAttribute("customer", findCustomer);
    	model.addAttribute("findCustomer", findCustomer);
    	logger.info("【操作】：根据cname查询用户详情...");
    	return "customerFind";
    }
	 /*
	  * 删除
	  */
	 @RequestMapping("/delete")
	 public String delete(Customer customer, HttpSession session, Model model) {
		 Customer customer2 = (Customer) session.getAttribute("customer");
		 customerService.deleteByPrimaryKey(customer2.getId());
		 logger.info("删除成功");
		 return "main";
	}
	 /**
	 * 添加新客户
	 */
	@RequestMapping(value="/profile")
	public String profile(@ModelAttribute("customer") Customer customer) {
		if (customerService.addCustomer(customer)) {
			logger.info("成功");
			return "main";// 注册成功，跳转到login.jsp
		} else {
			logger.info("失败");
			// 使用@ModelAttribute("customer")与model.addAttribute("customer", customer)功能相同
			// 在register.jsp页面上可以使用EL表达式${customer.uname}取出ModelAttribute的uname值
			return "customerProfile";// 返回register.jsp
		}
	}
	
	/**
	 * 保存用户资料
	 */
	/**
	 * 获取用户资料
	 */
	@RequestMapping(value="/profile",method=RequestMethod.GET)
	public String getProfile(HttpSession session,Model model) {
		Customer customer = (Customer) session.getAttribute("u");
		if (null == customer) {
			return "redirect:login";
		}
		// 从数据表获取最新数据
		customer = customerService.findCustomer(customer);
		
		model.addAttribute("customer", customer);
		return "customerProfile";// 返回用户资料填写页
	}
	
	
	
	@RequestMapping(value = "/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "customerList";
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model) {
		return "main";
	}
}
