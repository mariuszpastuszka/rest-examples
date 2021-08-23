package com.example.datavalidation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class CarRestController {

    @GetMapping("/cars")
    List<Car> getCars() {
        return List.of(Car.builder()
                .licensePlate("WLI1111")
                .manufacturer("Maluch")
                .seatCount(1)
                .build());
    }

    @PostMapping("/cars")
    Car createNewCar(@RequestBody @Valid Car car) {
        car.setId(new Random().nextLong());
        return car;
    }
}
