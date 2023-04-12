package com.example.smartbank_task.exeption;

import com.example.smartbank_task.exeption.handling.HasDomainErrors;
import io.vavr.collection.Seq;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;



public class BadCredentialsException extends DomainExceptionWithErrors {

    public BadCredentialsException(String reason) {
        this(reason, null, null);
    }

    public BadCredentialsException(String objectName, String reason) {
        this(reason, null, null);
    }

    public BadCredentialsException(String reason, String objectName,
                                   Seq<HasDomainErrors.DomainError> errors) {
        super(UNAUTHORIZED, reason, objectName, errors);
    }

}