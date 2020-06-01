package com.challenge.repository;

import com.challenge.entity.Company;
import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findById(Long userId);


    @Query(value = "select * from USERS u " +
            "INNER JOIN CANDIDATE c " +
            "ON u.id = c.user_Id " +
            "INNER JOIN ACCELERATION a " +
            "ON c.acceleration_Id = a.id " +
            "where a.name = :name", nativeQuery = true)
    List<User> findByAccelerationName(@Param("name") String name);

    @Query(value = "select * from USERS u " +
            "INNER JOIN CANDIDATE c " +
            "ON u.id = c.user_Id " +
            "where c.company_Id = :companyId", nativeQuery = true)
    List<User> findByCompanyId(@Param("companyId") Long companyId);

}
