package com.example.restdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(collectionResourceRel = "auta", path = "samochody")
public interface CarRepository extends JpaRepository<Car, Long> {
}
