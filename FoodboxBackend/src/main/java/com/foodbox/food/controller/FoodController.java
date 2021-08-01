package com.foodbox.food.controller;

import com.foodbox.food.dao.FoodDaoImpl;
import com.foodbox.food.model.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:4200")
public class FoodController {

    @Autowired
    FoodDaoImpl foodDao;

    @RequestMapping(value = "/menu")
    public List<Food> getMenu(Model model) {
        List<Food> foodItems ;
        foodItems = foodDao.getFoodList();
        return foodItems;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable(value = "id") int id)
    {
    	Food food = foodDao.getFoodById(id);
        return ResponseEntity.ok().body(food);
    }
    
    @PutMapping("/updateData/{id}")
    public ResponseEntity<Food> updateData(@PathVariable(value = "id") int id,@RequestBody Food food)  {
    	final Food updatedFood = foodDao.updatetData(food);
        return ResponseEntity.ok(updatedFood);
    }
   
    @DeleteMapping("/deleteItem")
    public void deleteItem(@RequestParam(name = "id") int id) {
    	foodDao.deleteItem(id);
    }

}
