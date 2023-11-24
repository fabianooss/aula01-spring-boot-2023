/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.aula01.controller;

import com.senac.aula01.model.Carro;
import com.senac.aula01.model.CarroNomeCor;
import com.senac.aula01.repository.CarroRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fabiano.oss
 */
@RestController
@RequestMapping("carro")
@CrossOrigin(origins = "*")
public class CarroController {
    
    @Autowired
    private CarroRepository repository;
    
    
    @GetMapping("/carroNomeCor")
    public List<CarroNomeCor> findCarroNomeCor() {
       return repository.findCarroNomeCor();
    }
    
    @GetMapping
    public List<Carro> findAll() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Optional<Carro> result = repository.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.of(result);
        }
        return ResponseEntity.notFound().build();
    }
    

    @PostMapping
    public void save(@RequestBody Carro carro) {
        if (carro.getComentarios() != null) {
            carro.getComentarios().stream().forEach(c -> c.setCarro(carro));
        }
        repository.save(carro);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        
    }
    
}
