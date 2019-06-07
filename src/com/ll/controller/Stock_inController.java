package com.ll.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ll.pojo.Stock_in;
import com.ll.service.Stock_inService;

@Controller
@RequestMapping("/stock_in")
public class Stock_inController {

	private static final Log logger = LogFactory.getLog(Stock_inController.class);
	@Autowired
	public Stock_inService stock_inService;
	
	
	@RequestMapping(value = "/list")
	public String listStock_ins(Model model) {
		List<Stock_in> stock_ins = stock_inService.getStock_ins();
		model.addAttribute("stock_ins", stock_ins);
		return "stock_inList";
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model) {
		return "main";
	}
}
