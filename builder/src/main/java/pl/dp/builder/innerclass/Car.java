package pl.dp.builder.innerclass;

public class Car {
    private final int door;
    private final int wheelSize;
    private final float engineCapacity;

    private Car(CarBuilder carBuilder) {
        this.door = carBuilder.door;
        this.engineCapacity = carBuilder.engineCapacity;
        this.wheelSize = carBuilder.wheelSize;
    }

    public int getDoor() {
        return door;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public float getEngineCapacity() {
        return engineCapacity;
    }

    public static class CarBuilder {
        private int door;
        private int wheelSize;
        private float engineCapacity;

        public CarBuilder buildDoor(int doorCount) {
            this.door = doorCount;
            return this;
        }

        public CarBuilder buildWheelSize(int wheelSize) {
            this.wheelSize = wheelSize;
            return this;
        }

        public CarBuilder buildEngineCapacity(float engineCapacity) {
            this.engineCapacity = engineCapacity;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
