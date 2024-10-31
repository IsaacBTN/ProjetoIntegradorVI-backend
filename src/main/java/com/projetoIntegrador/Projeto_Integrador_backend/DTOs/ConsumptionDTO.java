package com.projetoIntegrador.Projeto_Integrador_backend.DTOs;

import com.projetoIntegrador.Projeto_Integrador_backend.entities.Consumption;
import com.projetoIntegrador.Projeto_Integrador_backend.entities.Food;
import com.projetoIntegrador.Projeto_Integrador_backend.entities.User;

import java.time.LocalDateTime;
import java.util.List;

public class ConsumptionDTO {

    private Long id;

    private LocalDateTime consumedAt;

    private UserDTO user;

    private FoodDTO foods;

    private double quantity;

    private double caloriaTotal;


    public ConsumptionDTO(Long id, LocalDateTime consumedAt, UserDTO user, FoodDTO food) {
        this.id = id;
        this.consumedAt = LocalDateTime.now();
        this.user = user;
        this.foods = foods;

    }

    public static ConsumptionDTO transformaConsumptionDTO(Consumption consumption){
        return new ConsumptionDTO(consumption.getId(),consumption.getConsumedAt(),consumption.getUser(),consumption.getFoodDTO());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getConsumedAt() {
        return consumedAt;
    }


    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public FoodDTO getFoods() {
        return foods;
    }

    public void setFoods(FoodDTO foods) {
        this.foods = foods;
    }
}
