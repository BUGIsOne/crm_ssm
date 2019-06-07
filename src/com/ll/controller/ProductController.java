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
	 public String findProduct(@Param("pname") String pname, HttpSession session, Model model){
		Product findProduct = productService.findProductByPname(pname);  //根据aitem获取用户详情
		//建立session，处理删除操作是方便传值
		session.setAttribute("product", findProduct);
    	model.addAttribute("findProduct", findProduct);
    	logger.info("【操作】：根据pname查询用户详情...");
    	return "productFind";
    }
	 /*
	  * 删除
	  */
	 @RequestMapping("/delete")
	 public String delete(Product product, HttpSession session, Model model) {
		 Product product2 = (Product) session.getAttribute("product");
		 productService.deleteByPrimaryKey(product2.getId());
		 logger.info("删除成功");
		 return "main";
	}
	
	 /**
	 * 添加新产品
	 */
	@RequestMapping(value="/profile")
	public String profile(@ModelAttribute("product") Product product) {
		if (productService.addProduct(product)) {
			logger.info("成功");
			return "main";// 注册成功，跳转到login.jsp
		} else {
			logger.info("失败");
			// 使用@ModelAttribute("product")与model.addAttribute("product", product)功能相同
			// 在register.jsp页面上可以使用EL表达式${product.uname}取出ModelAttribute的uname值
			return "productProfile";// 返回register.jsp
		}
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
