package com.projetoIntegrador.Projeto_Integrador_backend.repositories;

import com.projetoIntegrador.Projeto_Integrador_backend.entities.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {
}
