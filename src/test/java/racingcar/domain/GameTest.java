package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameTest {
    private static final String CAR_NAMES = "forky,kun,pobi";

    @Test
    @DisplayName("우승자가 한 명일 때 우승자 판정")
    public void getWinners_one_winner() {
        Game game = Game.of(CAR_NAMES, 0);
        Car winningCar = game.getCars().getCars().get(0);
        winningCar.move(true);
        assertThat(game.getWinners())
                .containsExactly(winningCar);
    }

    @Test
    @DisplayName("우승자가 두 명일 때 우승자 판정")
    public void getWinners_two_winners() {
        Game game = Game.of(CAR_NAMES, 0);
        Car winningCar1 = game.getCars().getCars().get(0);
        Car winningCar2 = game.getCars().getCars().get(1);
        winningCar1.move(true);
        winningCar2.move(true);
        assertThat(game.getWinners())
                .containsExactlyInAnyOrder(winningCar1, winningCar2);
    }

    @ParameterizedTest
    @DisplayName("진행 횟수에 따른 게임 종료 판단")
    @ValueSource(ints = {0, 1, 2})
    public void isEnd_after_play(int count) {
        Game game = Game.of(CAR_NAMES, count);
        for (int i = 0; i < count; i++) {
            game.play();
        }
        assertThat(game.isEnd()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("게임 종료 후 play시 에러 발생")
    @ValueSource(ints = {0, 1, 2})
    public void play_after_game_ends(int count) {
        Game game = Game.of(CAR_NAMES, count);
        for (int i = 0; i < count; i++) {
            game.play();
        }
        assertThatThrownBy(game::play)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("[ERROR] 이미 정해진 횟수만큼 진행되었습니다.");
    }
}
