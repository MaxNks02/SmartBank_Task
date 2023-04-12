package com.example.smartbank_task.service;

import com.example.smartbank_task.dao.dto.BaseDto;
import com.example.smartbank_task.dao.mapper.BaseMapper;
import com.example.smartbank_task.dao.model.BaseModel;
import com.example.smartbank_task.dao.repo.BaseRepo;
import com.example.smartbank_task.exeption.CustomNotFoundException;
import com.example.smartbank_task.exeption.DatabaseException;
import com.example.smartbank_task.exeption.handling.ApiMessages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseService<E extends BaseModel,
        D extends BaseDto,
        R extends BaseRepo<E>,
        M extends BaseMapper<E, D>> {

    private static final String DAT_NOT_FOUND = "Data not found. Id: %s";

    private final R repository;
    private final M mapper;

    protected BaseService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public R getRepository() {
        return repository;
    }

    public M getMapper() {
        return mapper;
    }

    @Transactional
    public D create(D dto) {
        E entity = mapper.toEntity(dto);
        E savedEntity;
        try {
            savedEntity = repository.save(entity);
        } catch (RuntimeException exception) {
            throw new DatabaseException(String.format(ApiMessages.INTERNAL_SERVER_ERROR + " %s", exception.getMessage()));
        }
        return mapper.toDto(savedEntity);
    }


    public D getById(Long id) {
        E entity = repository.findById(id).orElseThrow(() -> new CustomNotFoundException(String.format(ApiMessages.NOT_FOUND + DAT_NOT_FOUND, id)));
        return mapper.toDto(entity);
    }

    public E entityGetById(Long id) {
        return repository.findById(id).orElseThrow(() -> new CustomNotFoundException(String.format(ApiMessages.NOT_FOUND + DAT_NOT_FOUND, id)));
    }

    public List<D> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public Page<D> getAllWithPagination(Pageable pageable) {
        try {
            return repository.findAll(pageable).map(mapper::toDto);
        } catch (RuntimeException exception) {
            throw new DatabaseException(String.format(ApiMessages.INTERNAL_SERVER_ERROR + " %s", exception.getMessage()));
        }
    }

    @Transactional
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new CustomNotFoundException(String.format(ApiMessages.NOT_FOUND + DAT_NOT_FOUND, id));
        }
        try {
            repository.deleteById(id);
        } catch (RuntimeException exception) {
            throw new DatabaseException(String.format(ApiMessages.INTERNAL_SERVER_ERROR + " %s", exception.getMessage()));
        }
    }

    public abstract D update(D dto);

}
