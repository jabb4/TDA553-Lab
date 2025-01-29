import java.awt.*;
import java.lang.reflect.Array;

/**
 * Represents a generic baseplate of a car
 */
public abstract class Car implements Movable{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double xCord; // x coordinates of the car
    private double yCord; // y coordinates of the car
    public enum headings {
        north, south, east, west
    }
    private headings currentHeading = headings.north;

    /**
     * Constructor for Car with specified attributes.
     *
     * @param nrDoors Number of doors on the car
     * @param color Color of the car
     * @param enginePower The power of the car's engine
     * @param modelName The car's model name
     */
    public Car(int nrDoors, Color color, int enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
    }

    /**
     * Gets current cords of the car
     *
     * @return array of double, The x and y cords of the car
     */
    public double[] getCords() {
            double[]cords = new double[2];
            cords[0]=this.xCord;
            cords[1]=this.yCord;
            return cords;
    }

    /**
     * A method to get nr of doors on car
     *
     * @return int, numbers of doors
     */
    public int getNrDoors(){
            return this.nrDoors;
    }

    /**
     * Gets cars engine power
     *
     * @return the cars engine power
     */
    public double getEnginePower(){
        return this.enginePower;
    }

    /**
     * Gets the current speed of the car
     *
     * @return current speed of the car
     */
    public double getCurrentSpeed(){
        return this.currentSpeed;
    }

    /**
     * Gets color of the car
     *
     * @return color
     */
    public Color getColor(){
        return this.color;
    }

    /**
     * Change the color of the car
     *
     * @param clr color you want to set the car to
     */
    public void setColor(Color clr){
        this.color = clr;
    }

    /**
     * Gets the current heading of the car
     *
     * @return Heading
     */
    public headings getHeading() {
        return this.currentHeading;
    }

    /**
     * When starting car, sets current speed to
     */
    public void startEngine(){
        this.currentSpeed = 0.1;
    }

    /**
     * When stopping car engine, set current speed
     */
    public void stopEngine(){
        this.currentSpeed = 0;
    }

    /**
     *  This is just a template of speedFactor that should be overridden in the subclasses
     */
    public abstract double speedFactor();

    /**
     * Increses current speed of the car
     * @param amount The amount factor to increes the speed with.
     */
    public void incrementSpeed(double amount){
            // prevents from decressing speed by doing Math.max()
        this.currentSpeed = Math.min(getCurrentSpeed() + Math.max(speedFactor() * amount,0), this.enginePower);
    }

    /**
     * Decresses current speed of the car
     * @param amount The amount factor to decrese the speed with.
     */
    public void decrementSpeed(double amount){
            // prevents from incressing speed by doing Math.max()
        this.currentSpeed = Math.max(getCurrentSpeed() - Math.max(speedFactor() * amount,0),0);
    }

    /**
     * Increses the speed of the car and move the car in the current heading
     * @param amount factor to brake
     */
    public void gas(double amount){
        if (0 <= amount && 1 >= amount) {
            incrementSpeed(amount);
            move();
        } else {
            throw new IllegalArgumentException("amount must be between 0 and 1");
        }
    }

    /**
     * Decress the speed of the car and move the car in the current heading
     * @param amount factor to brake
     */
    public void brake(double amount){
        if (0 <= amount && 1 >= amount) {
            decrementSpeed(amount);
            move();
        } else {
            throw new IllegalArgumentException("amount must be between 0 and 1");
        }
    }

    /**
     * Moves the car in the current heading the amount of the current speed
     */
    @Override
    public void move() {
        switch (this.currentHeading) {
            case north:
                this.yCord += getCurrentSpeed();
                break;
            case east:
                this.xCord += getCurrentSpeed();
                break;
            case south:
                this.yCord -= getCurrentSpeed();
                break;
            case west:
                this.xCord -= getCurrentSpeed();
                break;
        }
    }

    /**
     * Turns the car left (clockwise) (Changes the heading)
     */
    @Override
    public void turnLeft() {
        switch (this.currentHeading) {
            case north:
                this.currentHeading = headings.west;
                break;
            case east:
                this.currentHeading = headings.north;
                break;
            case south:
                this.currentHeading = headings.east;
                break;
            case west:
                this.currentHeading = headings.south;
                break;
        }
    }

    /**
     * Turns the car right (clockwise). (Changes the heading)
     */
    @Override
    public void turnRight() {
        switch (this.currentHeading) {
            case north:
                this.currentHeading = headings.east;
                break;
            case east:
                this.currentHeading = headings.south;
                break;
            case south:
                this.currentHeading = headings.west;
                break;
            case west:
               this.currentHeading = headings.north;
                break;
        }
    }

}
