package com.foodbox.food.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodbox.food.model.Cart;
import com.foodbox.food.model.Food;
import com.foodbox.food.model.NewCart;
import com.foodbox.food.model.NewFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CartDaoImpl{

	@Autowired
    CartDao cartDao;

    @Autowired
    FoodDao foodDao;

    @Value("${fileStorage}")
    private String storagePath;

    public void saveToCart(NewCart[] newCarts){
        cartDao.deleteAll();
        cartDao.flush();
        Cart cart= new Cart(1,0,0,0,0,0,0,0);
        cart.setQuantity1(newCarts[0].getQuantity());
        if(newCarts.length>1)
        	cart.setQuantity2(newCarts[1].getQuantity());
        if(newCarts.length>2)
        	cart.setQuantity3(newCarts[2].getQuantity());
        if(newCarts.length>3)
            cart.setQuantity4(newCarts[3].getQuantity());
        if(newCarts.length>4)
            cart.setQuantity5(newCarts[4].getQuantity());
        if(newCarts.length>5)
            cart.setQuantity6(newCarts[5].getQuantity());
        if(newCarts.length>6)
            cart.setQuantity6(newCarts[6].getQuantity());
        if(newCarts.length>7)
            cart.setQuantity6(newCarts[7].getQuantity());
        cartDao.save(cart);
    }


    public List<Cart> getAllCart(){
        return cartDao.findAll();
    }

    public void addItems(NewCart[] cart){
        List<Food> foods = foodDao.findAll();
        for(int i=0;i<foods.size();i++){
            foods.get(i).setQuantity(foods.get(i).getQuantity()+cart[i].getQuantity());
        }
        foodDao.saveAll(foods);
    }

    public boolean addNewItem(MultipartFile file, String newFoodData) throws IOException {
        NewFood newFood = new ObjectMapper().readValue(newFoodData,NewFood.class);
        if(!file.isEmpty())
        if(saveFileToAssets(file))
        {
            foodDao.save(new Food(newFood.getId(),newFood.getName(),newFood.getPrice(),newFood.getQuantityAvailable(),"/assets/"+file.getOriginalFilename(),"",""));
//            foodDao.save(new Food(newFood.getId(),newFood.getName(),newFood.getPrice(),newFood.getQuantityAvailable(),"\\"+file.getOriginalFilename(),"",""));
        }
        return true;
    }

    public boolean addNewItemWithUrl(String newFoodData) throws IOException {
        NewFood newFood = new ObjectMapper().readValue(newFoodData,NewFood.class);
        foodDao.save(new Food(newFood.getId(),newFood.getName(),newFood.getPrice(),newFood.getQuantityAvailable(),newFood.getFileDataF(),"",""));
        return true;
    }

    private boolean saveFileToAssets(MultipartFile file) throws IOException {
        Path filepath = Paths.get(storagePath, file.getOriginalFilename());
        file.transferTo(filepath);
        return true;
    }

    public int claculateTotal(NewCart[] newCart){
        int total=0;
        List<Food> foods = foodDao.findAll();

        for(int i=0;i<foods.size();i++)
        {
            total+=foods.get(i).getPrice()*newCart[i].getQuantity();
        }
        return total;
    }

    public boolean itemIdAvailable(int itemId) {
    	String itemID = String.valueOf(itemId);
        return foodDao.findById(itemId)!=null;
    }
}
