package com.andersen.controller;

import com.andersen.model.Car;
import com.andersen.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CarController {

    private final CarRepository carRepository;

    private String carName;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public List<Car> getAll (){
        return carRepository.findAllByOrderByIdAsc();
    }

    @GetMapping(value = "/{id}")
    public Car getCarById (@PathVariable long id){
        return carRepository.findOne(id);
    }

    public void save() {
        Car car = new Car();
        car.setCarName(carName);
        carRepository.saveAndFlush(car);
    }
}
