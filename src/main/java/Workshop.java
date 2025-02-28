import java.util.ArrayList;

/**
 * A workshop for cars
 * @param <T> the type of car to be able to handel
 */
public class Workshop<T extends Car> {
    private CarStorage carStorage;
    private double xCord;
    private double yCord;


    public Workshop(int maxLoad, double[] cords) {
        this.xCord = cords[0];
        this.yCord = cords[1];
        this.carStorage = new CarStorage(maxLoad); {
        };
    }

    public void load(T car) {

        this.carStorage.load(car, new double[] {xCord, yCord});
        car.setDriveable(false);
    }

    public Car unload() {
        Car unloaded = this.carStorage.unload(new double[]{xCord, yCord});
        unloaded.setDriveable(true);
        return unloaded;
    }

    public int getStorageSize() {
        return this.carStorage.getStorageSize();
    }
}
