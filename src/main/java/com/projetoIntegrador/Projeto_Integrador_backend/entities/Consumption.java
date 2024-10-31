package com.projetoIntegrador.Projeto_Integrador_backend.entities;

import com.projetoIntegrador.Projeto_Integrador_backend.DTOs.FoodDTO;
import com.projetoIntegrador.Projeto_Integrador_backend.DTOs.UserDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_consumption")
public class Consumption {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime consumedAt;

    private double quantity;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "food_id",nullable = false)
    private Food food;



    public Consumption(Long id, LocalDateTime consumedAt, double quantity, User user, Food food) {
        this.id = id;
        this.consumedAt = consumedAt;
        this.quantity = quantity;
        this.user = user;
        this.food = food;
    }

    public Consumption() {
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

    public void setConsumedAt(LocalDateTime consumedAt) {
        this.consumedAt = consumedAt;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public UserDTO getUser() {
        return UserDTO.transforma(user);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FoodDTO getFoodDTO() {
        return FoodDTO.transformaFoodDTO(food);
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
