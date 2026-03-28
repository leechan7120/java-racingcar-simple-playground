package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {

    RacingCar racingcar = new RacingCar("van", 0);

    @DisplayName("수치가 제대로 올라가는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 5})
    public void checkStopOrGo(int parameters) {
        racingcar.distanceFromStart = 0;
        racingcar.stopOrGo(parameters);
        if (parameters >= 4) {
            assertEquals(1, racingcar.distanceFromStart);
        }
        if (parameters < 4) {
            assertEquals(0, racingcar.distanceFromStart);
        }

    }

}
