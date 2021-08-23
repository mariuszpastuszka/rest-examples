package com.example.datavalidation;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class CarValidator implements ConstraintValidator<CarConstraint, Car> {
    @Override
    public void initialize(CarConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(Car car, ConstraintValidatorContext context) {
        log.info("validated car: [{}]", car);
        return car.getManufacturer().equals("Mazda");
    }

    public CarValidator() {
        log.info("yeah");
    }
}
