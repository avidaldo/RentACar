package org.example.repository;

import org.example.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarRepositoryTest {

    CarRepository repository;

    @BeforeEach
    void setUp() {
        repository = new CarRepository();
        repository.add(new Car( "1234AAA"));
        repository.add(new Car( "1234BBB"));
    }

    @Test
    void add() {
        Car car3 = new Car( "3333AAA");
        repository.add(car3);
        Assertions.assertEquals(car3, repository.findById(3L));
        Car car4 = new Car("4444AAA");
        repository.add(car4);
        Assertions.assertEquals(car4.getLicensePlate(), repository.findById(4L).getLicensePlate());
    }

    @Test
    void findAll() {
        Assertions.assertEquals(2, repository.findAll().size());
        repository.add(new Car( "3333AAA"));
        Assertions.assertEquals(3, repository.findAll().size());
        repository.deleteById(2L);
        Assertions.assertEquals(2, repository.findAll().size());
    }

    @Test
    void deleteById() {
        Assertions.assertEquals(2, repository.findAll().size());
        repository.deleteById(3L); // Don't exist
        Assertions.assertEquals(2, repository.findAll().size());
        repository.deleteById(2L);
        Assertions.assertEquals(1, repository.findAll().size());
        repository.deleteById(1L);
        Assertions.assertEquals(0, repository.findAll().size());
    }

    @Test
    void findById() {
        Assertions.assertEquals("1234AAA", repository.findById(1L).getLicensePlate());
        Assertions.assertEquals("1234BBB", repository.findById(2L).getLicensePlate());
    }


    @Test
    void findByDni(){
        Assertions.assertEquals(1, repository.findByLicensePlate("1234AAA").getId());
        Assertions.assertEquals("1234BBB", repository.findByLicensePlate("1234BBB").getLicensePlate());
    }

    @Test
    void update(){
        Assertions.assertEquals("1234AAA", repository.findById(1L).getLicensePlate());
        Car car = new Car(1L, "3333AAA");
        repository.update(car);
        Assertions.assertEquals("3333AAA", repository.findById(1L).getLicensePlate());
    }

    // TODO
    @Test
    void updateNotExisting(){
        Car car = new Car(10000L, "3333AAA");
        repository.update(car);
        Assertions.assertNull(repository.findById(10000L));
    }

}