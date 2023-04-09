package com.ista.springboot.web.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ista.springboot.web.app.models.entity.cliente;

@Repository
public interface ClienteRepository extends JpaRepository<cliente, Long> {
    
}
