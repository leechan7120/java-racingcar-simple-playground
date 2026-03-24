package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assumptions.*;

import static org.junit.jupiter.api.Assertions.*;

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

    @DisplayName("이름 분리가 잘 되는지 확인")
    @Test
    void splitNameTest() {
        RacingcarRace race = new RacingcarRace();
        String str = "Joe,Mist,Aio";

        String[] actual = race.splitName(str);
        String[] expected = {"Joe", "Mist", "Aio"};

        assertArrayEquals(expected, actual);

    }

    @DisplayName("이름이 5글자 초과일 경우 예외를 제대로 throw하는지 확인")
    @Test
    void validationTest() {
        RacingcarRace race = new RacingcarRace();
        String name = "Micheal";

        assertThrows(IllegalArgumentException.class, () -> race.checkNameValidation(name));

    }

    @DisplayName("자동차가 게임에 제대로 세팅되는지 확인")
    @Test
    void setCarsTest() {
        RacingcarRace race = new RacingcarRace();
        String[] carNames = {"Joe", "Mist", "Aio"};
        race.setCars(carNames);
        assertEquals("Joe", race.carsInRacing[0].carName);
        assertEquals("Mist", race.carsInRacing[1].carName);
        assertEquals("Aio", race.carsInRacing[2].carName);

    }

    @DisplayName("제대로 된 이름이 아닐 경우 오류를 검출하는지 확인")
    @Test
    void setCarsErrorTest() {
        RacingcarRace race = new RacingcarRace();
        String[] carNames = {"Joe", "Mister", "Aio"};
        assertThrows(IllegalArgumentException.class, () -> race.setCars(carNames));
    }

    @DisplayName("출력이 제대로 이루어지는지 확인")
    @Test
    void printTest() {
        RacingcarRace race = new RacingcarRace();
        String[] names = {"Miro"};
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(outputStream));

        race.setCars(names);
        race.carsInRacing[0].distanceFromStart = 3;
        race.printDistance(race.carsInRacing[0]);

        assertEquals("Miro : ---\n", outputStream.toString());
        System.setOut(original);
    }

    @DisplayName("승자가 제대로 출력되는지 확인")
    @Test
    void printWinnerTest() {
        RacingcarRace race = new RacingcarRace();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(outputStream));

        String[] carNames = {"Adam", "Bro", "July"};
        race.setCars(carNames);
        race.carsInRacing[0].distanceFromStart = 3;
        race.carsInRacing[1].distanceFromStart = 2;
        race.carsInRacing[2].distanceFromStart = 3;

        race.printWinner();

        assertEquals("Adam, July(이)가 최종 우승했습니다.", outputStream.toString());
        System.setOut(original);


    }

}
