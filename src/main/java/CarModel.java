import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarModel {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarController frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Workshop> workshops = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarModel cc = new CarModel();
        cc.frame = new CarController("CarSim 1.0", cc);


        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                try {
                    car.move();
                } catch (Exception e2) {
                    System.out.println(car.getModelName() + e2.getMessage());
                }
                int x = (int) Math.round(car.getCords()[0]);
                int y = (int) Math.round(car.getCords()[1]);

                for (Workshop workshop : workshops) {
                    try {
                        workshop.load(car);
                        car.stopEngine();
                        double[] newcords = new double[2];
                        newcords[0] = x + 40;
                        newcords[1] = y - 40;
                        car.setCords(newcords);
                    } catch (Exception e2) {
                        System.out.println(car.getModelName() + e2.getMessage());
                    }
                }

                if (y >= 510){
                    car.turnLeft();
                    car.turnLeft();
                } else if (y < 0) {
                    car.turnRight();
                    car.turnRight();
                }
                frame.carView.moveit(car);
                // repaint() calls the paintComponent method of the panel
                frame.carView.repaint();
            }
        }
    }

    Car createNewCar() {
        Random rand = new Random();
        double[] lastCords = new double[] {0,0};
        try{
            lastCords = cars.getLast().getCords();
            lastCords[0] += 150;
        } catch (Exception e2) {
            System.out.println(e2.getMessage());
        }


        int randomIndex = rand.nextInt(3);

        switch (randomIndex) {
            case 0:
                cars.add(new VolvoFactory().createCar(lastCords));
                break;
            case 1:
                cars.add(new SaabFactory().createCar(lastCords));
                break;
            case 2:
                cars.add(new ScaniaFactory().createCar(lastCords));
                break;
        }
        return cars.getLast();
    }

    void start() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stop() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
            double gas = ((double) amount) / 100;
            for (Car car : cars) {
                try {
                    car.gas(gas);
                } catch(Exception e) {
                    System.out.println(car.getModelName() + e.getMessage());
                }
            }
    }

    // Calls the gas method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    void liftLiftBed() {
        for (Car car : cars) {
            if (car instanceof Scania scania) {
                try{
                    scania.changeTiltAngle(1.0);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    void lowerLiftBed() {
        for (Car car : cars) {
            if (car instanceof Scania scania) {
                try{
                    scania.changeTiltAngle(-1.0);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    // Calls the gas method for each car once
    void TurboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95 saab95) {
                saab95.setTurboOn();
            }
        }
    }

    // Calls the gas method for each car once
    void TurboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95 saab95) {
                saab95.setTurboOff();
            }
        }
    }

}
