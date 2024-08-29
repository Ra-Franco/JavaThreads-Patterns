package ZZBComportamento.test;

import ZZBComportamento.domain.Car;
import ZZBComportamento.interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComportamentoPorParametroTest02 {
    private static List<Car> cars = List.of(new Car("Green", 2011), new Car("Black", 1998), new Car("Blue", 2019));

    public static void main(String[] args) {

        List<Car> greenCars = filter(cars, car -> car.getColor().equals("Green"));
        List<Car> yearBeforeCars = filter(cars, car -> car.getYear() < 2014);
        System.out.println(greenCars);
        System.out.println(yearBeforeCars);

    }

    private static List<Car> filter(List<Car> cars, Predicate<Car> carPredicate) {
        List<Car> filteredCars = new ArrayList<Car>();
        for (Car car : cars) {
            if (carPredicate.test(car)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }



}
