package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByCandidatesIdAccelerationName(String name);

    List<User> findByCandidatesIdCompanyId(Long companyId);

    Page<User> findAll(Pageable pageable);

    Page<User> findByNicknameContaining(String nickname, Pageable pageable);

}