package com.challenge.service;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AccelerationService implements AccelerationServiceInterface {

    @Autowired
    private AccelerationRepository accelerationRepository;

    @Override
    public Optional<Acceleration> findById(Long id) {
        return accelerationRepository.findById(id);
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return accelerationRepository.findByCompanyId(companyId);
    }

    @Override
    public Optional<Acceleration> findAccelerationById(Long id) {
        return this.accelerationRepository.findAccelerationById(id);
    }

    @Override
    public Optional<Acceleration> findAccelerationByName(String nome) {
        return this.accelerationRepository.findAccelerationByName(nome);
    }

    @Override
    public Acceleration save(Acceleration object) {
        object.setCreatedAt(LocalDateTime.now());
        return this.accelerationRepository.save(object);
    }

}
