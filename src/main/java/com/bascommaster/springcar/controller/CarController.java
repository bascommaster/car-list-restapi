package com.bascommaster.springcar.controller;


import com.bascommaster.springcar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cars", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService=carService;
    }



}
