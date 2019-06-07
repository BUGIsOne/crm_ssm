package com.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.dao.ProductMapper;
import com.ll.dao.Stock_inMapper;
import com.ll.dao.Stock_outMapper;
import com.ll.pojo.Product;
import com.ll.pojo.Stock_in;
import com.ll.pojo.Stock_out;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductMapper productDao;
	@Autowired
	private Stock_inMapper stock_inDao;
	@Autowired
	private Stock_outMapper stock_outDao;
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
		//添加出货记录
		Product product = findProductById(id);
		
		Stock_out stock_out = new Stock_out();
		stock_out.setNumberOut(product.getPnumber());
		stock_out.setCid(5);
		stock_out.setPnum(product.getPnum());
				
		stock_outDao.insertSelective(stock_out);
		System.out.println(stock_out);

		productDao.deleteByPrimaryKey(id);
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		int result = productDao.insertSelective(product);
		if (1 == result) {
			//添加进货记录
			Stock_in stock_in = new Stock_in();
			stock_in.setPnum(product.getPnum());
			stock_in.setSid(product.getSid());
			stock_in.setNumberIn(product.getPnumber());
			System.out.println(stock_in);
			
			int result2 = stock_inDao.insertSelective(stock_in);
			if(1 == result2)
				return true;
			else
				return false;
		} else {
			return false;
		}
	}

	@Override
	public Product findProductById(Integer id) {
		// TODO Auto-generated method stub
		return productDao.selectByPrimaryKey(id);
	}

}
