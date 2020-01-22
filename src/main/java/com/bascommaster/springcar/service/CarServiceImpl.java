package com.bascommaster.springcar.service;

import com.bascommaster.springcar.model.Car;
import com.bascommaster.springcar.model.Color;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CarServiceImpl implements CarService {

    private List<Car> carList;


    public CarServiceImpl() {
        carList = new ArrayList<>();

        carList.add(new Car(1L, "Polonez", "Caro", Color.WHITE));
        carList.add(new Car(2L, "Oper", "Corsa", Color.RED));
        carList.add(new Car(3L, "Audi", "A8", Color.RED));
        carList.add(new Car(4L, "Fiat", "Panda", Color.SILVER));
    }

    @Override
    public List<Car> getAllCars() {

        return carList;
    }

    @Override
    public Optional<Car> getCarById(long id) {
        return carList
                .stream()
                .filter(car -> car.getId() == id)
                .findFirst();
    }

    @Override
    public List<Car> getCarByColor(String color) {
        return carList
                .stream()
                .filter(car -> color.equalsIgnoreCase(car.getColor().name()))
                .collect(Collectors.toList());

    }

    @Override
    public boolean addCar(Car car) {
        return carList.add(car);
    }

    @Override
    public boolean delCar(long id) {

        Optional found = carList.stream().filter(car -> car.getId() == id).findFirst();

        found.ifPresent(car -> carList.remove(car));
        return true;
    }


}
