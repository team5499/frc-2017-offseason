package org.team5499.robots.frc2017.subsystems;

import org.team5499.robots.frc2017.Reference;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;

public class Inputs {

    public XboxController driver, codriver;
    public Joystick wheel, throttle;


    /**
     * Gets values from driver and codriver controllers during teleop period.
     */
    public Inputs() {
        driver = new XboxController(Reference.DRIVER_PORT);
        codriver = new XboxController(Reference.CODRIVER_PORT);
        wheel = new Joystick(Reference.WHEEL_PORT);
        throttle = new Joystick(Reference.JOYSTICK_PORT);
    }
    
    /**
     * The value used for the wheels on the left side of the robot
     * @return Base left side speed
     */
    public double getLeftStick() {
        System.out.println(driver.getY(Hand.kLeft));
        return driver.getY(Hand.kLeft);
    }

    /**
     * The value used for the wheels on the right side of the robot
     * @return Base right side speed
     */
    public double getRightStick() {
        return driver.getY(Hand.kRight);
    }

    /**
     * Returns a multiplier used to slow the robot when needed by the driver. 
     * @return Multiplier for the wheel speed
     */
    public double isSlow() {
        return (driver.getTrigger(Hand.kRight) ? Reference.SLOW_MULTIPLIER // Kinda Slow
        : driver.getTrigger(Hand.kLeft) ? Reference.SLOW_MULTIPLIER / 2 // Really Slow
        : 1.0); // Normal Speed / Not Slow
    }

    /**
     * Returns speed for climber from A and B buttons of codriver controller.
     * @return Climber speed
     */
    public double getClimb() {
         double a = 0.0;
         a = (codriver.getAButton()) ? -Reference.CLIMB_SPEED
         : codriver.getBButton() ? Reference.CLIMB_SPEED
         : 0.0;
         return a;
    }

    /**
     * Gets speed for arm from codriver's left stick and multiplies it by a constant.
     * @return Speed for the arm
     */
    public double getArm() {
        return codriver.getY(Hand.kLeft) * Reference.ARM_MULTIPLIER;
    }

    /**
     * Gets speed for roller from codriver's bumpers.
     * @return speed for roller
     */
    public double getRoller() {
        return (codriver.getBumper(Hand.kLeft) ? Reference.ROLLER_SPEED
        : codriver.getBumper(Hand.kRight) ? -Reference.ROLLER_SPEED
        : 0.0);
    }

    /** 
     * Gets wheel rotation from driver's wheel
     * @return Wheel rotation
     */
    public double getWheel() {
        return wheel.getRawAxis(0);
    }

    /**
     * Gets throttle value from driver's joystick.
     * @return Throttle value
     */
    public double getThrottle() {
        return throttle.getRawAxis(1);
    }

    /**
     * Limits speed of robot based on button press on driver's joystick.
     * @return Multiplier for speed
     * @see getThrottle
     */
    public double throttleLimiter() {
        return (throttle.getRawButton(1) ? 0.2 : 1.0);
    }

    /**
     * Increases turn speed on press of the right paddle on driver's wheel.
     * @return Multiplier for turning speed
     * @see getWheel()
     */

    public double wheelLimiter() {
        if(!wheel.getRawButton(8)) {
            return (getThrottle() > 0 ? 0.4 : 0.25);
            
        } else return 1;
    }
}