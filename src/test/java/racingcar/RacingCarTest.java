package racingcar;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {

    Racingcar racingcar = new Racingcar("van");

    @DisplayName("생성자가 잘 작동하는지, 이름이 제대로 할당되는지 확인")
    @Test
    public void nameSetTest() {

        assertEquals("van", racingcar.carName);
    }

    @DisplayName("랜덤 인수가 제대로 뽑히는 지 확인")
    @RepeatedTest(10)
    public void pickRandomIntTest() {
        int randomInt = racingcar.pickRandomInt();
        assertTrue(randomInt <= 9 && randomInt >= 0);
    }

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
