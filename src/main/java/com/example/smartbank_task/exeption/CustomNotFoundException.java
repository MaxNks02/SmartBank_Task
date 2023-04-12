package com.example.smartbank_task.exeption;

import com.example.smartbank_task.exeption.handling.HasDomainErrors;
import io.vavr.collection.Seq;

import static org.springframework.http.HttpStatus.NOT_FOUND;


public class CustomNotFoundException extends DomainExceptionWithErrors {

    public CustomNotFoundException(String reason) {
        this(reason, null, null);
    }

    public CustomNotFoundException(String objectName, String reason) {
        this(reason, null, null);
    }

    public CustomNotFoundException(String reason, String objectName,
                                   Seq<HasDomainErrors.DomainError> errors) {
        super(NOT_FOUND, reason, objectName, errors);
    }

}