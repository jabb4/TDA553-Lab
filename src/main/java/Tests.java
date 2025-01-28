import java.awt.*;
import java.util.Arrays;

public class Tests {
    private static final Saab95 saab = new Saab95(4,Color.red,125,"Saab95", false);
    public static void main(String[] args) {
        saab.startEngine();
        System.out.println(Arrays.toString(saab.getCords()));
    }
}
