package pl.dp.builder.classic;

public class SmartBuilder implements CarBuilder {
    
    private final Car car;

    public SmartBuilder() {
        car = new Car();
    }

    @Override
    public void buildDoor() {
        car.setDoor(2);
    }

    @Override
    public void buildWheelSize() {
        car.setWheelSize(16);
    }

    @Override
    public void buildEngineCapacity() {
        car.setEngineCapacity(1.2f);
    }

    @Override
    public Car getCar() {
        return car;
    }
}
