package com.challenge.service;

import com.challenge.entity.Candidate;
import com.challenge.entity.Company;
import com.challenge.repository.CandidateRepository;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements CompanyServiceInterface {

    @Autowired
    private CompanyRepository companyRepository;
    private CandidateService candidateService;

    @Override
    public Optional<Company> findById(Long id) {
        return this.companyRepository.findById(id);
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId) {
        return this.companyRepository.findByAccelerationId(accelerationId);
        //return this.companyRepository.findDistinctCompanyByCandidatesIdAccelerationId(accelerationId);
    }

    @Override
    public List<Company> findByUserId(Long userId) {
        return this.companyRepository.findByUserId(userId);
    }

    @Override
    public Company save(Company object) {
        object.setCreatedAt(LocalDateTime.now());
        return this.companyRepository.save(object);
    }

}
