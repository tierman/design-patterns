package pl.dp.observer.notification;

public class Email implements Observer {

    @Override
    public void notify(float temperature, int pressure) {
        System.out.printf(
                "\nSending email with temperature: %f C, and pressure: %s hPa",
                temperature,
                pressure);
    }
}
