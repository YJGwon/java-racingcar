package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class RefereeTest {
	@Test
	public void 차_전진_판단() {
		Car car = new Car("kun");
		Referee.judgeAndMoveCar(car, 5);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	public void 우승자_판정() {
		Set<Car> cars = new HashSet<>();
		Car car1 = new Car("forky");
		Car car2 = new Car("kun");
		car1.move();
		cars.add(car1);
		cars.add(car2);
		assertThat(Referee.judgeWinner(cars).get(0)).isEqualTo(car1);
	}

	@Test
	public void 우승자_여러명() {
		Set<Car> cars = CarFactory.of("forky,kun");
		assertThat(Referee.judgeWinner(cars).size()).isEqualTo(2);
	}
}
