package org.team5499.robots.frc2017.subsystems;

import org.team5499.robots.frc2017.Reference;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;

public class Inputs {

    public XboxController driver, codriver;
    Joystick wheel, stick;


    public Inputs() {
        driver = new XboxController(Reference.driver_port);
        codriver = new XboxController(Reference.codriver_port);
        wheel = new Joystick(Reference.wheel_port);
        stick = new Joystick(Reference.joystick_port);
    }
    
    public double getLeftStick() {
        System.out.println(driver.getY(Hand.kLeft));
        return driver.getY(Hand.kLeft);
    }

    public double getRightStick() {
        return driver.getY(Hand.kRight);
    }

    public double isSlow() {
        return (driver.getTrigger(Hand.kRight) ? Reference.slowMult // Kinda Slow
        : driver.getTrigger(Hand.kLeft) ? Reference.slowMult / 2 // Really Slow
        : 1.0); // Normal Speed / Not Slow
    }

    public double getClimb() {
         double a = 0.0;
         a = (codriver.getAButton()) ? -Reference.climbSpeed
         : codriver.getBButton() ? Reference.climbSpeed 
         : 0.0;
         return a;
    }

    public double getArm() {
        return codriver.getY(Hand.kLeft) * Reference.armMult;
    }

    public double getRoller() {
        return (codriver.getBumper(Hand.kLeft) ? Reference.rollerSpeed 
        : codriver.getBumper(Hand.kRight) ? -Reference.rollerSpeed 
        : 0.0);
    }
}