package pl.dp.builder.classic;

public interface CarBuilder {
    void buildDoor();
    void buildWheelSize();
    void buildEngineCapacity();

    Car getCar();
}
