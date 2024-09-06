package com.projetoIntegrador.Projeto_Integrador_backend.controllers;

import com.projetoIntegrador.Projeto_Integrador_backend.DTOs.UserDTO;
import com.projetoIntegrador.Projeto_Integrador_backend.entities.User;
import com.projetoIntegrador.Projeto_Integrador_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser(){
        List<User> users = userService.getAllUsers();
        List<UserDTO> userDTOS  =users.stream() .map(UserDTO::new)  // Converte cada User em UserDTO
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDTOS);
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
         return ResponseEntity.ok(new UserDTO(user));
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id,user);
    }







}
