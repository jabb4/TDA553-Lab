import java.util.ArrayList;

/**
 * A workshop for cars
 * @param <T> the type of car to be able to handel
 */
public class Workshop<T extends Car> {
    private CarStorage<T> carStorage;

    public Workshop(int maxLoad) {
        this.carStorage = new CarStorage<>(maxLoad);
    }

    public void load(T car) {
        this.carStorage.load(car);
        car.setDriveable(false);
    }

    public T unload() {
        T unloaded = this.carStorage.unload();
        unloaded.setDriveable(true);
        return unloaded;
    }

    public CarStorage<T> getLoaded() {
        return this.carStorage;
    }

    public int getStorageSize() {
        return this.carStorage.storage.size();
    }
}
