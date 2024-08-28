package com.projetoIntegrador.Projeto_Integrador_backend.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double calories;
    private double quantity;

    @OneToMany(mappedBy = "food")
    private List<Consumption> consumptions;

    public Food(Long id, String name, double calories, double quantity) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.quantity = quantity;
    }

    public Food() {
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

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
