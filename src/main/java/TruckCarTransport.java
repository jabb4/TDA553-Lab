import java.awt.*;

public class TruckCarTransport extends Truck {
    private boolean tilted;
    private CarStorage carStorage;

    /**
     * Constructor for Truck with specified attributes.
     *
     * @param color Color of the car
     * @param enginePower The power of the car's engine
     * @param modelName The model name of the truck
     */
    public TruckCarTransport(Color color, int enginePower, String modelName,int maxLoad, double[] cords) {
        super(2, color, enginePower, modelName, maxLoad, cords);
        this.carStorage = new CarStorage(maxLoad);
        this.tilted = false;
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
     * Loads a car in the carTransport using the load() function of carTransport,
     * and sets cords of car to the same as the car transport.
     */
    public void load(Car car) {
        //Check tilted
        if (!this.isTilted()) throw new IllegalStateException("Can not load car while trailer is not tilted");

        // Check that loaded item is not a truck
        if (car instanceof Truck) throw new IllegalStateException("Can not load Trucks");

        carStorage.load(car, this.getCords());
    }

    /**
     * Unloads the latest stored car using the unload() function of carTransport
     */
    public void unload() {
        //Check tilted
        if (!this.isTilted()) throw new IllegalStateException("Can not unload car while trailer is not tilted");

        carStorage.unload(this.getCords());
    }

    /**
     * Changes the current tilt state of the car transport
     */
    public void changeTiltState(boolean state){
        this.tilted = state;
    }

    /**
     * Returns the number of current stored cars in the car transport storage
     *
     * @return int, amount of stored cars
     */
    public int getStorageSize() { return carStorage.storage.size(); }

    /**
     * Overrides move() in order to check if the trailer is tilted,
     * and sets the cords of all the cars in the Car Transports storage to
     * the same as the Car Transport
     */
    @Override
    public void move() {
        if (isTilted()) {
            throw new IllegalStateException("Can't move while tilted");
        }
        else {
            super.move();
            carStorage.updateCarCords(this.getCords());
        }
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
