package com.study.rest.controller;

import com.study.rest.entity.Car;
import com.study.rest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarController {

    @Autowired
    private CarService cs;

    @ResponseBody
    @GetMapping("/car")
    public Car getCar(@RequestParam String model) {
        Car car = cs.getCar(model);
        System.out.println(car.toString());
        return car;
    }
}

/*
*  요청 GET -        /car
*  Car        -> model, color
*
*  CarRepository    -> findCarByModel(String model)
*     -> List<Car>
        -> index0: Car(model: "쏘나타", color: "화이트")
        -> index1: Car(model: "K5", color: "블랙")
*
*  CarService       -> Car getCar(String model)
*
*  CarController    -> Car getCar(@RequestParam String model)
*
*  의존관계 -> CarCOntroller > CarService > CarRepository
*  의존성이 마지막에 있는 것 (없는 것) 부터 클래스를 만들어야함.
* */
