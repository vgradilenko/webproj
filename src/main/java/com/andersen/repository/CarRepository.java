package com.andersen.repository;

import com.andersen.model.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    public List<Car> findAllByOrderByIdAsc();

}
