package com.andersen.controller;

import com.andersen.model.Car;
import com.andersen.model.CarModel;
import com.andersen.repository.CarModelRepository;
import com.andersen.repository.CarRepository;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CarController {

    private final CarRepository carRepository;
    private final CarModelRepository modelRepository;

    private String carName;
    private String carProductionCountry;
    private Car targetCar;

    public Car getTargetCar() {
        return targetCar;
    }

    public void setTargetCar(Car targetCar) {
        this.targetCar = targetCar;
    }

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
    public CarController(CarRepository carRepository, CarModelRepository modelRepository) {
        this.carRepository = carRepository;
        this.modelRepository = modelRepository;
        this.targetCar = carRepository.findOne((long) 1);
    }

    public List<Car> getAll() {
        return carRepository.findAllByOrderByIdAsc();
    }

    public void onRowSelect(SelectEvent event) {
        targetCar = (Car) event.getObject();
        targetCar.setModels(modelRepository.findAllByManufacturerName_Id(targetCar.getId()));
    }

    public List<CarModel> getModels() {
        return modelRepository.findAll();
    }

    public void save() {
        Car car = new Car();
        car.setCarName(carName);
        car.setProductionCountry(carProductionCountry);
        carRepository.saveAndFlush(car);
    }
}
