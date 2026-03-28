package racingcar;

import java.util.*;

public class RaceGame {
    RacingCar[] carsInRacing;
    int numberOfCars;
    int numberOfWinners;

    public RaceGame(int numberOfCars, int numberOfWinners, String[] carNames, int[] distanceOfCars) {
        this.numberOfCars = numberOfCars;
        this.numberOfWinners = numberOfWinners;
        this.carsInRacing = new RacingCar[numberOfCars];
        for (int i = 0; i < this.numberOfCars; i++) {
            this.carsInRacing[i] = new RacingCar(carNames[i], distanceOfCars[i]);
        }
    }

    void doGame() {
        for (int i = 0; i < numberOfCars; i++) {
            carsInRacing[i].stopOrGo(carsInRacing[i].pickRandomInt());
            printDistance(carsInRacing[i]);
        }
        System.out.println("\n");
    }

    void printDistance(RacingCar car) {
        System.out.print(car.carName + " : ");
        for (int i = 0; i < car.distanceFromStart; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    String[] getWinner() {
        Arrays.sort(carsInRacing, Comparator.comparingInt((RacingCar p) -> p.distanceFromStart).reversed());
        numberOfWinners = 0;
        List<String> winners = new ArrayList<>();
        do {
            winners.add(carsInRacing[RaceGame.this.numberOfWinners].carName);
            RaceGame.this.numberOfWinners++;
        } while (carsInRacing[0].distanceFromStart
                == carsInRacing[RaceGame.this.numberOfWinners].distanceFromStart);
        return winners.toArray(new String[RaceGame.this.numberOfWinners]);
    }

    void printWinner() {
        String[] winners = getWinner();
        for (int i = 0; i < numberOfWinners - 1; i++) {
            System.out.print(winners[i] + ", ");
        }
        System.out.print(winners[numberOfWinners - 1] + "(이)가 최종 우승했습니다.");
    }
}
