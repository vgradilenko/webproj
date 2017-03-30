package com.andersen.controller;

import com.andersen.model.Car;
import com.andersen.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CarController {

    private final CarRepository carRepository;

    private String carName;

    private String carProductionCountry;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarProductionCountry() {
        return carProductionCountry;
    }

    public void setCarProductionCountry(String carProductionCountry) {
        this.carProductionCountry = carProductionCountry;
    }

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAll() {
        return carRepository.findAllByOrderByIdAsc();
    }

    public void save() {
        Car car = new Car();
        car.setCarName(carName);
        car.setProductionCountry(carProductionCountry);
        carRepository.saveAndFlush(car);
    }
}
