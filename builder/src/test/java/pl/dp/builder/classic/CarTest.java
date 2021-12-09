package pl.dp.builder.classic;

import org.junit.jupiter.api.Test;
import pl.dp.builder.innerclass.Car;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private static final int SMART_DOOR = 2;
    private static final int SMART_WHEEL_SIZE = 16;
    private static final float SMART_ENGINE_CAPACITY = 1.2f;
    private static final int RAM_DOOR = 4;
    private static final int RAM_WHEEL_SIZE = 19;
    private static final float RAM_ENGINE_CAPACITY = 5.7f;

    @Test
    void buildSmartWithClassicWay_correctly() {
        //given
        var smartBuilder = new SmartBuilder();

        //when
        CarBuilderDirector carBuilderDirector = new CarBuilderDirector(smartBuilder);
        carBuilderDirector.buildCar();
        var smart = carBuilderDirector.getCar();

        //then
        assertNotNull(smart);
        assertEquals(SMART_DOOR, smart.getDoor());
        assertEquals(SMART_WHEEL_SIZE, smart.getWheelSize());
        assertEquals(SMART_ENGINE_CAPACITY, smart.getEngineCapacity());
    }

    @Test
    void buildRamWithClassicWay_correctly() {
        //given
        var ramBuilder = new DodgeRamBuilder();

        //when
        CarBuilderDirector carBuilderDirector = new CarBuilderDirector(ramBuilder);
        carBuilderDirector.buildCar();
        var ram = carBuilderDirector.getCar();

        //then
        assertNotNull(ram);
        assertEquals(RAM_DOOR, ram.getDoor());
        assertEquals(RAM_WHEEL_SIZE, ram.getWheelSize());
        assertEquals(RAM_ENGINE_CAPACITY, ram.getEngineCapacity());
    }
}