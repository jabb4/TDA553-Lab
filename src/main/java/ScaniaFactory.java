import java.awt.*;

public class ScaniaFactory extends CarFactory {
    
    @Override
    public Car createCar(double[] cords) {
        return new Scania(Color.red, 100, 3, cords);
    }
}