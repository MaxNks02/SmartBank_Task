package com.example.smartbank_task.dao.mapper;

import com.example.smartbank_task.dao.dto.CityDto;
import com.example.smartbank_task.dao.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;



@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CityMapper extends BaseMapper<City, CityDto> {
}