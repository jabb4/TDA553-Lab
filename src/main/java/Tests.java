public class Tests {
    private static Saab95 saab = new Saab95();
    public static void main(String[] args) {
        saab.startEngine();
        saab.gas(1);
        System.out.println(saab.getCurrentSpeed());
        System.out.println("X:" + String.valueOf(saab.getCords()[0]) + " Y:" + String.valueOf(saab.getCords()[1]));
        saab.turnLeft();
        saab.gas(1);
        System.out.println(saab.getCurrentSpeed());
        System.out.println("X:" + String.valueOf(saab.getCords()[0]) + " Y:" + String.valueOf(saab.getCords()[1]));
        saab.turnRight();
        saab.gas(1);
        System.out.println(saab.getCurrentSpeed());
        System.out.println("X:" + String.valueOf(saab.getCords()[0]) + " Y:" + String.valueOf(saab.getCords()[1]));
        saab.brake(1);
        System.out.println(saab.getCurrentSpeed());
        System.out.println("X:" + String.valueOf(saab.getCords()[0]) + " Y:" + String.valueOf(saab.getCords()[1]));
        saab.brake(1);
        System.out.println(saab.getCurrentSpeed());
        System.out.println("X:" + String.valueOf(saab.getCords()[0]) + " Y:" + String.valueOf(saab.getCords()[1]));
        saab.brake(1);
        System.out.println(saab.getCurrentSpeed());
        System.out.println("X:" + String.valueOf(saab.getCords()[0]) + " Y:" + String.valueOf(saab.getCords()[1]));
        saab.brake(1);
        System.out.println(saab.getCurrentSpeed());
        System.out.println("X:" + String.valueOf(saab.getCords()[0]) + " Y:" + String.valueOf(saab.getCords()[1]));
        saab.brake(1);
        System.out.println(saab.getCurrentSpeed());
        System.out.println("X:" + String.valueOf(saab.getCords()[0]) + " Y:" + String.valueOf(saab.getCords()[1]));
    }
}
