package com.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.dao.FeedbackMapper;
import com.ll.pojo.Feedback;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private FeedbackMapper feedbackDao;
	@Override
	public void updateFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		feedbackDao.updateByPrimaryKeySelective(feedback);
	}

	@Override
	public List<Feedback> getFeedbacks() {
		List<Feedback> list = feedbackDao.selectAllFeedback();
		return list;
	}

	@Override
	public Feedback findFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return feedbackDao.findByPidAndCid(feedback);
	}

	@Override
	public Feedback findFeedbackByCid(Integer cid) {
		// TODO Auto-generated method stub
		return feedbackDao.selectByCid(cid);
	}

	@Override
	public void deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		feedbackDao.deleteByPrimaryKey(id);
	}

	@Override
	public boolean addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		int result = feedbackDao.insertSelective(feedback);
		if (1 == result) {
			return true;
		} else {
			return false;
		}
	}
}
