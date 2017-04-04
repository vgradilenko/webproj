package com.andersen.controller;

import com.andersen.model.CarModel;
import com.andersen.repository.CarModelRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Data
public class CarModelController {

    private final CarModelRepository repository;

    @Autowired
    public CarModelController(CarModelRepository repository) {
        this.repository = repository;
    }

    public List<CarModel> getAll() {
        return repository.findAll();
    }
}
