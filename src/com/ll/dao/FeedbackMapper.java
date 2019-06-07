package com.ll.dao;

import java.util.List;

import com.ll.pojo.Feedback;

public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);
    
    Feedback findByPidAndCid(Feedback record);
    
	List<Feedback> selectAllFeedback();
	
	Feedback selectByCid(Integer cid);
}