package org.team5499.robots.frc2017.subsystems;

import com.ctre.MotorControl.CANTalon;
import edu.wpi.first.wpilibj.Timer;
import org.team5499.robots.frc2017.Reference;

public class Gearmech {

    private CANTalon arm, roller;
    private boolean last;
    Timer timer;

    public Gearmech() {
        timer = new Timer();
        arm = new CANTalon(Reference.ARM_PORT);
        roller = new CANTalon(Reference.ROLLER_PORT);
        arm.setInverted(true);
        arm.setVoltageRampRate(10);
        roller.setInverted(true);
        last = false;
    }

    public void setArm(double a) {
         arm.set(a);
    }

    public void setRoller(double r) {
        roller.set(r);
    }

    public boolean detectGear() {
        if(roller.get() != 0) {
            if(roller.getOutputCurrent() > 43) {
                System.out.println("Amperage Ratio: " + roller.getOutputCurrent());
                if(last) {
                    System.out.println(timer.get());
                    return(timer.get() > 0.1);
                } else {
                    last = true;
                    timer.start();
                }
            } else {
                last = false;
                timer.reset();
            }
        }
        return false;
    }
    public void stop() {
        setArm(0);
        setRoller(0);
    }

}