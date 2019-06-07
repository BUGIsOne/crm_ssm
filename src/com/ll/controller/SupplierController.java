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
	 public String findSupplier(@Param("sname") String sname, Model model){
		Supplier findSupplier = supplierService.findSupplierBySname(sname);  //根据aitem获取用户详情
    	model.addAttribute("findSupplier", findSupplier);
    	logger.info("【操作】：根据sname查询用户详情...");
    	return "supplierFind";
    }
	 /*
	  * 删除
	  */
	 @RequestMapping("/delete")
	 public String delete(Supplier supplier, HttpSession session, Model model) {
		 Supplier supplier2 = (Supplier) session.getAttribute("u");
		 supplierService.deleteByPrimaryKey(supplier2.getId());
		 logger.info("删除成功");
		 return "main";
	}
	
	
	/**
	 * 保存供货商资料
	 */
	@RequestMapping(value="/profile",method=RequestMethod.GET)
	public String getProfile(HttpSession session,Model model) {
		Supplier supplier = (Supplier) session.getAttribute("u");
		if (null == supplier) {
			return "redirect:login";
		}
		// 从数据表获取最新数据
		supplier = supplierService.findSupplier(supplier);		
		model.addAttribute("supplier", supplier);

		return "supplierProfile";// 返回用户资料填写页
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
