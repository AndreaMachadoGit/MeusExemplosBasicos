package com.challenge.repository;

import com.challenge.entity.Acceleration;
import com.challenge.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {

    List<Acceleration> findByCandidatesIdCompanyId(Long companyId);

}
