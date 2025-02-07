import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class Saab95Test {
    Saab95 saab95;

    @BeforeEach
    void setUp() {
        this.saab95 = new Saab95(Color.red,125,false);
    }


    @Test
    @DisplayName("Coordinates")
    void getCords() {
        assertEquals("[0.0, 0.0]", Arrays.toString(saab95.getCords()));
    }

    @Test
    @DisplayName("Engine power")
    void getEnginePower() {
        assertEquals(125, saab95.getEnginePower());
    }

    @Test
    @DisplayName("Current speed")
    void getCurrentSpeed() {
    }

    @Test
    @DisplayName("Current color")
    void getColor() {
        assertEquals(Color.red, saab95.getColor());
    }

    @Test
    @DisplayName("Set color")
    void setColor() {
        saab95.setColor(Color.blue);
        assertEquals(Color.blue, saab95.getColor());
    }

    @Test
    @DisplayName("Start engine")
    void startEngine() {
        saab95.stopEngine();
        saab95.startEngine();
        saab95.startEngine();
        assertEquals(0.10, saab95.getCurrentSpeed());
    }

    @Test
    @DisplayName("Stop engine")
    void stopEngine() {
        saab95.startEngine();
        saab95.stopEngine();
        saab95.stopEngine();
        assertEquals(0.0, saab95.getCurrentSpeed());
    }

    @Test
    @DisplayName("Test move(), also tests gas() and brake()")
    void move() {
        saab95.startEngine();
        saab95.gas(1);
        assertEquals(0, saab95.getCords()[0]);
        assertEquals(1.35, saab95.getCords()[1]);

        saab95.turnLeft();
        saab95.move();
        assertEquals(-1.35, saab95.getCords()[0]);
        assertEquals(1.35, saab95.getCords()[1]);

        saab95.brake(1);
        assertTrue(-1.44 >= saab95.getCords()[0] && saab95.getCords()[0] >= -1.46);

    }

    @Test
    @DisplayName("Turn left")
    void turnLeft() {
        saab95.turnLeft();
        assertEquals(Car.headings.WEST, saab95.getHeading());
        saab95.turnLeft();
        assertEquals(Car.headings.SOUTH, saab95.getHeading());
    }

    @Test
    @DisplayName("Check turn right")
    void turnRight() {
        saab95.turnRight();
        assertEquals(Car.headings.EAST, saab95.getHeading());
        saab95.turnRight();
        assertEquals(Car.headings.SOUTH, saab95.getHeading());
    }

    @Test
    @DisplayName("Test TurboOn")
    void setTurboOn() {
        saab95.setTurboOn();
        assertTrue(saab95.turboStatus());
        saab95.setTurboOn();
        assertTrue(saab95.turboStatus());
    }

    @Test
    @DisplayName("Test TurboOff")
    void setTurboOff() {
        saab95.setTurboOff();
        assertFalse(saab95.turboStatus());
        saab95.setTurboOff();
        assertFalse(saab95.turboStatus());
    }

    @Test
    @DisplayName("Ensure that gas and brake methods only accept values between 0 and 1" +
            "This also ensures that gas cannot brake and brake cannot gas")
    void gasBreakInput(){
        assertThrows(IllegalArgumentException.class, ()-> saab95.gas(-1));
        assertThrows(IllegalArgumentException.class, ()-> saab95.brake(-1));
        assertThrows(IllegalArgumentException.class, ()-> saab95.gas(2));
        assertThrows(IllegalArgumentException.class, ()-> saab95.brake(2));
    }


/*
    @Test
    @DisplayName("Test that gas does not slow down the car")
    void gasDoesNotBrake() {
        Saab95 saab95 = new Saab95(4, Color.red,125, true);
        double speed = saab95.getCurrentSpeed();
        saab95.gas(1);
        assertTrue(saab95.getCurrentSpeed() >= speed);
    }

    @Test
    @DisplayName("Test that brake can not speed up the car")
    void brakeDoesNotGas() {
        Saab95 saab95 = new Saab95(4, Color.red,125, true);
        double speed = saab95.getCurrentSpeed();
        saab95.brake(1);
        assertTrue(saab95.getCurrentSpeed() <= speed);
    }
*/

    @Test
    @DisplayName("Ensure that currentSpeed does not exceed the engine power")
    void maxSpeedInterval() {
        saab95.startEngine();
        for (int i = 0; i < 50; i++) {saab95.gas(1);}
        assertTrue(saab95.getCurrentSpeed() <= saab95.getEnginePower());
    }

    @Test
    @DisplayName("Ensure that currentSpeed does not go below 0")
    void minSpeedInterval() {
        saab95.startEngine();
        for (int i = 0; i < 50; i++) {saab95.brake(1);}
        assertTrue(saab95.getCurrentSpeed() >= 0);
    }

}


class Volvo240Test {

    @Test
    @DisplayName("Test for move function, also tests trimFactor, gas, and brake")
    void move() {
        Volvo240 volvo240 = new Volvo240(Color.red,125,1.25);

        volvo240.startEngine();
        volvo240.gas(1);
        assertEquals(0, volvo240.getCords()[0]);
        assertEquals(1.6625, volvo240.getCords()[1]);
    }
}

class ScaniaTest {
    Scania scania;

    @BeforeEach
    void setUp() {
        this.scania = new Scania(Color.black,1000);
    }

    @Test
    @DisplayName("Test for move function, also tests trimFactor, gas, and brake")
    void move() {
        scania.startEngine();
        scania.gas(1);
        assertEquals(0, scania.getCords()[0]);
        assertEquals(10.1, scania.getCords()[1]);
        assertThrows(IllegalStateException.class, ()-> scania.changeTiltAngle(30.0));
        scania.stopEngine();
        scania.changeTiltAngle(30.0);
        assertThrows(IllegalStateException.class, ()-> scania.gas(1));
        scania.stopEngine();
        scania.changeTiltAngle(-30);
        scania.startEngine();
        scania.gas(1);
        assertEquals(0, scania.getCords()[0]);
        assertEquals(20.2, scania.getCords()[1]);
    }

    @Test
    @DisplayName("Tilt angle interval")
    void tiltInterval() {
        assertThrows(IllegalArgumentException.class, ()-> scania.changeTiltAngle(-1));
        assertThrows(IllegalArgumentException.class, ()-> scania.changeTiltAngle(71));
        scania.changeTiltAngle(60.0);
        assertEquals(60, scania.getTiltAngle());
    }
}

class CarTransportTest {
    CarTransport carTransport;
    CarTransport carTransport2;
    Saab95 saab95;

    @BeforeEach
    void setUp() {
        this.carTransport = new CarTransport(Color.black, 900, 3);
        this.saab95 = new Saab95(Color.black, 120, false);
    }

    @Test
    @DisplayName("Test loading a car/car transport")
    void loadCarTransport() {
        // Tilt
        assertThrows(IllegalStateException.class, () -> carTransport.load(saab95));
        carTransport.changeTiltState(true);
        carTransport.load(saab95);
        assertEquals(1, carTransport.getStorageSize());

        // Storage
        carTransport.load(saab95);
        carTransport.load(saab95);
        assertThrows(IllegalStateException.class, () -> carTransport.load(saab95));

        // Loading a truck
        carTransport2 = new CarTransport(Color.red, 788, 1);
        assertThrows(IllegalStateException.class, ()-> carTransport.load(carTransport2));

    }

    @Test
    @DisplayName("Test unloading a car")
    void unloadCar() {
        carTransport.changeTiltState(true);
        carTransport.load(saab95);
        carTransport.changeTiltState(false);
        assertThrows(IllegalStateException.class, ()-> carTransport.unload());

        assertEquals(1, carTransport.getStorageSize());

        carTransport.changeTiltState(true);
        carTransport.unload();
        assertEquals(1, saab95.getCords()[0]);
        assertEquals(1, saab95.getCords()[1]);

        assertEquals(0, carTransport.getStorageSize());
    }

    @Test
    @DisplayName("Test that loaded cars cords is the same as carTransport cords")
    void move() {
        carTransport.changeTiltState(true);
        carTransport.load(saab95);
        carTransport.changeTiltState(false);
        carTransport.startEngine();
        carTransport.gas(1);
        assertEquals(Arrays.toString(carTransport.getCords()), Arrays.toString(saab95.getCords()));
    }
}

class WorkshopTest {
    Workshop<Volvo240> workshopVolvo;
    Workshop<Car> workshopAll;
    Volvo240 volvo240;
    Saab95 saab95;

    @BeforeEach
    void setUp() {
        workshopVolvo = new Workshop<>(1);
        workshopAll = new Workshop<>(1);
        volvo240 = new Volvo240(Color.black,125,1.25);
        saab95 = new Saab95(Color.black, 120, false);
    }

    @Test
    @DisplayName("Test load function to not be compile error")
    void load(){
        workshopVolvo.load(volvo240);
        assertEquals(1, workshopVolvo.getStorageSize());

        // ! Uncomment below for compile error
        // workshopVolvo.load(saab95);

        workshopAll.load(volvo240);
        workshopAll.load(saab95);
        assertEquals(2, workshopAll.getStorageSize());
    }

    @Test
    void unload(){
        workshopVolvo.load(volvo240);
        assertEquals("Volvo240",workshopVolvo.unload().getModelName());
    }

}


class CarStorageTest {
    CarStorage<Car> carStorage;
    CarStorage<Volvo240> carStorageVolvo;
    Volvo240 volvo240;
    Saab95 saab95;

    @BeforeEach
    void setUp() {
        carStorage = new CarStorage<>(2);
        carStorageVolvo = new CarStorage<>(1);
        volvo240 = new Volvo240(Color.black,125,1.25);
        saab95 = new Saab95(Color.black, 120, false);
    }

    @Test
    @DisplayName("Load Test")
    public void load() {
        carStorage.load(volvo240);
        carStorage.load(saab95);
        assertEquals(2, carStorage.storage.size());
        assertThrows(IllegalStateException.class, ()-> carStorage.load(volvo240));

        carStorageVolvo.load(volvo240);
        assertEquals(1, carStorageVolvo.storage.size());
        assertThrows(IllegalStateException.class, ()-> carStorageVolvo.load(volvo240));
    }

    @Test
    @DisplayName("Unload test")
    public void unload() {
        carStorage.load(volvo240);
        carStorage.load(saab95);
        carStorage.unload();
        assertEquals(1, carStorage.storage.size());
        carStorage.unload();
        assertThrows(IllegalStateException.class, ()-> carStorage.unload());

    }

}