package racingcar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String nameString = sc.nextLine();

        String[] carNames = nameString.split(",");
        int numberOfCars = carNames.length;

        int[] initialDistances = new int[numberOfCars];

        RaceGame race = new RaceGame(numberOfCars, 0, carNames, initialDistances);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int numberOfGames = sc.nextInt();

        System.out.println("\n실행 결과");
        for (int i = 0; i < numberOfGames; i++) {
            race.doGame();
        }

        race.printWinner();

        sc.close();
    }
}