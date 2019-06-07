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
	 public String findCustomer(@Param("cname") String cname, Model model){
		Customer findCustomer = customerService.findCustomerByCname(cname);//根据aitem获取用户详情
    	model.addAttribute("findCustomer", findCustomer);
    	logger.info("【操作】：根据cname查询用户详情...");
    	return "customerFind";
    }
	 /*
	  * 删除
	  */
	 @RequestMapping("/delete")
	 public String delete(Customer customer, HttpSession session, Model model) {
		 Customer customer2 = (Customer) session.getAttribute("u");
		 customerService.deleteByPrimaryKey(customer2.getId());
		 logger.info("删除成功");
		 return "main";
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
	
	/**
	 * 保存用户资料
	 */
	@RequestMapping(value="/profile",method=RequestMethod.POST)
	public String saveProfile(@ModelAttribute("customer") Customer customer) {
		customerService.updateCustomer(customer);
		logger.info("更新成功");
		return "main";// 注册成功，跳转到login.jsp
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
