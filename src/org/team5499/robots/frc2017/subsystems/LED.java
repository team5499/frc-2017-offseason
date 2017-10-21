package org.team5499.robots.frc2017.subsystems;

import org.team5499.robots.frc2017.Reference;
import edu.wpi.first.wpilibj.DigitalOutput;
import java.util.ArrayList;
import edu.wpi.first.wpilibj.Timer;

public class LED {
    // private Timer timer;

    private Color currentColor;
    private Color prevColor;
    private DigitalOutput redController, greenController, blueController;

    public ArrayList<Color> colorSequence = new ArrayList<>();
    public int sequenceIndex = -1;

    public Color red, green, blue, white, off;
    private int flashSequence;;

    double startTime;
    double current_time_millis;
    double last_time_millis;
    

    public LED() {
        // timer.start();
        redController = new DigitalOutput(Reference.RED_PORT);
        greenController = new DigitalOutput(Reference.GREEN_PORT);
        blueController = new DigitalOutput(Reference.BLUE_PORT);

        redController.enablePWM(0);
        redController.setPWMRate(100);
        greenController.enablePWM(0);
        greenController.setPWMRate(100);
        blueController.enablePWM(0);
        blueController.setPWMRate(100);

        red = new Color(255, 0, 0);
        green = new Color(0, 255, 0);
        blue = new Color(0, 0, 255);
        white = new Color(255, 255, 255);
        off = new Color(0, 0, 0);
        sequenceIndex = 0;
        flashSequence = -1;

        current_time_millis = 0;
        last_time_millis = 0;
        
        colorSequence.add(red);
        colorSequence.add(green);
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
        current_time_millis = Timer.getFPGATimestamp() * 1000;
        
        if(current_time_millis % interval <= 50 && current_time_millis % interval >= 0) {
            sequenceIndex = (sequenceIndex <= colorSequence.size() ? sequenceIndex += 1 : 0);
            currentColor = colorSequence.get(sequenceIndex);
            setRGB(currentColor, true, true);
        }
    }

    public void handle() {
        if(flashSequence != -1) {
            if(Timer.getFPGATimestamp() - startTime > 0.3) {
                flashSequence++;
                startTime = Timer.getFPGATimestamp();
            }
            if(flashSequence % 2 == 0) {
                setRGB(currentColor, true, false);
            } else {
                setRGB(off, true, false);
            }
            if(flashSequence > 4) {
                flashSequence = -1;
                setRGB(off, true, true);
            }
        }
    }

    public void flash(Color flashColor) {
        prevColor = currentColor;
        setRGB(flashColor, false, true);
        flashSequence = 0;
        startTime = Timer.getFPGATimestamp();
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