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

import com.ll.pojo.Product;
import com.ll.pojo.Product;
import com.ll.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {


	private static final Log logger = LogFactory.getLog(ProductController.class);
	@Autowired
	public ProductService productService;

	/*
	 * 查询
	 */
	 @RequestMapping("/find")
	 public String findProduct(@Param("pname") String pname, Model model){
		Product findProduct = productService.findProductByPname(pname);  //根据aitem获取用户详情
    	model.addAttribute("findProduct", findProduct);
    	logger.info("【操作】：根据pname查询用户详情...");
    	return "productFind";
    }
	 /*
	  * 删除
	  */
	 @RequestMapping("/delete")
	 public String delete(Product product, HttpSession session, Model model) {
		 Product product2 = (Product) session.getAttribute("u");
		 productService.deleteByPrimaryKey(product2.getId());
		 logger.info("删除成功");
		 return "main";
	}
	
	
	/**
	 * 保存物资资料
	 */
	@RequestMapping(value="/profile",method=RequestMethod.POST)
	public String saveProfile(@ModelAttribute("product") Product product) {
		productService.updateProduct(product);
		logger.info("更新成功");
		return "main";// 注册成功，跳转到login.jsp
	}
	
	@RequestMapping(value = "/list")
	public String listProducts(Model model) {
		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);
		return "productList";
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model) {
		return "main";
	}
}
