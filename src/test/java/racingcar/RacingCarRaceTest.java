package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assumptions.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class RacingCarRaceTest {
    @DisplayName("우승자 확인")
    @Test
    void WinnerTest() {
        RacingcarRace race = new RacingcarRace();
        String[] carNames = {"Adam", "Bro", "July"};
        race.setCars(carNames);
        race.carsInRacing[0].distanceFromStart = 3;
        race.carsInRacing[1].distanceFromStart = 2;
        race.carsInRacing[2].distanceFromStart = 3;

        String[] winners = race.getWinner();

        String[] expected = {"Adam", "July"};

        assertArrayEquals(expected, winners);

    }
}
