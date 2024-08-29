package ZZBComportamento.test;

import ZZBComportamento.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest01 {
    private static List<Car> cars = List.of(new Car("Green", 2011), new Car("Black", 1998), new Car("Blue", 2019));

    public static void main(String[] args) {

        System.out.println(filterCarByColor(cars, "Green"));
        System.out.println(filterCarByColor(cars, "Blue"));
        System.out.println(filterCarAge(cars, 2000));

    }

    private static List<Car> filterCarByColor(List<Car> cars, String color) {
        List<Car> filteredCars = new ArrayList<Car>();
        for (Car car : cars) {
            if (car.getColor().equals(color)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    private static List<Car> filterCarAge(List<Car> cars, int year) {
        List<Car> oldCars = new ArrayList<Car>();
        for (Car car : cars) {
            if (car.getYear() < year) {
                oldCars.add(car);
            }
        }
        return oldCars;
    }



}
