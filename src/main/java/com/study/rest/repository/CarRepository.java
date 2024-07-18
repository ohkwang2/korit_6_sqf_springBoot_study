package com.study.rest.repository;

import com.study.rest.entity.Car;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepository {

    List<Car> carList = List.of(
                Car.builder().model("쏘나타").color("화이트").build(),
                Car.builder().model("K5").color("블랙").build()
        );

    public Car findCarbyModel(String model) {

        return carList.stream()
                .filter(car -> car.getModel().equals(model))
                .collect(Collectors.toList())
                .get(0);
//        Car foundCar = null;
//        for (Car car : carList) {
//            if(car.getModel().equals(model)) {
//                foundCar = car;
//            }
//        }
//        System.out.println(foundCar);
//        return foundCar;
    }
}
