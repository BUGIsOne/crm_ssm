package com.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.dao.ProductMapper;
import com.ll.pojo.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductMapper productDao;
	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.updateByPrimaryKeySelective(product);
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		List<Product> list = productDao.selectAllProduct();
		return list;
	}

	@Override
	public Product findProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.findByPnumAndSid(product);
	}

	@Override
	public Product findProductByPname(String pname) {
		// TODO Auto-generated method stub
		return productDao.selectByPname(pname);
	}

	@Override
	public void deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		productDao.deleteByPrimaryKey(id);
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		int result = productDao.insertSelective(product);
		if (1 == result) {
			return true;
		} else {
			return false;
		}
	}

}
