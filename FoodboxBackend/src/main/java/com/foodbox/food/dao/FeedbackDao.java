package com.foodbox.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodbox.food.model.Feedback;

public interface FeedbackDao extends JpaRepository<Feedback,Integer> {
}
