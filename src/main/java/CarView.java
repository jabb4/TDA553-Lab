import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Map.Entry;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class CarView extends JPanel{
    private ArrayList<Point> graphicalCarsPoints = new ArrayList<>();
    private ArrayList<BufferedImage> graphicalCarsImages = new ArrayList<>();
    BufferedImage volvoImage;
    BufferedImage volvoWorkshopImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    public void addGraphicalCar(Car car){
        Point cords = new Point((int)car.getCords()[0], (int)car.getCords()[1]);
        this.graphicalCarsPoints.add(cords);
        switch (car) {
            case Volvo240 volvo240 -> this.graphicalCarsImages.add(volvoImage);
            case Saab95 saab95 -> this.graphicalCarsImages.add(saabImage);
            case Scania scania -> this.graphicalCarsImages.add(scaniaImage);
            default -> throw new IllegalArgumentException("Invalid car type");
        }
    }

    void moveit(Car car){
        this.graphicalCarsPoints.set(car.getID(), new Point((int)car.getCords()[0], (int)car.getCords()[1]));
    }

    // Initializes the panel and reads the images
    public CarView(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(CarView.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(CarView.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            scaniaImage = ImageIO.read(CarView.class.getResourceAsStream("pics/Scania.jpg"));
            saabImage = ImageIO.read(CarView.class.getResourceAsStream("pics/Saab95.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < this.graphicalCarsPoints.size(); i++ ){
            g.drawImage(this.graphicalCarsImages.get(i), this.graphicalCarsPoints.get(i).x, this.graphicalCarsPoints.get(i).y, null);
        }
    }
}
