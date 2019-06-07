package com.ll.service;

import java.util.List;

import com.ll.pojo.Feedback;

public interface FeedbackService {

	void updateFeedback(Feedback feedback);
	List<Feedback> getFeedbacks();
	Feedback findFeedback(Feedback feedback);
	Feedback findFeedbackByCid(Integer cid);
	void deleteByPrimaryKey(Integer id);
	//添加新服务
	boolean addFeedback(Feedback feedback);
	
}
