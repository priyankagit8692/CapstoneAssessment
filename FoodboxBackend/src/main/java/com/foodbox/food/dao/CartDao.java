package com.foodbox.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodbox.food.model.Cart;
import com.foodbox.food.model.Food;

public interface CartDao extends JpaRepository<Cart,Integer> {
	public Food findById(int id);

	
}
