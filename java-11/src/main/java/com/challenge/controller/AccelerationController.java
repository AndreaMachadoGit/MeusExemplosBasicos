package com.challenge.controller;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationService accelerationService;

    /*@GetMapping
    public Iterable<Acceleration> findAll(@PathParam("nome") String nome, Pageable pageable) {
        if (nome != null) {
            return this.accelerationService.findByName(nome.toString(), pageable);
        }
        return this.accelerationService.findAll(pageable);
    }
    */

    @GetMapping("/{id}")
    public Optional<Acceleration> findById(@PathVariable("id") Long id) {
        //Optional<Acceleration> acceleration = accelerationService.findById(id);
        return accelerationService.findById(id);
    }

    @GetMapping
    public List<Acceleration> findByCompanyId(@PathParam("companyId") Long companyId) {
        return accelerationService.findByCompanyId(companyId);
    }

}
