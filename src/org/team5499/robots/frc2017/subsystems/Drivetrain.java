package org.team5499.robots.frc2017.subsystems;

import com.ctre.MotorControl.CANTalon;
import org.team5499.robots.frc2017.Reference;

public class Drivetrain {
    
    private CANTalon left1, left2, right1, right2;

    public Drivetrain() {
        left1 = new CANTalon(Reference.left1_port);
        left2 = new CANTalon(Reference.left2_port);
        right1 = new CANTalon(Reference.right1_port);
        right2 = new CANTalon(Reference.right2_port);
        right1.setInverted(true);
        right2.setInverted(true);
    }

    public void drive(double left, double right) {
        left1.set(left);
        left2.set(left);
        right1.set(right);
        right2.set(right);
    }

    public void stop() {
        drive(0, 0);
    }
};