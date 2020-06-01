package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    Optional<Company> findById(Long id);


    @Query(value = "select distinct on (company.id) company.* " +
            "from COMPANY company " +
            "inner join CANDIDATE c " +
            "ON company.id = c.company_Id " +
            "where c.acceleration_Id = :accelerationId" , nativeQuery = true)
    List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);

    List<Company> findDistinctCompanyByCandidatesIdAccelerationId(Long accelerationId);

    @Query(value = "select * from COMPANY company " +
            "INNER JOIN CANDIDATE c " +
            "ON company.id = c.company_Id " +
            "where c.user_Id = :userId", nativeQuery = true)
    List<Company> findByUserId(@Param("userId")  Long userId);

}
