package com.andersen.repository;

import com.andersen.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    List<CarModel> findAllByManufacturerName_Id(long id);

}
