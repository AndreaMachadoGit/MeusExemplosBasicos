package com.challenge.repository;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccelerationRepository extends CrudRepository<Acceleration,Long> {

    Optional<Acceleration> findById(Long id);

    Optional<Acceleration> findAccelerationById(Long id);

    @Query(value = "select * from ACCELERATION a " +
            "INNER JOIN CANDIDATE c " +
            "ON a.id = c.acceleration_Id " +
            "where c.company_Id = :companyId", nativeQuery = true)
    List<Acceleration> findByCompanyId(@Param("companyId")  Long companyId);

    Optional<Acceleration> findAccelerationByName(String nome);


}
