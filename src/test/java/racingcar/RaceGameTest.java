package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class RaceGameTest {

    @DisplayName("우승자 확인: 공동 우승자가 포함된 경우")
    @Test
    void WinnerTest() {
        String[] carNames = {"Adam", "Bro", "July"};
        int[] carDistances = {3, 2, 3};
        RaceGame race = new RaceGame(3, 0, carNames, carDistances);

        String[] winners = race.getWinner();
        String[] expected = {"Adam", "July"};

        assertArrayEquals(expected, winners);
    }

    @DisplayName("자동차가 게임에 제대로 세팅되는지 확인")
    @Test
    void setCarsTest() {
        String[] carNames = {"Joe", "Mist", "Aio"};
        int[] distances = {0, 0, 0};
        RaceGame race = new RaceGame(3, 0, carNames, distances);

        assertEquals("Joe", race.carsInRacing[0].carName);
        assertEquals("Mist", race.carsInRacing[1].carName);
        assertEquals("Aio", race.carsInRacing[2].carName);
    }

    @DisplayName("이름이 5글자 초과일 경우 예외가 발생하는지 확인")
    @Test
    void nameLengthErrorTest() {
        String[] carNames = {"Joe", "Mister", "Aio"};
        int[] distances = {0, 0, 0};

        assertThrows(IllegalArgumentException.class, () -> {
            new RaceGame(3, 0, carNames, distances);
        });
    }

    @DisplayName("출력 형식이 요구사항과 일치하는지 확인")
    @Test
    void printDistanceTest() {
        String[] names = {"Miro"};
        int[] distances = {3};
        RaceGame race = new RaceGame(1, 0, names, distances);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(outputStream));

        race.printDistance(race.carsInRacing[0]);

        assertEquals("Miro : ---\n", outputStream.toString());

        System.setOut(original);
    }

    @DisplayName("최종 승자 메시지가 올바르게 출력되는지 확인")
    @Test
    void printWinnerTest() {
        String[] carNames = {"Adam", "Bro", "July"};
        int[] distances = {3, 2, 3};
        RaceGame race = new RaceGame(3, 0, carNames, distances);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(outputStream));

        race.printWinner();

        assertEquals("Adam, July(이)가 최종 우승했습니다.", outputStream.toString());

        System.setOut(original);
    }
}