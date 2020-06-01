package com.challenge.service.interfaces;

import com.challenge.entity.Company;
import com.challenge.entity.Submission;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubmissionServiceInterface extends ServiceInterface<Submission> {
    List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);
}
