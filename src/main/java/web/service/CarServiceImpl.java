package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    List<Car> cars = List.of(new Car("Model1", 2015, "Color1"),
            new Car("Model2", 2015, "Color2"),
            new Car("Model3", 2016, "Color3"),
            new Car("Model4", 2017, "Color4"),
            new Car("Model5", 2018, "Color5"));

    @Override
    public List<Car> getCar(int count) {
        if (0 >= count || count >= 5 || count >= cars.size()) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }
}
