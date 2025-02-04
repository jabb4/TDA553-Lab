import java.awt.*;

public class Scania extends Car{

    private double tilt;

    public Scania(Color color, int enginePower){
        super(2, color, enginePower, "Scania Truck");
        this.tilt = 0.0;
    }


    public void changeTilt(double delta) {
        if (this.getCurrentSpeed() != 0.0){
            
        }
        else if (this.tilt + delta < 70.0 && this.tilt + delta > 0.0) {
            this.tilt += delta;
        }

    }

    public boolean checkTilt(){
        boolean loweredStatus;

        if (this.tilt == 0){
            loweredStatus = true;
        } else {
            loweredStatus = false;
        }
        return loweredStatus;
    }

    @Override
    public double speedFactor() {
        return 0;
    }
}
