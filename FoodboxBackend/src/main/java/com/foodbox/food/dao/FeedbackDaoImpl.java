package com.foodbox.food.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.food.model.Feedback;

@Service
public class FeedbackDaoImpl{

    @Autowired
    FeedbackDao feedbackDao;

    public boolean saveMessage(Feedback contact){
    	feedbackDao.save(contact);
        return true;
    }
}
