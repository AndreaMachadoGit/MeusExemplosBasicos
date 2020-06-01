package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SubmissionRepository extends CrudRepository<Submission, Long> {

    @Query(value = "select Coalesce(MAX(score),0) from SUBMISSION s " +
            "where s.challenge_Id = :challengeId", nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query(value = "select * from SUBMISSION s " +
            "INNER JOIN CHALLENGE c " +
            "ON s.challenge_Id = c.id " +
            "INNER JOIN ACCELERATION a " +
            "ON a.challenge_Id = c.id " +
            "where s.challenge_Id = :challengeId and a.id = :accelerationId ", nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);

}
