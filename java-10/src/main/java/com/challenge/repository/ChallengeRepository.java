package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends CrudRepository<Challenge,Long> {


    @Query(value = "select * from CHALLENGE c " +
            "INNER JOIN ACCELERATION a " +
            "ON c.id = a.challenge_Id " +
            "INNER JOIN CANDIDATE ca " +
            "ON ca.acceleration_Id = a.Id " +
            "where a.id = :accelerationId and ca.user_id = :userId ", nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId,@Param("userId")  Long userId);

}
