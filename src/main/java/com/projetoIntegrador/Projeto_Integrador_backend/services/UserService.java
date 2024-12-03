package com.projetoIntegrador.Projeto_Integrador_backend.services;

import com.projetoIntegrador.Projeto_Integrador_backend.entities.User;
import com.projetoIntegrador.Projeto_Integrador_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado :: " + userId));
    }


    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public User addUser ( User user){
        return userRepository.save(user);
    }


    public User updateUser(Long id, User userDetails){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado :: " + id));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());

        return userRepository.save(user);
    }

    public void setObjetivo(Long userId, int objetivoCaloria, int objetivoAgua) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        user.setObjetivoCaloria(objetivoCaloria);
        user.setObjetivoAgua(objetivoAgua);
        userRepository.save(user);
    }

    public void addWater(Long userId, int waterAmount) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        int updatedWaterConsumption = user.getConsumoAguaAtual() + waterAmount;
        user.setConsumoAguaAtual(updatedWaterConsumption);
        userRepository.save(user);
    }

    public Map<String, Object> getProgress(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        Map<String, Object> progress = new HashMap<>();
        progress.put("ObjetivoCaloriaDiaria", user.getObjetivoCaloria());
        progress.put("ObjetivoDeAguaDiario", user.getObjetivoAgua());
        progress.put("ConsumoDeAguaAtual", user.getConsumoAguaAtual());
        progress.put("QuantidadeFaltanteDeAgua", user.getObjetivoAgua() - user.getConsumoAguaAtual());
        return progress;
    }
}
