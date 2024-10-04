package com.projetoIntegrador.Projeto_Integrador_backend.repositories;

import com.projetoIntegrador.Projeto_Integrador_backend.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository <Food, Long>{

    Food findFoodById(Long foodid);

}
