package com.projetoIntegrador.Projeto_Integrador_backend.controllers;

import com.projetoIntegrador.Projeto_Integrador_backend.DTOs.ConsumptionDTO;
import com.projetoIntegrador.Projeto_Integrador_backend.DTOs.UserConsumptionSummaryDTO;
import com.projetoIntegrador.Projeto_Integrador_backend.entities.Consumption;
import com.projetoIntegrador.Projeto_Integrador_backend.services.ConsumptionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/consumptions")
public class ConsumptionController {

    private final ConsumptionService consumptionService;

    @Autowired
    public ConsumptionController(ConsumptionService consumptionService) {
        this.consumptionService = consumptionService;
    }

    @GetMapping
    public List<ConsumptionDTO> getAllConsumptions(){
        List<Consumption> consumptions = consumptionService.getAllConsumptions();
        return consumptions.stream()
                .map(ConsumptionDTO::transformaConsumptionDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public List<ConsumptionDTO> getConsumptionById(@PathVariable Long id) {
        List<Consumption> consumptions = consumptionService.getConsumptionsByUserId(id);
        return consumptions.stream()
                .map(ConsumptionDTO::transformaConsumptionDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Consumption> createConsumption(@RequestBody Consumption consumption) {
        Consumption savedConsumption = consumptionService.saveConsumption(consumption);
        return ResponseEntity.ok(savedConsumption);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserConsumptionSummaryDTO> getUserConsumptionSummary(@PathVariable Long userId) {
        UserConsumptionSummaryDTO summary = consumptionService.getUserConsumptionSummary(userId);
        return ResponseEntity.ok(summary);
    }

    @PutMapping("/{id}")
    public Consumption updateConsumption(@PathVariable Long id, @RequestBody Consumption consumption) {
        return consumptionService.updateConsumption(id, consumption);
    }

    @DeleteMapping("/{id}")
    public void deleteConsumption(@PathVariable Long id) {
        consumptionService.deleteConsumpitionById(id);
    }
}
