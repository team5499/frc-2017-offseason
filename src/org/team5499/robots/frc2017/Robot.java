package org.team5499.robots.frc2017;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
        Reference.initPIDVariables();
    }

    @Override
    public void robotPeriodic() {
        Subsystems.angle.Handle(Subsystems.encoders.getLeftDistance(), Subsystems.encoders.getRightDistance());
        // Subsystems.led.handle();
    }

    @Override
	public void disabledInit() {
        Reference.initPIDVariables();
        Subsystems.leftPID.setPID(Reference.kP, Reference.kI, Reference.kD);
        Subsystems.rightPID.setPID(Reference.kP, Reference.kI, Reference.kD);
        Subsystems.anglePID.setPID(Reference.kAP, Reference.kAI, Reference.kAD);
        Subsystems.encoders.reset();
        Subsystems.angle.reset();
        autoController.reset();
    }
    
	@Override
	public void disabledPeriodic() {
        Reference.initPIDVariables();
        Subsystems.leftPID.setPID(Reference.kP, Reference.kI, Reference.kD);
        Subsystems.rightPID.setPID(Reference.kP, Reference.kI, Reference.kD);
        Subsystems.anglePID.setPID(Reference.kAP, Reference.kAI, Reference.kAD);
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
        SmartDashboard.putBoolean("time_running", true);
    }

    @Override
    public void teleopPeriodic() {
        operatorController.Handle();
    }
}
