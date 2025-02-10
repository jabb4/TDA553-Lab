import java.util.ArrayList;

/**
 * Representation of a storage unit that can store cars
 */
public class CarStorage<T> {
    public ArrayList<T> storage;
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
    public void load(T car) {
        if (storage.size() >= maxLoad) {
            throw new IllegalStateException("The storage is full");
        }
        storage.add(car);
    }

    /**
     * Unloads and returns the latest car added to the storage
     *
     * @return Car, car removed from storage
     */    public T unload() {
        if (storage.isEmpty()) {
            throw new IllegalStateException("There are no cars to unload");
        }
        return storage.removeLast();
    }

}
