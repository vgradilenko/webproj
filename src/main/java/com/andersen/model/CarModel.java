package com.andersen.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String modelName;

    @ManyToOne
    @JoinColumn(name = "manufacture_id", referencedColumnName = "id")
    private Car manufacturerName;
}
