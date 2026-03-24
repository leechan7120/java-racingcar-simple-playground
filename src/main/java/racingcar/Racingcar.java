package racingcar;

import java.lang.Math;

public class Racingcar {
    String carName;
    int reachFromStart = 0;

    public Racingcar(String _carName) {
        this.carName = _carName;
    }

    public void stopOrGo() {
        if ((int) (Math.random() * 10) >= 4) {
            reachFromStart += 1;
        }
    }

}
