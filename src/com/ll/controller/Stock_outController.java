package com.ll.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ll.pojo.Stock_out;
import com.ll.service.Stock_outService;

@Controller
@RequestMapping("/stock_out")
public class Stock_outController {
	private static final Log logger = LogFactory.getLog(Stock_outController.class);
	@Autowired
	public Stock_outService stock_outService;
	
	
	@RequestMapping(value = "/list")
	public String listStock_outs(Model model) {
		List<Stock_out> stock_outs = stock_outService.getStock_outs();
		model.addAttribute("stock_outs", stock_outs);
		return "stock_outList";
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model) {
		return "main";
	}
}
