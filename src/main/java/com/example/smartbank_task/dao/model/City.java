package com.example.smartbank_task.dao.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
@Entity
public class City extends BaseModel  {


    @JsonProperty("number")
    @Column(name = "number")
    @NotEmpty(message = "city number should not be empty!")
    private Long number;

    @JsonProperty("name")
    @Column(name = "name")
    @NotEmpty(message = "city name should not be empty!")
    private String name;

}
