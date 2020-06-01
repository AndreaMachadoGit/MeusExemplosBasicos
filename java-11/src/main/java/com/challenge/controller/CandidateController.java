package com.challenge.controller;

import com.challenge.entity.Candidate;
import com.challenge.exceptions.ResourceNotFoundException;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public List<Candidate> findAll(@PathParam("companyId") Long companyId, @PathParam("accelerationId") Long accelerationId) {
        if (companyId != null) {
            return this.candidateService.findByCompanyId(companyId);
        }
        if (accelerationId != null) {
            return this.candidateService.findByAccelerationId(accelerationId);
        }
        return  null;
    }


    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    public ResponseEntity<Candidate> findById(@PathVariable("userId") Long userId,@PathVariable("companyId") Long companyId,@PathVariable("accelerationId") Long accelerationId) {
        return new ResponseEntity<Candidate>(this.candidateService.findById(userId, companyId,accelerationId)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate")), HttpStatus.OK);
    }

    @GetMapping("/byCompanyId/{id}")
    public List<Candidate> findByCompanyId(@PathVariable("id") Long idCompany) {
        return this.candidateService.findByCompanyId(idCompany);
    }

    @GetMapping("/byAccelerationId/{id}")
    public List<Candidate> findByAccelerationId(@PathVariable("id") Long accelerationId) {
        return this.candidateService.findByAccelerationId(accelerationId);
    }


}
