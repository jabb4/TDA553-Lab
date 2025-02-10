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
    }

    public T unload() {
        return this.carStorage.unload();
    }

    public int getStorageSize() {
        return this.carStorage.storage.size();
    }
}
