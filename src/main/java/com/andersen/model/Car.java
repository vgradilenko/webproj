package com.andersen.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String carName;

    @OneToMany
    private Set<CarModel> models;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Set<CarModel> getModels() {
        return models;
    }

    public void setModels(Set<CarModel> models) {
        this.models = models;
    }
}
