package com.andersen.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String getHelloMessage() {
        return "Hello World!!!";
    }

    private String carName;

    @OneToMany
    private Set<CarModel> models;
}
