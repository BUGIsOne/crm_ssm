package com.ll.service;

import java.util.List;

import com.ll.pojo.Product;

public interface ProductService {

	void updateProduct(Product product);
	List<Product> getProducts();
	Product findProduct(Product product);
	Product findProductById(Integer id);
	Product findProductByPname(String pname);
	//删除产品就是出货量，随着出货量改变出货单
	void deleteByPrimaryKey(Integer id);
	//添加新产品 ,随着进出货的量改变进货单
	boolean addProduct(Product product);
}
