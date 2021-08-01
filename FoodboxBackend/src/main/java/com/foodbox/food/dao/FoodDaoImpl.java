package com.foodbox.food.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodbox.food.model.Food;

import java.util.List;

@Service
public class FoodDaoImpl {

    @Autowired
    private FoodDao foodDao;


    public List<Food> getFoodList(){
        List<Food> food;
        food = foodDao.findAll();
        return food;
    }

    public Food validateFoodInfo(int productId){
        Food food = null;
        food = foodDao.findById(productId);
        return food;
    }
    
   @Transactional
   public Food updatetData(Food food) {
		Integer id = food.getId();
		Food fd = foodDao.findById(id).get();
		fd.setItem(food.getItem());
		fd.setPrice(food.getPrice());
		fd.setQuantity(food.getQuantity());
		return foodDao.save(fd);
		
   }

    public Food getFoodById(int id) {
    	
		Food fd = foodDao.findById(id);
		return fd;
    }
   
	          
    @Transactional
    public void deleteItem(int id) {
    	foodDao.deleteById(id);
    }

}

