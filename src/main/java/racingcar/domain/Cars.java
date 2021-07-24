package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> rawCars) {
        this.cars = rawCars;
    }

    public Cars move(MoveStrategy moveStrategy) {
        List<Car> movedCars = cars
                .stream()
                .map(car -> car.move(moveStrategy))
                .collect(Collectors.toList());
        return new Cars(movedCars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cars)) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
