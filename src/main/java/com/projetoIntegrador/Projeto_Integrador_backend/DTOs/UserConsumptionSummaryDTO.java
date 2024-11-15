package com.projetoIntegrador.Projeto_Integrador_backend.DTOs;

import java.util.List;

public class UserConsumptionSummaryDTO {

    private List<ConsumptionDTO> consumptions;
    private double totalCalories;

    public UserConsumptionSummaryDTO(List<ConsumptionDTO> consumptions, double totalCalories) {
        this.consumptions = consumptions;
        this.totalCalories = totalCalories;
    }

    // Getters e Setters
    public List<ConsumptionDTO> getConsumptions() {
        return consumptions;
    }

    public void setConsumptions(List<ConsumptionDTO> consumptions) {
        this.consumptions = consumptions;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }
}
