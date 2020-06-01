package com.challenge.service.interfaces;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Candidate;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CandidateServiceInterface extends ServiceInterface<Candidate> {

    List<Candidate> findAll(Pageable pageable);

    Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);

    List<Candidate> findByCompanyId(Long companyId);

    List<Candidate> findByAccelerationId(Long accelerationId);
}
