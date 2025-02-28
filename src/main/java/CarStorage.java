import java.util.ArrayList;

import static java.lang.Math.abs;

/**
 * Representation of a storage unit that can store cars
 */
public class CarStorage implements Storage<Car> {
    public ArrayList<Car> storage;
    private int maxLoad;

    /**
     * Constructor for CarStorage
     *
     * @param maxLoad Maximum amount of cars that can be stored in the unit
     */
    public CarStorage(int maxLoad) {
        this.storage = new ArrayList<>();
        this.maxLoad = maxLoad;
    }

    /**
     * Loads a car to the storage unit if it's not full
     *
     * @param car allowed car type to be loaded
     */
    public void load(Car car, double[] transportCords) {
        if (storage.size() >= maxLoad) {
            throw new IllegalStateException("The storage is full");
        }
        if (storage.contains(car)){
            throw new IllegalArgumentException("The car is already in the storage");
        }
        //Check distances
        if (Utils.isNear(transportCords, car.getCords(), 40)){
            //Set car cords accordingly to the transport cords
            car.setCords(transportCords);
            storage.add(car);
        } else throw new IllegalStateException("Can not load car while car is too far away from trailer");

    }


    /**
     * Unloads and returns the latest car added to the storage
     *
     * @return Car, car removed from storage
     */
    public Car unload(double[] transportCords) {
        if (this.storage.isEmpty()) {
            throw new IllegalStateException("There are no cars to unload");
        }

        double[]newCords = new double[2];
        newCords[0] = transportCords[0] + 1;
        newCords[1] = transportCords[1] + 1;
        storage.getLast().setCords(newCords);
        return storage.removeLast();
    }

    /**
     * updates the cords of the cars in the storage
     * @param newCords cords of the transport
     */
    public void updateCarCords(double[] newCords) {
        for (Car car : this.storage) {
            car.setCords(newCords);
        }
    }

    /**
     * Returns the number of current stored cars in the car transport storage
     *
     * @return int, amount of stored cars
     */
    public int getStorageSize() { return storage.size(); }

}
