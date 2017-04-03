package com.andersen.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String modelName;

    @ManyToOne(fetch = FetchType.EAGER)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModel carModel = (CarModel) o;
        return Objects.equals(id, carModel.id) &&
                Objects.equals(modelName, carModel.modelName) &&
                Objects.equals(manufacturerName, carModel.manufacturerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelName, manufacturerName);
    }
}
