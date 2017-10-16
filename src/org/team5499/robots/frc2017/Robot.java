package org.team5499.robots.frc2017;

import com.ctre.MotorControl.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import org.team5499.robots.frc2017.controllers.*;

public class Robot extends IterativeRobot{

    private OperatorController operatorController;
    private AutoController autoController; 

    @Override
    public void robotInit() {
        System.out.println("Hello, World!!!");
    }
    @Override
    public void robotPeriodic() {
    }

    @Override
	public void disabledInit() {
    }
    
	@Override
	public void disabledPeriodic() {
    }

    @Override
    public void autonomousInit() {
    }

    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
        operatorController.Start();
    }
    @Override
    public void teleopPeriodic() {
        operatorController.Handle();
    }
}
