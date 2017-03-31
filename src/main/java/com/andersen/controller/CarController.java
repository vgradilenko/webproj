package com.andersen.controller;

import com.andersen.model.Car;
import com.andersen.repository.CarRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Data
public class CarController {

    private final CarRepository carRepository;

    private String carName;

    private String carProductionCountry;

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
