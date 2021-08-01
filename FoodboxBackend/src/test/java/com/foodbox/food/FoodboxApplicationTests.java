package com.foodbox.food;

import com.foodbox.food.dao.CartDaoImpl;
import com.foodbox.food.dao.FoodDaoImpl;
import com.foodbox.food.dao.UserDao;
import com.foodbox.food.dao.UserDaoImpl;
import com.foodbox.food.model.Cart;
import com.foodbox.food.model.Food;
import com.foodbox.food.model.Login;
import com.foodbox.food.model.User;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodboxApplicationTests {

    @Autowired
    UserDao userDao;

    @Autowired
    UserDaoImpl userDaoImpl;

    @Autowired
    FoodDaoImpl foodDao;

    @Autowired
    CartDaoImpl cartDao;

    @Test
    public void contextLoads() {
        Login login = new Login();
        login.setUsername("amank");
        login.setPassword("abcd1234");

        User user = userDaoImpl.validateUser(login);
        Assert.assertEquals("Aman",user.getFirstname());
        Assert.assertEquals("Kumar",user.getLastname());
        Assert.assertEquals("aman@gmail.com",user.getEmail());
        Assert.assertEquals(9585418,user.getPhone());
    }
//
//    @Test
//    public void checkFoodTable(){
//        Food food = new Food();
//        food.setId("abc");
//        Food food1 = foodDao.validateFoodInfo(food.getId());
//        Assert.assertEquals("Coffee",food1.getItem());
//        Assert.assertEquals(50,food1.getPrice());
//    }

    @Test
    public void checkCartDb(){
        List<Cart> carts = cartDao.getAllCart();
        Cart zero = carts.get(0);
        Assert.assertEquals(0,zero.getQuantity1());
        Assert.assertEquals(0,zero.getQuantity2());
        Assert.assertEquals(0,zero.getQuantity3());
    }

    /*Test*/


}
