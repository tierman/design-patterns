package pl.dp.singleton;

import java.io.Serial;
import java.io.Serializable;
import java.util.Random;

public class NumberGame implements Serializable {

    @Serial
    private static final long serialVersionUID = 1212121212;

    private int score;
    private transient int secondScore;

    private static final NumberGame INSTANCE = new NumberGame();

    private NumberGame(){}

    public static NumberGame getInstance() {
        return INSTANCE;
    }

    public void play() {
        score = new Random()
                .ints(0,10)
                .findFirst()
                .getAsInt();
        secondScore = score;
    }

    public int getScore() {
        return score;
    }

    public int getSecondScore() {
        return secondScore;
    }

    //zabezpieczenie przed powolaniem kilku obiektow podczas deserializacji
    @Serial
    protected Object readResolve() {
        return getInstance();
    }
}
