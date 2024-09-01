package com.projetoIntegrador.Projeto_Integrador_backend.services;

import com.projetoIntegrador.Projeto_Integrador_backend.entities.Food;
import com.projetoIntegrador.Projeto_Integrador_backend.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    public List<Food> getAllFood(){
        return foodRepository.findAll();
    }

    public Food getFoodById (Long id){
        return foodRepository.findById(id).orElse(null);
    }

    public Food addFood(Food food){
        return foodRepository.save(food);
    }

    public void deleteFoodById(Long id){
        foodRepository.deleteById(id);
    }

    public Food updateFood(Long id, Food updatedFood) {
        return foodRepository.findById(id)
                .map(food -> {
                    food.setName(updatedFood.getName());
                    food.setCalories(updatedFood.getCalories());
                    return foodRepository.save(food);
                }).orElseThrow(() -> new RuntimeException("Comida com o id: " + id + "não foi encontrada"));

}}
