package com.example.smartbank_task.dao.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;


@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityDto extends BaseDto {
    @NotEmpty(message = "city number cannot be null or empty!")
    @JsonProperty("number")
    private Long number;

    @NotEmpty(message = "city name cannot be null or empty!")
    @JsonProperty("name")
    private String name;
}
