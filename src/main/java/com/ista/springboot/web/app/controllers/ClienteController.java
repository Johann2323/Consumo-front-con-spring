package com.ista.springboot.web.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ista.springboot.web.app.models.dao.ClienteRepository;
import com.ista.springboot.web.app.models.entity.cliente;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository userRepository;
    
    @GetMapping("/users/new")
    public String newUser(Model model) {
        model.addAttribute("user", new cliente());
        return "new-user";
    }
    
    @PostMapping("/users/new")
    public String createUser(@Valid cliente user, BindingResult result) {
        if (result.hasErrors()) {
            return "new-user";
        }
        
        userRepository.save(user);
        return "redirect:/users";
    }
    
    @GetMapping("/users")
    public String getUsers(Model model) {
        List<cliente> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }
}