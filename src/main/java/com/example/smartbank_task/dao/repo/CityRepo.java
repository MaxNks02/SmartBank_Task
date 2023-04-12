package com.example.smartbank_task.dao.repo;

import com.example.smartbank_task.dao.model.City;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepo extends BaseRepo<City>{
    Optional<City> findByName(String name);
}
