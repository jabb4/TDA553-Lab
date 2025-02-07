import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class CarTransport extends Truck{
    private int maxLoad;
    private CarStorage<Car> carStorage;

    public CarTransport(Color color, int enginePower, int maxLoad) {
        super(0,1,color,enginePower,"Car Transport");
        this.maxLoad = maxLoad;
        this.carStorage = new CarStorage<>(maxLoad);
    }

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

    public void unload(){
        double[]newCords = new double[2];
        newCords[0] = this.getCords()[0] + 1;
        newCords[1] = this.getCords()[1] + 1;

        //Check tilted
        if (!this.isTilted()) throw new IllegalStateException("Can not unload car while trailer is not tilted");

        carStorage.unload().setCords(newCords);

    }

    public int getStorageSize(){return carStorage.storage.size();}

    /**
     * Sets coords
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

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
}
