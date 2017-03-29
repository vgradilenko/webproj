package com.andersen.model;

import javax.persistence.*;

@Entity
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String modelName;

    @ManyToOne
    @JoinColumn(name = "manufacture_id", referencedColumnName = "id")
    private Car manufacturerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Car getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(Car manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
}
