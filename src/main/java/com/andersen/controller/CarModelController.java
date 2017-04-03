package com.andersen.controller;

import com.andersen.model.CarModel;
import com.andersen.repository.CarModelRepository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CarModelController {

    private CarModelRepository repository;

    public CarModelRepository getRepository() {
        return repository;
    }

    public void setRepository(CarModelRepository repository) {
        this.repository = repository;
    }

    public List<CarModel> getAll() {
        return repository.findAll();
    }
 }
