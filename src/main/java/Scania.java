import java.awt.*;

public class Scania extends Car{

    private double tilt;

    /**
     * Constructor for Car with specified attributes.
     *
     * @param color Color of the car
     * @param enginePower The power of the car's engine
     */
    public Scania(Color color, int enginePower){
        super(2, color, enginePower, "Scania Truck");
        this.tilt = 0.0;
    }

    /**
     * Changes current tilt of trailer
     */
    public void changeTilt(double delta) {
        if (this.getCurrentSpeed() != 0.0){
            throw new IllegalStateException("Can't change tilt while moving");
        }
        else if (this.tilt + delta > 70.0){
            throw new IllegalArgumentException("Can't change tilt over 70.0");
        } else if (this.tilt + delta < 0.0) {
            throw new IllegalArgumentException("Tilt cannot be lower than 0");
        } else this.tilt += delta;
    }

    /**
     * Gets current tilt of trailer
     *
     * @return double, current tilt
     */
    public double getTilt(){
        return this.tilt;
    }

    /**
     * Throws error if tilt is higher than 0 in order to
     * make sure the vehicle cannot move if the trailer is tilted
     */
    @Override
    public void move() {
        if (this.tilt != 0.0) {
            throw new IllegalStateException("Can't move while tilted");
        }
        else super.move();
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
