package com.foodbox.food.controller;

import com.foodbox.food.dao.CartDaoImpl;
import com.foodbox.food.model.Cart;
import com.foodbox.food.model.NewCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin("http://localhost:4200")
public class CartController {

	 @Autowired
	   CartDaoImpl cartDao;


	    @PostMapping("/cart")
	    public int getTotal(@RequestBody NewCart[] cart, Model model){
	        cartDao.saveToCart(cart);
	        return cartDao.claculateTotal(cart);
	    }


	    @PostMapping("/addToCart")
	    public NewCart[] increaseQuantity(@RequestBody NewCart[] cart, Model model){
	        cartDao.addItems(cart);
	        return cart;
	    }

	    @PostMapping("/addNewItem")
	    public boolean addNewItem(@RequestParam("file") MultipartFile file, @RequestParam("newFoodItem") String newFoodData) throws IOException {
	        return cartDao.addNewItem(file,newFoodData);
	    }


	    @PostMapping("/addNewItemUrl")
	    public boolean addNewItemByUrl(@RequestParam("newFoodItem") String newFoodData) throws IOException {
	        return cartDao.addNewItemWithUrl(newFoodData);
	    }
	    @PostMapping("/checkItemId")
	    public boolean checkItemId(@RequestBody int itemId, Model model){
	        return !cartDao.itemIdAvailable(itemId);
	    }

	  
}
