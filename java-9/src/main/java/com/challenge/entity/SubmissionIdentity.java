package com.challenge.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@EntityListeners(AuditingEntityListener.class)
public class SubmissionIdentity implements Serializable {

    @ManyToOne
    @NotNull
    private User user;

    @ManyToOne
    @NotNull
    private  Challenge challenge;


}
