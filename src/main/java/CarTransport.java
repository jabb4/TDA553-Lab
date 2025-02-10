import java.awt.*;

import static java.lang.Math.abs;

public abstract class CarTransport extends Truck{
    private int maxLoad;
    private CarStorage<Car> carStorage;
    private boolean tilted;

    /**
     * Constructor for CarTransport
     *
     * @param nrDoors Number of doors
     * @param color Color of the car
     * @param enginePower The power of the car's engine
     * @param maxLoad Max load of Car Transport
     * @param modelName Model name of the Car Transport
     */
    public CarTransport(int nrDoors, Color color, int enginePower, int maxLoad, String modelName) {
        super(nrDoors,color,enginePower, modelName);
        this.maxLoad = maxLoad;
        this.carStorage = new CarStorage<>(maxLoad);
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
     * Changes the current tilt state of the car transport
     */
    public void changeTiltState(boolean state){
        this.tilted = state;
    }


    /**
     * Loads a car in the carStorage using the load() function of carStorage,
     * and sets cords of car to the same as the car transport.
     */
    public void load(Car car){
        //Check tilted
        if (!this.isTilted()) throw new IllegalStateException("Can not load car while trailer is not tilted");

        // Check that loaded item is not a truck
        if (car instanceof CarTransport) throw new IllegalStateException("Can not load Trucks");

        //Check distances
        if (abs(car.getCords()[0] - this.getCords()[0]) <=1 && abs(car.getCords()[1] - this.getCords()[1]) <=1){
            carStorage.load(car);
            //Set car cords accordingly to the transport cords
            car.setCords(this.getCords());
        } else throw new IllegalStateException("Can not load car while car is too far away from trailer");
    }

    /**
     * Unloads the latest stored car using the unload() function of carStorage
     */
    public void unload(){
        double[]newCords = new double[2];
        newCords[0] = this.getCords()[0] + 1;
        newCords[1] = this.getCords()[1] + 1;

        //Check tilted
        if (!this.isTilted()) throw new IllegalStateException("Can not unload car while trailer is not tilted");

        carStorage.unload().setCords(newCords);

    }

    /**
     * Returns the number of current stored cars in the car transport storage
     *
     * @return int, amount of stored cars
     */
    public int getStorageSize(){return carStorage.storage.size();}

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
            for (Car car : carStorage.storage) {
                car.setCords(this.getCords());
            }
        }
    }

}
