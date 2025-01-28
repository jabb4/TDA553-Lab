import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
class Saab95Test {
    private final Saab95 saab95 = new Saab95(4, Color.red,125,"Saab95", false);

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
        saab95.startEngine();
        saab95.gas(1);
        saab95.move();
        assertEquals(1.1, saab95.getCurrentSpeed());
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
        saab95.startEngine();
        assertEquals(0.1, saab95.getCurrentSpeed());

    }

    @Test
    @DisplayName("Stop engine")
    void stopEngine() {
        saab95.stopEngine();
        assertEquals(0, saab95.getCurrentSpeed());
    }

    @Test
    @DisplayName("Check move cords")
    void move() {
        saab95.startEngine();
        saab95.gas(1);
        saab95.move();
        assertEquals(0, saab95.getCords()[0]);
        assertEquals(1.1, saab95.getCords()[1]);

        saab95.turnRight();
        saab95.move();
        assertEquals(1.1, saab95.getCords)[0];
        assertEquals(1.1, saab95.getCords)[1];

        saab95.brake(1);
        saab95.move();
        assertEquals(1.2, saab95.getCords)[0];
        assertEquals(1.1, saab95.getCords)[1];
    }

    @Test
    @DisplayName("Turn left")
    void turnLeft() {
        saab95.setHeading("north");
        saab95.turnLeft();
        assertEquals("west", saab95.getHeading());
        saab95.turnLeft();
        assertEquals("south", saab95.getHeading());
    }

    @Test
    @DisplayName("Check turn right")
    void turnRight() {
        saab95.setHeading("north");
        saab95.turnRight();
        assertEquals("east", saab95.getHeading());
        saab95.turnRight();
        assertEquals("south", saab95.getHeading());
    }

    @Test
    void setTurboOn() {
        saab95.setTurboOff();
        saab95.setTurboOn();
        assertEquals(true, saab95.turboStatus());
        saab95.setTurboOn();
        assertEquals(true, saab95.turboStatus());
    }

    @Test
    void setTurboOff() {
        saab95.setTurboOn();
        saab95.setTurboOff();
        assertEquals(false, saab95.turboStatus());
        saab95.setTurboOff();
        assertEquals(false, saab95.turboStatus());
    }
}