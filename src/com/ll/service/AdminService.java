package com.ll.service;

import java.util.List;

import com.ll.pojo.Admin;


public interface AdminService {

	Admin login(Admin admin);
	boolean register(Admin admin);
	void updateAdmin(Admin admin);
	List<Admin> getAdmins();
	//根据id获取用户详情
	Admin findAdminById(Integer id);
	//根据用户名获取用户
	Admin findAdminByAname(String aname);
	void deleteByPrimaryKey(Integer id);
}
