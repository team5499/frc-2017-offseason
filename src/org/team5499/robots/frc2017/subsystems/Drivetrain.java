package org.team5499.robots.frc2017.subsystems;

import com.ctre.MotorControl.CANTalon;
import org.team5499.robots.frc2017.Reference;

public class Drivetrain {
    
    private CANTalon left1, left2, right1, right2;

    public Drivetrain() {
        left1 = new CANTalon(Reference.LEFT1_PORT);
        left2 = new CANTalon(Reference.LEFT2_PORT);
        right1 = new CANTalon(Reference.RIGHT1_PORT);
        right2 = new CANTalon(Reference.RIGHT2_PORT);
        right1.setInverted(true);
        right2.setInverted(true);
    }

    /**
     * Sets drivetrain motor speeds
     * @param left sets values of left side motors
     * @param right sets values of the right side motors
     */
    public void drive(double left, double right) {
        left1.set(left);
        left2.set(left);
        right1.set(right);
        right2.set(right);
    }

    /**
     * Stops drivetrain
     * @see drive()
     */
    public void stop() {
        drive(0, 0);
    }
};