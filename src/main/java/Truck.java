import java.awt.*;

public abstract class Truck extends Car{
    /**
     * Constructor for Truck with specified attributes.
     *
     * @param nrDoors Number of doors
     * @param color Color of the car
     * @param enginePower The power of the car's engine
     * @param modelName The model name of the truck
     */
    public Truck(int nrDoors, Color color, int enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }
}

