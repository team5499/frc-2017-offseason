package org.team5499.robots.frc2017.subsystems;

import org.team5499.robots.frc2017.Reference;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;

public class Inputs {

    public XboxController driver, codriver;
    public Joystick wheel, throttle;


    public Inputs() {
        driver = new XboxController(Reference.DRIVER_PORT);
        codriver = new XboxController(Reference.CODRIVER_PORT);
        wheel = new Joystick(Reference.WHEEL_PORT);
        throttle = new Joystick(Reference.JOYSTICK_PORT);
    }
    
    public double getLeftStick() {
        System.out.println(driver.getY(Hand.kLeft));
        return driver.getY(Hand.kLeft);
    }

    public double getRightStick() {
        return driver.getY(Hand.kRight);
    }

    public double isSlow() {
        return (driver.getTrigger(Hand.kRight) ? Reference.SLOW_MULTIPLIER // Kinda Slow
        : driver.getTrigger(Hand.kLeft) ? Reference.SLOW_MULTIPLIER / 2 // Really Slow
        : 1.0); // Normal Speed / Not Slow
    }

    public double getClimb() {
         double a = 0.0;
         a = (codriver.getAButton()) ? -Reference.CLIMB_SPEED
         : codriver.getBButton() ? Reference.CLIMB_SPEED
         : 0.0;
         return a;
    }

    public double getArm() {
        return codriver.getY(Hand.kLeft) * Reference.ARM_MULTIPLIER;
    }

    public double getRoller() {
        return (codriver.getBumper(Hand.kLeft) ? Reference.ROLLER_SPEED
        : codriver.getBumper(Hand.kRight) ? -Reference.ROLLER_SPEED
        : 0.0);
    }

    public double getWheel() {
        return wheel.getRawAxis(0);
    }

    public double getThrottle() {
        return throttle.getRawAxis(1);
    }

    public double throttleLimiter() {
        return (throttle.getRawButton(1) ? 0.2 : 1);
    }

    public double wheelLimiter() {
        if(!wheel.getRawButton(8)) {
            return (getThrottle() > 0 ? 0.4 : 0.25);
            
        } else return 1;
    }
}