package pl.dp.observer.notification;

public class Sms implements Observer {

    @Override
    public void notify(float temperature, int pressure) {
        System.out.printf(
                "\nSending SMS with temperature: %f C, and pressure: %s hPa",
                temperature,
                pressure);
    }
}
