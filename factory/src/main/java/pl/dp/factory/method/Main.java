package pl.dp.factory.method;

import pl.dp.factory.method.factory.VehicleFactory;
import pl.dp.factory.method.factory.VehicleType;

public class Main {

    public static void main(String ... args) {
        var vehicle = VehicleFactory.INSTANCE.createVehicle(VehicleType.CAR);
        assert vehicle.getSeats() == 5;

        vehicle = VehicleFactory.INSTANCE.createVehicle(VehicleType.BUS);
        assert vehicle.getSeats() == 20;
    }
}
