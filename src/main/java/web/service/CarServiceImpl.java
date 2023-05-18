package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    List<Car> carList = new ArrayList<>();

    public CarServiceImpl() {
        carList.add(new Car("Kia", "Rio", "Black"));
        carList.add(new Car("Лада", "Веста", "Красный"));
        carList.add(new Car("Audi", "Q5", "White"));
        carList.add(new Car("Toyota", "Land Cruiser", "Green"));
        carList.add(new Car("Haval", "F7X", "Yellow"));
    }

    @Override
    public List<Car> printCars(int count) {
        return carList.stream().limit(count).toList();
    }
}