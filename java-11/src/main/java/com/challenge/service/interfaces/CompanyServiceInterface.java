package com.challenge.service.interfaces;

import com.challenge.entity.Challenge;
import com.challenge.entity.Company;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CompanyServiceInterface extends ServiceInterface<Company> {

    Optional<Company> findById(Long id);

    List<Company> findByAccelerationId(Long accelerationId);

    List<Company> findByUserId(Long userId);

}
