package pl.dp.factory.method.factory;

public abstract class Vehicle {
    private int seats;

    Vehicle(int seats) {
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }
}
