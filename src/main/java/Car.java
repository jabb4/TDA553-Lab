import java.awt.*;
import java.lang.reflect.Array;

public class Car implements Movable{

        public int nrDoors; // Number of doors on the car
        public double enginePower; // Engine power of the car
        public double currentSpeed; // The current speed of the car
        public Color color; // Color of the car
        public String modelName; // The car model name
        private double xCord;
        private double yCord;
        private String heading = "north";

        public double[] getCords() {
            double[]cords = new double[2];
            cords[0]=xCord;
            cords[1]=yCord;
            return cords;
        }

        public int getNrDoors(){
            return nrDoors;
        }

        public double getEnginePower(){
            return enginePower;
        }

        public double getCurrentSpeed(){
            return currentSpeed;
        }

        public Color getColor(){
            return color;
        }

        public void setColor(Color clr){
            color = clr;
        }

        public void startEngine(){
            currentSpeed = 0.1;
        }

        public void stopEngine(){
            currentSpeed = 0;
        }

        //This will be overridden in the subclasses
        public double speedFactor(){return 0.0;}

        public void incrementSpeed(double amount){
                // prevents from decressing speed by doing Math.max()
                currentSpeed = Math.min(getCurrentSpeed() + Math.max(speedFactor() * amount,0), enginePower);
        }

        public void decrementSpeed(double amount){
                // prevents from incressing speed by doing Math.max()
                currentSpeed = Math.max(getCurrentSpeed() - Math.max(speedFactor() * amount,0),0);
        }

        public void gas(double amount){
            if (0 <= amount || 1 >= amount) {
                incrementSpeed(amount);
                move();
            }
        }

        public void brake(double amount){
            if (0 <= amount || 1 >= amount) {
                decrementSpeed(amount);
                move();
            }
        }

        @Override
        public void move() {
            switch (heading) {
                case "north":
                    this.yCord += getCurrentSpeed();
                    break;
                case "east":
                    this.xCord += getCurrentSpeed();
                    break;
                case "south":
                    this.yCord -= getCurrentSpeed();
                    break;
                case "west":
                    this.xCord -= getCurrentSpeed();
                    break;
            }
        }

        @Override
        public void turnLeft() {
            switch (heading) {
                case "north":
                    this.heading = "west";
                    break;
                case "east":
                    this.heading = "north";
                    break;
                case "south":
                    this.heading = "east";
                    break;
                case "west":
                    this.heading = "south";
                    break;
            }
        }

        @Override
        public void turnRight() {
            switch (heading) {
                case "north":
                    this.heading = "east";
                    break;
                case "east":
                    this.heading = "south";
                    break;
                case "south":
                    this.heading = "west";
                    break;
                case "west":
                    this.heading = "north";
                    break;
            }
        }

}
