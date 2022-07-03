package pl.dp.factory.method.factory;

public enum VehicleFactory implements Factory {
    INSTANCE;

    @Override
    public Vehicle createVehicle(VehicleType type) {
        return switch (type) {
            case BUS -> new Bus(20);
            case CAR -> new Car(5);
            default -> throw new UnsupportedOperationException("Unknown vehicle type");
        };
    }
}
