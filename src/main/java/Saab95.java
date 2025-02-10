import java.awt.*;

public class Saab95 extends Car {
    private boolean turboOn;

    /**
     * Constructor for Car with specified attributes.
     *
     * @param color Color of the car
     * @param enginePower The power of the car's engine
     * @param turboOn The turbo function of the car
     */
    public Saab95(Color color, int enginePower, boolean turboOn){
        super(4, color, enginePower, "Saab95");
	    this.turboOn = turboOn;
    }

    /**
     * Gets status of car's turbo function
     *
     * @return boolean, on or off
     */
    public boolean turboStatus() {return this.turboOn;}


    /**
     * Turns the turbo function of the car on
     */
    public void setTurboOn(){
	    this.turboOn = true;
    }


    /**
     * Turns the turbo function of the car off
     */
    public void setTurboOff(){this.turboOn = false;
    }


    /**
     * Calculates the speedfactor of the car based on if the turbo function is on or off.
     * Used in incrementing the speed of the car
     *
     * @return double, speedFactor
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(this.turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
