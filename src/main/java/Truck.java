import java.awt.*;

public abstract class Truck extends Car{
    private double minTilt;
    private double maxTilt;
    private double currentTilt;
    private boolean tilted;

    /**
     * Constructor for Truck with specified attributes.
     *
     * @param minTilt Minimum tilt
     * @param maxTilt Maximum tilt
     * @param color Color of the car
     * @param enginePower The power of the car's engine
     * @param modelName The model name of the truck
     */
    public Truck(double minTilt, double maxTilt, Color color, int enginePower, String modelName) {
        super(2, color, enginePower, modelName);
        this.minTilt = minTilt;
        this.maxTilt = maxTilt;
        this.currentTilt = 0;
        this.tilted = false;
    }

    /**
     * Throws error if tilted in order to
     * make sure the vehicle cannot move if the trailer is tilted
     */
    @Override
    public void move() {
        if (isTilted()) {
            throw new IllegalStateException("Can't move while tilted");
        }
        else super.move();
    }

    /**
     * Gets current tilt of trailer
     *
     * @return boolean, current tilt state
     */
    public boolean isTilted(){
        return this.tilted;
    }

    /**
     * Gets current tilt of trailer
     *
     * @return double, current tilt
     */
    public double getTiltAngle(){
        return this.currentTilt;
    }

    public void changeTiltState(boolean state){
        this.tilted = state;
    }

    /**
     * Changes current tilt of trailer
     */
    public void changeTiltAngle(double delta) {
        if (this.getCurrentSpeed() != 0.0){
            throw new IllegalStateException("Can't change tilt while moving");
        }
        else if (this.currentTilt + delta > maxTilt){
            throw new IllegalArgumentException("Can't change tilt over " + maxTilt + " degrees.");
        } else if (this.currentTilt + delta < minTilt) {
            throw new IllegalArgumentException("Tilt cannot be lower than " + minTilt + " degrees.");
        } else {
            this.currentTilt += delta;
            changeTiltState(this.currentTilt != 0);
        }
    }
}
