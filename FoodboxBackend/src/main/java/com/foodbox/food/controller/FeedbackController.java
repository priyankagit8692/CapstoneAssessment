package com.foodbox.food.controller;

import com.foodbox.food.dao.FeedbackDaoImpl;
import com.foodbox.food.model.Feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class FeedbackController {

    @Autowired
    FeedbackDaoImpl contactDao;

    @PostMapping("/feedback")
    public boolean contactUs(@RequestBody Feedback contact){
        return contactDao.saveMessage(contact);
    }
}
