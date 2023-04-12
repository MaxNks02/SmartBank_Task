package com.example.smartbank_task.controller;

import com.example.smartbank_task.service.BaseService;

public abstract class BaseController<S extends BaseService> {

    protected S service;

    protected BaseController(S service) {
        this.service = service;
    }
}
