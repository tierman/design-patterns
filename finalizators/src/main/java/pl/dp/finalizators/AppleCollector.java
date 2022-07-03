package pl.dp.finalizators;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AppleCollector {

    public static void main(String[] args) throws InterruptedException {
        int counter = 1;

        while (counter < 10) {
            System.out.println("Creating apples | counter: " + counter);
            ArrayList apples = new ArrayList();

            for (int i = 0; i < 10000000; ++i) {
                apples.add(new GreenApple());
                //apples.add(new YellowApple());
                //apples.add(new RedApple());
            }

            System.out.println("Pause for 2 seconds");
            TimeUnit.SECONDS.sleep(2);

            System.out.println("Before gc ========>");
            System.gc();
            System.out.println("========> After gc");

            System.out.println("Pause for 2 seconds");
            TimeUnit.SECONDS.sleep(2);

            ++counter;
        }
    }
}
