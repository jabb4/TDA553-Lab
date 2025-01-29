import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
class Saab95Test {
    //private final Saab95 saab95 = new Saab95(4, Color.red,125,"Saab95", false);

    @Test
    @DisplayName("Coordinates")
    void getCords() {
        Saab95 saab95 = new Saab95(4, Color.red,125,"Saab95", false);
        assertEquals("[0.0, 0.0]", Arrays.toString(saab95.getCords()));
    }

    @Test
    @DisplayName("Engine power")
    void getEnginePower() {
        Saab95 saab95 = new Saab95(4, Color.red,125,"Saab95", false);
        assertEquals(125, saab95.getEnginePower());
    }

    @Test
    @DisplayName("Current speed")
    void getCurrentSpeed() {
    }

    @Test
    @DisplayName("Current color")
    void getColor() {
        Saab95 saab95 = new Saab95(4, Color.red,125,"Saab95", false);
        assertEquals(Color.red, saab95.getColor());
    }

    @Test
    @DisplayName("Set color")
    void setColor() {
        Saab95 saab95 = new Saab95(4, Color.red,125,"Saab95", false);
        saab95.setColor(Color.blue);
        assertEquals(Color.blue, saab95.getColor());
    }

    @Test
    @DisplayName("Start engine")
    void startEngine() {

    }

    @Test
    @DisplayName("Stop engine")
    void stopEngine() {
    }

    @Test
    void gas() {
    }

    @Test
    void brake() {
    }

    @Test
    @DisplayName("Check move coords")
    void move() {
        Saab95 saab95 = new Saab95(4, Color.red,125,"Saab95", false);
        saab95.startEngine();
        saab95.gas(1);
        assertEquals(0, saab95.getCords()[0]);
        assertEquals(1.35, saab95.getCords()[1]);
    }

    @Test
    @DisplayName("Turn left")
    void turnLeft() {
        Saab95 saab95 = new Saab95(4, Color.red,125,"Saab95", false);
        saab95.turnLeft();
        assertEquals("west", saab95.getHeading());
        saab95.turnLeft();
        assertEquals("south", saab95.getHeading());
    }

    @Test
    @DisplayName("Check turn right")
    void turnRight() {
        Saab95 saab95 = new Saab95(4, Color.red,125,"Saab95", false);
        saab95.turnRight();
        assertEquals("east", saab95.getHeading());
        saab95.turnRight();
        assertEquals("south", saab95.getHeading());
    }

    @Test
    void setTurboOn() {
        Saab95 saab95 = new Saab95(4, Color.red,125,"Saab95", false);
        saab95.setTurboOn();
        assertTrue(saab95.turboStatus());
        saab95.setTurboOn();
        assertTrue(saab95.turboStatus());
    }

    @Test
    void setTurboOff() {
        Saab95 saab95 = new Saab95(4, Color.red,125,"Saab95", true);
        saab95.setTurboOff();
        assertFalse(saab95.turboStatus());
        saab95.setTurboOff();
        assertFalse(saab95.turboStatus());
    }
}