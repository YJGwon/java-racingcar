package racingcar;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {
	private static final String WINNER_NAME_DELIMITER = ", ";
	private static final String NEGATIVE_ERROR_MESSAGE = "[ERROR] 음수를 입력할 수 없습니다";
	private static final int RANDOM_VALUE_BOUND = 10;

	public void start() {
		Set<Car> cars = CarFactory.of(InputView.inputCarNames());
		int count = InputView.inputGameCount();
		validateGameCount(count);
		OutputView.printGameResultTitle();
		for (int i = 0; i < count ; i++) {
			play(cars);
			showResult(cars);
		}
		showWinner(Referee.judgeWinner(cars));
	}

	public Set<Car> play(Set<Car> cars) {
		for (Car car : cars) {
			Referee.judgeCarMove(car, makeRandomValue());
		}
		return cars;
	}

	public void showResult(Set<Car> cars) {
		for (Car car : cars) {
			OutputView.printLineString(car.toString());
		}
		OutputView.printBlankLine();
	}

	public void showWinner(List<Car> winnerCars) {
		String winnerNames = winnerCars.stream()
			.map(Car::getName).collect(Collectors.joining(WINNER_NAME_DELIMITER));
		OutputView.printWinner(winnerNames);
	}

	public int makeRandomValue() {
		Random random = new Random();
		return random.nextInt(RANDOM_VALUE_BOUND);
	}

	private void validateGameCount(int gameCount) {
		if(gameCount < 0) {
			throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
		}
	}
}
