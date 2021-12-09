package pl.dp.builder.innerclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private static final int DOOR = 4;
    private static final int WHEEL_SIZE = 17;
    private static final float ENGINE_CAPACITY = 2.4f;

    @Test
    void buildCarWithInnerClass_correctly() {
        //given
        //when
        var car = new Car.CarBuilder()
                .buildDoor(DOOR)
                .buildWheelSize(WHEEL_SIZE)
                .buildEngineCapacity(ENGINE_CAPACITY)
                .build();
        //then
        assertNotNull(car);
        assertEquals(DOOR, car.getDoor());
        assertEquals(WHEEL_SIZE, car.getWheelSize());
        assertEquals(ENGINE_CAPACITY, car.getEngineCapacity());
    }

}