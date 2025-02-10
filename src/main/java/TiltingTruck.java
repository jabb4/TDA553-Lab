import java.awt.*;


public abstract class TiltingTruck extends Truck {
    private double minTilt;
    private double maxTilt;
    private double currentTilt;

    /**
     * Constructor for a TiltingTruck with specified attributes.
     *
     * @param nrDoors Number of doors
     * @param minTilt Minimum tilt
     * @param maxTilt Maximum tilt
     * @param color Color of the car
     * @param enginePower The power of the car's engine
     * @param modelName The model name of the truck
     */
    public TiltingTruck(int nrDoors, double minTilt, double maxTilt, Color color, int enginePower, String modelName, int maxLoad) {
        super(nrDoors, color, enginePower, modelName, maxLoad);
        this.minTilt = minTilt;
        this.maxTilt = maxTilt;
        this.currentTilt = 0;
    }

    /**
     * Throws error if tilted in order to
     * make sure the vehicle cannot move if the trailer is tilted
     */
    @Override
    public void move() {
        if (currentTilt != 0) {
            throw new IllegalStateException("Can't move while tilted");
        }
        else super.move();
    }

    /**
     * Gets current tilt of trailer
     *
     * @return double, current tilt
     */
    public double getTiltAngle(){
        return this.currentTilt;
    }

    /**
     * Changes current tilt of trailer
     */
    public void changeTiltAngle(double delta) {
        if (this.getCurrentSpeed() != 0.0) {
            throw new IllegalStateException("Can't change tilt while moving");
        } else if (this.currentTilt + delta > maxTilt) {
            throw new IllegalArgumentException("Can't change tilt over " + maxTilt + " degrees.");
        } else if (this.currentTilt + delta < minTilt) {
            throw new IllegalArgumentException("Tilt cannot be lower than " + minTilt + " degrees.");
        } else {
            this.currentTilt += delta;
        }
    }
}
