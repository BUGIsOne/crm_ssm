package com.ll.service;

import java.util.List;

import com.ll.pojo.Supplier;



public interface SupplierService {

	void updateSupplier(Supplier supplier);
	List<Supplier> getSuppliers();
	Supplier findSupplier(Supplier supplier);
	Supplier findSupplierBySname(String sname);
	void deleteByPrimaryKey(Integer id);
	//添加新供货商
	boolean addSupplier(Supplier supplier);
}
