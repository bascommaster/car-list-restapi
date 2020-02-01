package com.bascommaster.springcar.service;

import com.bascommaster.springcar.model.Car;
import com.sun.javaws.IconUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CarServiceImpl implements CarService {

    private List<Car> carList;
    private static int counter =7;

    public CarServiceImpl() {
        carList = new ArrayList<>();

        carList.add(new Car(1L, "Polonez", "Caro","white"));
        carList.add(new Car(2L, "Opel", "Corsa", "red"));
        carList.add(new Car(3L, "Opel", "Insignia", "blue"));
        carList.add(new Car(4L, "Audi", "A8", "red"));
        carList.add(new Car(5L, "Fiat", "Panda", "white"));
        carList.add(new Car(6L, "Fiat", "Panda", "silver"));
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
                .filter(car -> color.equalsIgnoreCase(car.getColor()))
                .collect(Collectors.toList());

    }

    @Override
    public boolean addCar(Car newCar) {

         if(carList.add(newCar)){
             int size=carList.size();
             System.out.println("rozmiar tablicy: "+ size);
             System.out.println("sotatni samochód: " + (carList.indexOf(newCar)+1));

             carList.get(size-1).setId(counter++);
             return true;
         }

        return false;
    }

    @Override
    public boolean delCar(long id) {

        Optional found = carList.stream().filter(car -> car.getId() == id).findFirst();

        found.ifPresent(car -> carList.remove(car));
        return true;
    }


}
