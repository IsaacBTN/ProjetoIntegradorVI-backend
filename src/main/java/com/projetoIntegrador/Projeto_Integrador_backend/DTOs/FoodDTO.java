package com.projetoIntegrador.Projeto_Integrador_backend.DTOs;

import com.projetoIntegrador.Projeto_Integrador_backend.entities.Food;

public class FoodDTO {

    private Long id;
    private String name;

    private double calories;

    private double quantity;

    public FoodDTO(Long id, String name, double calories, double quantity) {
        this.id = id;
        this.name = name;
        this.calories= calories;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Double getCalories(){
        return calories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static FoodDTO transformaFoodDTO(Food food){
       return new FoodDTO(food.getId(),food.getName(),food.getCalories(), food.getQuantity());
    }
}
