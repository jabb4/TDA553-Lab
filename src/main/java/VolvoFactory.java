import java.awt.*;

public class VolvoFactory extends CarFactory {

    @Override
    public Car createCar(double[] cords) {
        return new Volvo240(Color.red, 100, 0.5, cords);
    }
}