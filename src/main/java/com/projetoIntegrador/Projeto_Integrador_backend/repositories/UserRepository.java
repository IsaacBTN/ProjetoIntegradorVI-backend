package com.projetoIntegrador.Projeto_Integrador_backend.repositories;

import com.projetoIntegrador.Projeto_Integrador_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
