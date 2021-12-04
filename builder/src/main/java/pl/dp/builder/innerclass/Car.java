package pl.dp.builder.innerclass;

public class Car {
    private int door;
    private int wheelSize;
    private float engineCapacity;

    private Car(CarBuilder carBuilder) {

    }

    private static class CarBuilder {
        private int door;
        private int wheelSize;
        private float engineCapacity;

        public CarBuilder buildDoor(int doorCount) {
            this.door = doorCount;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
