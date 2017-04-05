package com.andersen.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelName;

    private Integer manufacturedYear;

    private Long price;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacture_id", referencedColumnName = "id")
    private Car manufacturerName;
}
