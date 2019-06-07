package com.ll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
	@RequestMapping("/login")
	public String login() {
		return "login";// Ìø×ªµ½"/WEB-INF/jsp/login.jsp"
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/admin/find")
	public String adfind() {
		return "adminQuery";
	}
	
	@RequestMapping("/admin/profile")
	public String adprofile() {
		return "adminProfile";
	}
	
	@RequestMapping("/activity/find")
	public String acfind() {
		return "activityQuery";
	}
	
	@RequestMapping("/activity/profile")
	public String acprofile() {
		return "activityProfile";
	}

	@RequestMapping("/customer/find")
	public String cufind() {
		return "customerQuery";
	}
	
	@RequestMapping("/customer/profile")
	public String cuprofile() {
		return "customerProfile";
	}

	@RequestMapping("/feedback/find")
	public String fefind() {
		return "feedbackQuery";
	}
	
	@RequestMapping("/feedback/profile")
	public String feprofile() {
		return "feedbackProfile";
	}

	@RequestMapping("/product/find")
	public String prfind() {
		return "productQuery";
	}
	
	@RequestMapping("/product/profile")
	public String prprofile() {
		return "productProfile";
	}

	@RequestMapping("/supplier/find")
	public String sufind() {
		return "supplierQuery";
	}
	
	@RequestMapping("/supplier/profile")
	public String suprofile() {
		return "supplierProfile";
	}
}
