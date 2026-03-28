package racingcar;

import java.lang.Math;

public class RacingCar {
    String carName;
    int distanceFromStart;

    public RacingCar(String _carName, int distanceFromStart) {
        checkNameIsUnderFive(_carName);
        this.carName = _carName;
        this.distanceFromStart = distanceFromStart;
    }

    void checkNameIsUnderFive(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하여야 합니다.");
        }
    }

    int pickRandomInt() {
        return (int) (Math.random() * 10);
    }

    /* 0~9 이외의 숫자를 집어넣을 때의 예외처리를 따로 하지 않은 이유
        : pickRandomInt()의 반환값을 바로 파라미터로 집어넣으려고 했다.
        -> Math.random()의 반환값이 0이상 1미만이므로 이외 숫자가 안 나옴
     */
    public void stopOrGo(int randomInt) {
        if (randomInt >= 4) {
            distanceFromStart += 1;
        }
    }

}
