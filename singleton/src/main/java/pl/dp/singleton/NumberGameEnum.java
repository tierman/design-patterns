package pl.dp.singleton;

import java.util.Random;

//ten rodzaj implementacji zabezpiecza przed zmiana widocznosci np konstruktora za pomoca refleksji
public enum NumberGameEnum {
    INSTANCE;

    private int score;

    public void play() {
        score = new Random()
                .ints(0,10)
                .findFirst()
                .getAsInt();
    }

    public int getScore() {
        return score;
    }
}
