package com.projetoIntegrador.Projeto_Integrador_backend.services;

import com.projetoIntegrador.Projeto_Integrador_backend.DTOs.FoodDTO;
import com.projetoIntegrador.Projeto_Integrador_backend.entities.Consumption;
import com.projetoIntegrador.Projeto_Integrador_backend.entities.Food;
import com.projetoIntegrador.Projeto_Integrador_backend.entities.User;
import com.projetoIntegrador.Projeto_Integrador_backend.repositories.ConsumptionRepository;
import com.projetoIntegrador.Projeto_Integrador_backend.repositories.FoodRepository;
import com.projetoIntegrador.Projeto_Integrador_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumptionService {

    private final ConsumptionRepository consumptionRepository;
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;

    @Autowired
    public ConsumptionService(FoodRepository foodRepository, UserRepository userRepository, ConsumptionRepository consumptionRepository){
        this.consumptionRepository = consumptionRepository;
        this.foodRepository = foodRepository;
        this.userRepository = userRepository;
    }

    public List<Consumption> getAllConsumptions(){
        return consumptionRepository.findAll();
    }

    public List<Consumption> getConsumptionsByUserId(Long userId) {
        return consumptionRepository.findByUserId(userId);
    }

    public Optional<Consumption> getConsumptionById(Long id){
        return consumptionRepository.findById(id);
    }

    public double calculateTotalCaloriesConsumed(Long userId) {
        List<Consumption> consumptions = consumptionRepository.findByUserId(userId);

        double totalCalories = 0;
        for (Consumption consumption : consumptions) {
            FoodDTO food = consumption.getFoodDTO();

            double calories = food.getCalories() * consumption.getQuantity();

            totalCalories += calories;
        }

        return totalCalories;
    }

    public void deleteConsumpitionById (Long id){
        consumptionRepository.deleteById(id);
    }

    public Consumption saveConsumption (Consumption consumption){
        return consumptionRepository.save(consumption);
    }


    public Consumption updateConsumption(Long id, Consumption updatedConsumption) {
        return consumptionRepository.findById(id)
                .map(consumption -> {
                    consumption.setFood(updatedConsumption.getFood());
                    consumption.setQuantity(updatedConsumption.getQuantity());
                    consumption.setConsumedAt(updatedConsumption.getConsumedAt());
                    return consumptionRepository.save(consumption);
                }).orElseThrow(() -> new RuntimeException("Consumption com  o id: " + id + "não foi encontrada"));






}}
