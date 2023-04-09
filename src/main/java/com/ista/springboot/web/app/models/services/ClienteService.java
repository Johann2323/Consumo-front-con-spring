package com.ista.springboot.web.app.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ista.springboot.web.app.models.dao.ClienteRepository;
import com.ista.springboot.web.app.models.entity.cliente;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository userRepository;

    public void saveUser(cliente user) {
        userRepository.save(user);
    }
}
