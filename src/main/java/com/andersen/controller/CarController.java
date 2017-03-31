package com.andersen.controller;

import com.andersen.model.Car;
import com.andersen.repository.CarRepository;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;

@Controller
public class CarController {

    private final CarRepository carRepository;
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
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAll() {
        return carRepository.findAllByOrderByIdAsc();
    }

    public void onRowSelect(SelectEvent event) {
        long brandId = ((Car) event.getObject()).getId();
        FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getCarName());
        FacesContext.getCurrentInstance().getCurrentPhaseId();
    }

    public String onRowUnselect() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> map = context.getExternalContext().getRequestParameterMap();

        String testValue = map.get("carId");
        System.out.print(testValue);
        return testValue;
    }

    public void save() {
        Car car = new Car();
        car.setCarName(carName);
        car.setProductionCountry(carProductionCountry);
        carRepository.saveAndFlush(car);
    }
}
