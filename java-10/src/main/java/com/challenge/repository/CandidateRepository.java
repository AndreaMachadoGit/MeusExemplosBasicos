package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository  extends CrudRepository<Candidate,Long> {

    Optional<Candidate> findById(CandidateId id);

    @Query(value = "select * from CANDIDATE c " +
            "where c.company_Id = :companyId and c.user_Id = :userId and c.acceleration_Id = :accelerationId ", nativeQuery = true)
    Optional<Candidate> findById(@Param("userId") Long userId, @Param("companyId") Long companyId, @Param("accelerationId") Long accelerationId);

    @Query(value = "select * from CANDIDATE c " +
            "where c.company_Id = :companyId", nativeQuery = true)
    List<Candidate> findByCompanyId(@Param("companyId") Long companyId);

    @Query(value = "select * from CANDIDATE c " +
            "where c.acceleration_Id = :accelerationId", nativeQuery = true)
    List<Candidate> findByAccelerationId(@Param("accelerationId") Long accelerationId);

}
