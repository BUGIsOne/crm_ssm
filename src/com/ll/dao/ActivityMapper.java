package com.ll.dao;

import java.util.List;

import com.ll.pojo.Activity;

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

	List<Activity> selectAllActivity();
	
	Activity findByUidAndCus(Activity record);
	
	Activity selectByAitem(String aitem);
}