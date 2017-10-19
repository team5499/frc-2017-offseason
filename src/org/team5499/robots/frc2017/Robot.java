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
        Subsystems.encoders.reset();
        //Subsystems.led.setRGB(Subsystems.led.white, true, true);
    }

    @Override
    public void robotPeriodic() {
        Subsystems.angle.Handle(Subsystems.encoders.getLeftDistance(), Subsystems.encoders.getRightDistance());
        // Subsystems.led.handle();
    }

    @Override
	public void disabledInit() {
        Subsystems.encoders.reset();
        Subsystems.angle.reset();
        autoController.reset();
    }
    
	@Override
	public void disabledPeriodic() {
        //Subsystems.led.rotateColors(400);
        Subsystems.encoders.reset();
        Subsystems.angle.reset();
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
        //Subsystems.led.setRGB(Subsystems.led.white, true, true);
        operatorController.Start();
    }

    @Override
    public void teleopPeriodic() {
        operatorController.Handle();
    }
}
