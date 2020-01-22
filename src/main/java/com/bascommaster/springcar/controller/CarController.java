package com.bascommaster.springcar.controller;


import com.bascommaster.springcar.model.Car;
import com.bascommaster.springcar.model.Color;
import com.bascommaster.springcar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cars", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService=carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>>getCars(){
        List<Car> carList = carService.getAllCars();
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable long id){

        Optional<Car> car = carService.getCarById(id);

        if(car.isPresent()){
            return new ResponseEntity<>(car.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Car>> getByColor(@PathVariable String color){

        List<Car> cars = carService.getCarByColor(color);

        if(!cars.isEmpty()){
            return new ResponseEntity<>(cars, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<Car> addNewCar(@RequestBody Car newCar) {

        if(carService.addCar(newCar)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> delCarById(@PathVariable long id){

       if(carService.delCar(id)){
           return new ResponseEntity<>(HttpStatus.OK);
       }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
