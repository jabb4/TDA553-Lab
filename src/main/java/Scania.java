import java.awt.*;

public class Scania extends TiltingTruck {
    /**
     * Constructor for Car with specified attributes.
     *
     * @param color Color of the car
     * @param enginePower The power of the car's engine
     */
    public Scania(Color color, int enginePower, int maxLoad){
        super(2, 0.0, 70.0, color, enginePower, "Scania Truck", maxLoad);
    }


    /**
     * Sets speedFactor of vehicle
     *
     * @return double, speedFactor
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
}
