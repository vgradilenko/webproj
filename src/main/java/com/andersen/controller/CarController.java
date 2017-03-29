//package com.andersen.controller;
//
//import com.andersen.model.Car;
//import com.andersen.repository.CarRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class CarController {
//
//    private final CarRepository carRepository;
//
//    @Autowired
//    public CarController(CarRepository carRepository) {
//        this.carRepository = carRepository;
//    }
//
//    @GetMapping(value = "/{id}")
//    public Car getCarById (@PathVariable long id){
//        return carRepository.findOne(id);
//    }
//
//    @PostMapping(value = "create/{name}")
//    public void save(@PathVariable String name) {
//        carRepository.saveAndFlush(new Car());
//    }
//}
