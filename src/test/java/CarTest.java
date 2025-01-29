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
        assertEquals(Car.headings.west, saab95.getHeading());
        saab95.turnLeft();
        assertEquals(Car.headings.south, saab95.getHeading());
    }

    @Test
    @DisplayName("Check turn right")
    void turnRight() {
        saab95.turnRight();
        assertEquals(Car.headings.east, saab95.getHeading());
        saab95.turnRight();
        assertEquals(Car.headings.south, saab95.getHeading());
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