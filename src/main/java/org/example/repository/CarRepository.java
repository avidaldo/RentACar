package org.example.repository;

import org.example.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class CarRepository implements ICarRepository {

    // https://stackoverflow.com/questions/24305830/java-auto-increment-id
    private final AtomicLong identifier = new AtomicLong(0);
    private final List<Car> cars;

    public CarRepository() {
        cars = new ArrayList<>();
    }

    public void add(Car car) {
        car.setId(identifier.incrementAndGet());
        cars.add(car);
    }

    public void update(Car car) {
        Car carToUpdate = findById(car.getId());
        if (carToUpdate != null) {
            carToUpdate.setLicensePlate(car.getLicensePlate());
        }
    }

    public List<Car> findAll() {
        return cars;
    }

    public void deleteById(Long id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                cars.remove(car);
                break;
            }
        }
    }

    public Car findById(Long id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    public Car findByLicensePlate(String licencePlate) {
        for (Car car : cars) {
            if (car.getLicensePlate().equals(licencePlate)) {
                return car;
            }
        }
        return null;
    }

}
