import java.awt.*;

public class SaabFactory extends CarFactory {
    
    @Override
    public Car createCar(double[] cords) {
        return new Saab95(Color.red, 100, false, cords);
    }
}