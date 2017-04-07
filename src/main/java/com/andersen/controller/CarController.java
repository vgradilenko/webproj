package com.andersen.controller;

import com.andersen.model.Car;
import com.andersen.model.CarModel;
import com.andersen.repository.CarModelRepository;
import com.andersen.repository.CarRepository;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Log4j
@Controller
@Data
public class CarController {

    private final CarRepository carRepository;
    private final CarModelRepository modelRepository;
    private static Logger logger = LogManager.getRootLogger();

    private String carName;
    private String carProductionCountry;
    private Car targetCar;
    private CarModel targetModel;
    private String modelName;
    private Integer modelYear;
    private Long modelPrice;

    @Autowired
    public CarController(CarRepository carRepository, CarModelRepository modelRepository) {
        this.carRepository = carRepository;
        this.modelRepository = modelRepository;
    }

    public List<Car> getAll() {
        return carRepository.findAllByOrderByIdAsc();
    }

    public void onRowSelect(SelectEvent event) {
        Car tempCar = (Car) event.getObject();
        logger.debug(tempCar);
        targetCar = carRepository.findOne(tempCar.getId());
        targetCar.setModels(modelRepository.findAllByManufacturerNameId(targetCar.getId()));
        logger.debug(targetCar);
    }

    public List<CarModel> getModels() {
        return modelRepository.findAll();
    }

    public void save() {
        Car car = new Car();
        car.setCarName(carName);
        car.setProductionCountry(carProductionCountry);
        logger.debug(car);
        carRepository.saveAndFlush(car);
    }

    public void saveModel() {
        CarModel model = new CarModel();
        model.setModelName(modelName);
        model.setManufacturedYear(modelYear);
        model.setPrice(modelPrice);
        model.setManufacturerName(carRepository.findOne(targetCar.getId()));
        modelRepository.saveAndFlush(model);
    }

    public void saveModelByPlSql() {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "", modelRepository.saveModel(modelName, modelYear, modelPrice, targetCar.getId())));
    }

    public void deleteModelByPlSql(CarModel carModel){
        logger.debug(carModel);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "INFO: ", modelRepository.deleteModel(carModel.getId())));
    }
}