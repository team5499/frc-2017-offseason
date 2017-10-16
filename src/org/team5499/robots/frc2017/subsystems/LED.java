package org.team5499.robots.frc2017.subsystems;

import org.team5499.robots.frc2017.Reference;
import edu.wpi.first.wpilibj.DigitalOutput;
import java.util.ArrayList;
import edu.wpi.first.wpilibj.Timer;

public class LED {
    private Timer timer;

    private Color currentColor;
    private Color prevColor;
    private DigitalOutput redController, greenController, blueController;

    public ArrayList<Color> colorSequence = new ArrayList<>();
    public int sequenceIndex = -1;

    public Color red, green, blue, white;

    double current_time_millis;
    double last_time_millis;
    

    public LED() {
        timer.start();
        redController = new DigitalOutput(Reference.red_port);
        greenController = new DigitalOutput(Reference.green_port);
        blueController = new DigitalOutput(Reference.blue_port);
        red = new Color(255, 0, 0);
        green = new Color(0, 255, 0);
        blue = new Color(0, 0, 255);
        white = new Color(255, 255, 255);
        sequenceIndex = 0;

        current_time_millis = 0;
        last_time_millis = 0;
    
    }

    private void updateController(Color color) {
        redController.updateDutyCycle(color.getRed());
        greenController.updateDutyCycle(color.getGreen());
        blueController.updateDutyCycle(color.getBlue());
    }

    public void setRGB(Color color, boolean setVal, boolean setVar) {
        if(setVar) {
            currentColor = color;
        }
        if(setVal) updateController(color);
    }

    public void rotateColors(int interval) {
        //Interval is time between colors in milliseconds
        

    }

    public void flash(Color flashColor) {
        prevColor = currentColor;
        setRGB(flashColor, true, true);
    }

}

class Color {
    double red, green, blue;

    public Color() {
        red = 1.0;
        green = 1.0;
        blue = 1.0;
    }

    public Color(int red, int green, int blue) {
        this.red = red / 255.0;
        this.green = green / 255.0;
        this.blue = blue / 255.0;
    }

    public double getRed() {
        return red;
    }

    public double getGreen() {
        return green;
    }

    public double getBlue() {
        return blue;
    }

}