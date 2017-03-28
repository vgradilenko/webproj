package com.andersen.model;

import lombok.Data;

import javax.persistence.Entity;
import java.util.Set;

@Data
@Entity
public class Car {

    private Long id;

    private String carName;

    private Set<CarModel> models;
}
