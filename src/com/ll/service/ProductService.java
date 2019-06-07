package com.ll.service;

import java.util.List;

import com.ll.pojo.Product;

public interface ProductService {

	void updateProduct(Product product);
	List<Product> getProducts();
	Product findProduct(Product product);
	Product findProductByPname(String pname);
	void deleteByPrimaryKey(Integer id);
}
