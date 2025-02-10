import java.awt.*;

import static java.lang.Math.abs;

public class CarTransport {
    private int maxLoad;
    private CarStorage<Car> carStorage;

    /**
     * Constructor for CarTransport
     *
     * @param maxLoad Max load of Car Transport
     */
    public CarTransport(int maxLoad) {
        this.maxLoad = maxLoad;
        this.carStorage = new CarStorage<>(maxLoad);
    }

    /**
     * Loads a car in the carStorage using the load() function of carStorage,
     * and sets cords of car to the same as the car transport.
     */
    public void load(Car car, double[] transportCords) {
        //Check distances
        if (abs(car.getCords()[0] - transportCords[0]) <=1 && abs(car.getCords()[1] - transportCords[1]) <=1){
            //Set car cords accordingly to the transport cords
            car.setCords(transportCords);
            carStorage.load(car);
        } else throw new IllegalStateException("Can not load car while car is too far away from trailer");
    }

    /**
     * Unloads the latest stored car using the unload() function of carStorage
     */
    public void unload(double[] transportCords) {
        double[]newCords = new double[2];
        newCords[0] = transportCords[0] + 1;
        newCords[1] = transportCords[1] + 1;
        carStorage.unload().setCords(newCords);
    }

    /**
     * updates the cords of the cars in the storage
     * @param newCords cords of the transport
     */
    public void updateCarCords(double[] newCords) {
        for (Car car : this.carStorage.storage) {
            car.setCords(newCords);
        }
    }

    /**
     * Returns the number of current stored cars in the car transport storage
     *
     * @return int, amount of stored cars
     */
    public int getStorageSize() { return carStorage.storage.size(); }


}
