package com.foodbox.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin("http://localhost:4200")
public class FoodboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodboxApplication.class, args);
    }

}
