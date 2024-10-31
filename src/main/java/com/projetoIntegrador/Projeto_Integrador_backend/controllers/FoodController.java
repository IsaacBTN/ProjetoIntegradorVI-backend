package com.projetoIntegrador.Projeto_Integrador_backend.controllers;

import com.projetoIntegrador.Projeto_Integrador_backend.DTOs.FoodDTO;
import com.projetoIntegrador.Projeto_Integrador_backend.entities.Food;
import com.projetoIntegrador.Projeto_Integrador_backend.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    public List<FoodDTO> getAllFoods(){
         List <Food> foods = foodService.getAllFood();
         List<FoodDTO> foodDTOS = foods.stream().map(FoodDTO::transformaFoodDTO).collect(Collectors.toList());
         return foodDTOS;
    }

    @GetMapping("/{id}")
    public FoodDTO getFoodById (@PathVariable Long id){
       Food food = foodService.getFoodById(id);
       FoodDTO foodDTO = FoodDTO.transformaFoodDTO(food);
       return foodDTO;
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
