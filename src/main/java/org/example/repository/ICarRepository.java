package org.example.repository;

import org.example.model.Car;

public interface ICarRepository extends ICrudRepository<Car>{
    Car findByLicensePlate(String dni);
}
