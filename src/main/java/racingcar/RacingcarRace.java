package racingcar;

import java.util.*;

public class RacingcarRace {
    int tries = 0;
    Racingcar[] carsInRacing;
    int numberOfCars;
    int numberOfWinners;


    String[] splitName(String str) {
        return str.split(",");
    }

    void setTries(int _tries) {
        this.tries = _tries;
    }

    void doGame() {
        for (int i = 0; i < numberOfCars; i++) {
            carsInRacing[i].stopOrGo(carsInRacing[i].pickRandomInt());
            printDistance(carsInRacing[i]);
        }
        System.out.println("\n");

    }

    void setCars(String[] carNames) {
        numberOfCars = carNames.length;
        carsInRacing = new Racingcar[numberOfCars];
        for (int i = 0; i < numberOfCars; i++) {
            carsInRacing[i] = new Racingcar(carNames[i]);
        }
    }

    void printDistance(Racingcar car) {
        System.out.println(car.carName + " : ");
        for (int i = 0; i < car.distanceFromStart; i++) {
            System.out.println("-");
        }
        System.out.println("\n");
    }

    String[] getWinner() {
        Arrays.sort(carsInRacing, Comparator.comparingInt((Racingcar p) -> p.distanceFromStart).reversed());
        numberOfWinners = 0;
        List<String> winners = new ArrayList<>();
        do {
            winners.add(carsInRacing[RacingcarRace.this.numberOfWinners].carName);
            RacingcarRace.this.numberOfWinners++;
        } while (carsInRacing[0].distanceFromStart
                == carsInRacing[RacingcarRace.this.numberOfWinners].distanceFromStart);
        return winners.toArray(new String[RacingcarRace.this.numberOfWinners]);
    }

    void printWinner() {
        String[] winners = getWinner();
        for (int i = 0; i < numberOfWinners - 1; i++) {
            System.out.println(winners[i] + ", ");
        }
        System.out.println(winners[numberOfWinners - 1] + "가 최종 우승했습니다.");
    }
}
