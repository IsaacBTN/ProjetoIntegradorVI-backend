package com.projetoIntegrador.Projeto_Integrador_backend.controllers;

import com.projetoIntegrador.Projeto_Integrador_backend.DTOs.UserDTO;
import com.projetoIntegrador.Projeto_Integrador_backend.entities.User;
import com.projetoIntegrador.Projeto_Integrador_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUser(){
        List<User> users = userService.getAllUsers();
        List<UserDTO> userDTOS = users.stream().map(UserDTO::transforma).collect(Collectors.toList());
        return userDTOS;
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(404).body(null);
        }
        UserDTO userDTO = UserDTO.transforma(user);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id,user);
    }

    @PostMapping("/{id}/objetivos")
    public ResponseEntity<String> setGoals(
            @PathVariable Long id,
            @RequestParam int dailyCalorieGoal,
            @RequestParam int dailyWaterGoal) {
        userService.setObjetivo(id, dailyCalorieGoal, dailyWaterGoal);
        return ResponseEntity.ok("Metas definidas com sucesso!");
    }

    @PostMapping("/{id}/add-agua")
    public ResponseEntity<String> addWater(
            @PathVariable Long id,
            @RequestParam int waterAmount) {
        userService.addWater(id, waterAmount);
        return ResponseEntity.ok("Consumo de água atualizado!");
    }

    @GetMapping("/{id}/progresso")
    public ResponseEntity<Map<String, Object>> getProgress(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getProgress(id));
    }







}
