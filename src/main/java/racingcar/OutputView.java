package racingcar;

import java.util.List;

public class OutputView {
	private static final String GAME_RESULT_TITLE = "\n실행 결과";

	private static final String WINNER_FORMAT = "%s가 최종 우승했습니다.\n";
	private static final String CAR_POSITION_FORMAT = "%s : %s\n";

	private static final String WINNER_NAME_DELIMITER = ", ";
	private static final String POSITION_CHARACTOR = "-";

	public static void printGameResultTitle() {
		System.out.println(GAME_RESULT_TITLE);
	}

	public static void printCarPosition(String name, int position) {
		System.out.printf(
			CAR_POSITION_FORMAT, name, POSITION_CHARACTOR.repeat(position));
	}

	public static void printBlankLine() {
		System.out.println();
	}

	public static void printWinner(List<String> winnerNames) {
		System.out.printf(WINNER_FORMAT, String.join(WINNER_NAME_DELIMITER, winnerNames));
	}
}
