import java.awt.*;

/**
 * Generic representation of a truck
 */
public abstract class Truck extends Car {
    private int maxLoad;
    /**
     * Constructor for Truck with specified attributes.
     *
     * @param nrDoors Number of doors
     * @param color Color of the car
     * @param enginePower The power of the car's engine
     * @param modelName The model name of the truck
     */
    public Truck(int nrDoors, Color color, int enginePower, String modelName, int maxLoad) {
        super(nrDoors, color, enginePower, modelName);
        this.maxLoad = maxLoad;
    }

}

