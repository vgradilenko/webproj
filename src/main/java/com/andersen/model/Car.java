package com.andersen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String carName;

    private String productionCountry;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CarModel> models;
}
