package org.team5499.robots.frc2017;

import edu.wpi.first.wpilibj.IterativeRobot;
import org.team5499.robots.frc2017.controllers.*;
import org.team5499.robots.frc2017.subsystems.*;

public class Robot extends IterativeRobot {

    private OperatorController operatorController;
    private AutoController autoController; 

    public Robot() {
        operatorController = new OperatorController();
        autoController = new AutoController();
    }


    @Override
    public void robotInit() {
        Subsystems.led.setRGB(Subsystems.led.white, true, true);
    }

    @Override
    public void robotPeriodic() {

    }

    @Override
	public void disabledInit() {
        Subsystems.encoders.reset();
    }
    
	@Override
	public void disabledPeriodic() {
        Subsystems.led.rotateColors(400);
    }

    @Override
    public void autonomousInit() {
        autoController.Start();
    }

    @Override
    public void autonomousPeriodic() {
        autoController.Handle();
    }

    @Override
    public void teleopInit() {
        Subsystems.led.setRGB(Subsystems.led.white, true, true);
        operatorController.Start();
    }

    @Override
    public void teleopPeriodic() {
        operatorController.Handle();
    }
}
