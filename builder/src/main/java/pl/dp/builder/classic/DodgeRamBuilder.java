package pl.dp.builder.classic;

public class DodgeRamBuilder implements CarBuilder {

    private final Car car;

    public DodgeRamBuilder() {
        car = new Car();
    }

    @Override
    public void buildDoor() {
        car.setDoor(4);
    }

    @Override
    public void buildWheelSize() {
        car.setWheelSize(19);
    }

    @Override
    public void buildEngineCapacity() {
        car.setEngineCapacity(5.7f);
    }

    @Override
    public Car getCar() {
        return car;
    }
}
