import java.awt.*;

/**
 * A Volvo240 car that is a subclass of car
 */
public class Volvo240 extends Car {
    private double trimFactor; //Used to calculate speedFactor

    /**
     * Constructor for Volvo240 with specified attributes.
     *
     * @param color Color of the car
     * @param enginePower The power of the car's engine
     * @param trimFactor The car's trim factor
     */
    public Volvo240(Color color, int enginePower, double trimFactor){
        super(4, color, enginePower, "Volvo 240");
        if (trimFactor < 0) {
            throw new IllegalArgumentException("trimFactor must be a positive number");
        }
        this.trimFactor = trimFactor;
    }

    /**
     * Calculates speedFactor used to increment speed
     *
     * @return speedFactor
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * this.trimFactor;
    }

}
