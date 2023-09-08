package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private static final String DIVISION = ",";
    private final List<Car> cars = new ArrayList<>();

    public void addCars(String name){
       Set<String> carNames = Arrays.stream(name.split(DIVISION)).collect(Collectors.toSet());
       carNames.stream().map(Car::new).forEach(cars::add);
    }

    public void moveCars(){
        cars.forEach(car -> {
            if (CreateRandomValue.canMoveCar()) {
                car.movePosition();
            }
        });
    }

    public String executionResult(){
        return cars.stream()
                .map(car -> car.makeScreen(new StringBuilder()))
                .reduce(new StringBuilder(), StringBuilder::append)
                .toString();

    }

}
