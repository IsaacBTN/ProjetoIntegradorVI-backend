package com.projetoIntegrador.Projeto_Integrador_backend.controllers;

import com.projetoIntegrador.Projeto_Integrador_backend.entities.Food;
import com.projetoIntegrador.Projeto_Integrador_backend.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    public List<Food> getAllFoods(){
        return foodService.getAllFood();
    }

    @GetMapping("/{id}")
    public Food getFoodById (@PathVariable Long id){
        return foodService.getFoodById(id);
    }

    @PostMapping
    public Food addFood (@RequestBody Food food){
        return foodService.addFood(food);
    }

    @PutMapping("/{id}")
    public Food updateFood(@PathVariable Long id, @RequestBody Food food){
        return foodService.updateFood(id,food);
    }

    @DeleteMapping("/{id}")
    public void deleteFoodById(@PathVariable Long id){
        foodService.deleteFoodById(id);
    }



}
