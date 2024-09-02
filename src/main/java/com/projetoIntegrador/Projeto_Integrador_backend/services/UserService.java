package com.projetoIntegrador.Projeto_Integrador_backend.services;

import com.projetoIntegrador.Projeto_Integrador_backend.entities.User;
import com.projetoIntegrador.Projeto_Integrador_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

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

    public User getUserById(Long userid){
        return userRepository.findById(userid).orElse(null);
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
}
