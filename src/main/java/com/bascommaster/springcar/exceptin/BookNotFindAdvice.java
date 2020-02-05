package com.bascommaster.springcar.exceptin;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BookNotFindAdvice {

    @ResponseBody
    @ExceptionHandler(CarNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String carNotFoundHandler(CarNotFoundException ex){

        return ex.getMessage();
    }
}
