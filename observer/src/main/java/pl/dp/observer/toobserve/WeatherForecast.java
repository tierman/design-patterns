package pl.dp.observer.toobserve;

import pl.dp.observer.notification.Observer;

import java.util.HashSet;
import java.util.Set;

public class WeatherForecast implements Observable {
    private float temperature;
    private int pressure;
    private final Set<Observer> observers = new HashSet<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.notify(temperature, pressure));
    }

    public void updateForecast(float temperature, int pressure) {
        this.pressure = pressure;
        this.temperature = temperature;

        notifyObservers();
    }
}
