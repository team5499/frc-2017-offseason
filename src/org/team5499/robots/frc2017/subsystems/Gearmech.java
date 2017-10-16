package org.team5499.robots.frc2017.subsystems;

import com.ctre.MotorControl.CANTalon;
import org.team5499.robots.frc2017.Reference;

public class Gearmech {

    private CANTalon arm, roller;

    public Gearmech() {
        arm = new CANTalon(Reference.arm_port);
        roller = new CANTalon(Reference.roller_port);
    }

    public void setArm(double a) {
         arm.set(a);
    }

    public void setRoller(double r) {
        roller.set(r);
    }

}