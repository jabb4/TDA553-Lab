import java.awt.*;

public class VolvoCarTransport extends CarTransport {
    private CarStorage<Car> carStorage;

    /**
     * Constructor for VolvoCarTransport
     *
     * @param color Color of the car
     * @param enginePower The power of the car's engine
     */
    public VolvoCarTransport(Color color, int enginePower) {
        super(2, color,enginePower, 100, "Car Transport");
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
