package com.bascommaster.springcar.service;

import com.bascommaster.springcar.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car>  getAllCars();
    Optional<Car> getCarById(long id);
    List<Car> getCarByColor(String color);
}
