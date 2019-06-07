package com.ll.dao;

import java.util.List;

import com.ll.pojo.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin admin);

    int insertSelective(Admin admin);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin admin);

    int updateByPrimaryKey(Admin admin);

	Admin findByAdminAndPass(Admin admin);
	
	List<Admin> selectAllAdmin();
	
	//通过用户名查询用户
	Admin selectByAname(String aname);
}