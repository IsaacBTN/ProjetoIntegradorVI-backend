package com.projetoIntegrador.Projeto_Integrador_backend.controllers;

import com.projetoIntegrador.Projeto_Integrador_backend.entities.Consumption;
import com.projetoIntegrador.Projeto_Integrador_backend.services.ConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consumptions")
public class ConsumptionController {

    @Autowired
    private ConsumptionService consumptionService;

    @GetMapping
    public List<Consumption> getAllConsumptions(){
        return consumptionService.getAllConsumptions();
    }

    @GetMapping("/{id}")
    public Optional<Consumption> getConsumptionById(@PathVariable Long id) {
        return consumptionService.getConsumptionById(id);
    }

    @PostMapping
    public Consumption createConsumption(@RequestBody Consumption consumption) {
        return consumptionService.saveConsumption(consumption);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Consumption>> getConsumptionsByUserId(@PathVariable Long userId) {
        List<Consumption> consumptions = consumptionService.getConsumptionsByUserId(userId);
        if (consumptions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(consumptions);
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


