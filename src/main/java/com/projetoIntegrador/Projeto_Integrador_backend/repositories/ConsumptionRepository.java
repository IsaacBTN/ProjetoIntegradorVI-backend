package com.projetoIntegrador.Projeto_Integrador_backend.repositories;

import com.projetoIntegrador.Projeto_Integrador_backend.entities.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {
    List<Consumption> findByUserId(Long userId);

    @Query("SELECT SUM(c.food.calories * c.quantity) FROM Consumption c WHERE c.user.id = :userId")
    Double sumCaloriesByUserId(@Param("userId") Long userId);
}
