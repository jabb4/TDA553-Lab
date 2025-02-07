import java.util.ArrayList;

public class CarStorage<T> {
    public ArrayList<T> storage;
    private int maxLoad;

    public CarStorage(int maxLoad) {
        this.storage = new ArrayList<>();
        this.maxLoad = maxLoad;
    }

    public void load(T car) {
        if (storage.size() >= maxLoad) {
            throw new IllegalStateException("The storage is full");
        }
        storage.add(car);
    }

    public T unload() {
        if (storage.isEmpty()) {
            throw new IllegalStateException("There are no cars to unload");
        }
        return storage.removeLast();
    }

}
