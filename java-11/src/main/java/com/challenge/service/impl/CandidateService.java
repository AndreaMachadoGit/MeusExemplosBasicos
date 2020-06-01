package com.challenge.service.impl;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Candidate;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CandidateService implements CandidateServiceInterface {

    private CandidateRepository candidateRepository;

    @Override
    public List<Candidate> findAll(Pageable pageable) {
        return this.candidateRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
        return candidateRepository.findByIdUserIdAndIdCompanyIdAndIdAccelerationId(userId, companyId, accelerationId);
    }

    @Override
    public List<Candidate> findByCompanyId(Long companyId) {
        return candidateRepository.findByIdCompanyId(companyId);
    }

    @Override
    public List<Candidate> findByAccelerationId(Long accelerationId) {
        return candidateRepository.findByIdAccelerationId(accelerationId);
    }

}
