package com.study.rest.service;

import com.study.rest.entity.Car;
import com.study.rest.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

//    @Autowired
//    private CarRepository carRepository;

    // final -> 상수 : 무조건 한 번은 초기화를 해줘야 한다.
    // 이 경우 외부에서 주입된 값(매개변수가 있는 생성자)을 넣어서 초기화 해 줄 수 있음.
    private final CarRepository carRepository;
    private final String name;

//    public CarService(CarRepository carRepository) {
//        this.carRepository = carRepository;
//        this.name = "김준일";
//    }

    public Car getCar(String model) {
        return carRepository.findCarbyModel(model);
    }
}
