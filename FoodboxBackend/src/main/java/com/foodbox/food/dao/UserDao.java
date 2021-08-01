package com.foodbox.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodbox.food.model.User;

public interface UserDao extends JpaRepository<User,String> {
}
