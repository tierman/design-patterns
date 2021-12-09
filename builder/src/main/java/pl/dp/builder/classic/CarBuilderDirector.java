package pl.dp.builder.classic;

public class CarBuilderDirector {
    private final CarBuilder carBuilder;

    public CarBuilderDirector(CarBuilder builder) {
        this.carBuilder = builder;
    }

    public void buildCar() {
        carBuilder.buildDoor();
        carBuilder.buildWheelSize();
        carBuilder.buildEngineCapacity();
    }

    public Car getCar() {
        return carBuilder.getCar();
    }
}
