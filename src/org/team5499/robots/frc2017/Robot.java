package org.team5499.robots.frc2017;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team5499.robots.frc2017.controllers.AutoController;
import org.team5499.robots.frc2017.controllers.OperatorController;
import org.team5499.robots.frc2017.subsystems.Subsystems;

public class Robot extends IterativeRobot {

    private OperatorController operatorController;
    private AutoController autoController; 

    public Robot() {
        /*
         This is called before anything else to make sure the PID
         variables are initialized before the PID subsystems are initialized
        */
        Reference.initPIDVariables();

        operatorController = new OperatorController();
        autoController = new AutoController();
    }


    @Override
    public void robotInit() {
        // Reset the encoder position to 0
        Subsystems.encoders.reset();
        // Set the LEDs to white
        //Subsystems.led.setRGB(Subsystems.led.white, true, true);
        // Resets position
        Subsystems.position.reset();
    }

    @Override
    public void robotPeriodic() {
        // Integrate the angle the entire time the robot is running
        Subsystems.angle.handle(Subsystems.encoders.getLeftDistance(), Subsystems.encoders.getRightDistance());
        // Handle the state of the LEDs
        //Subsystems.led.handle();
        System.out.println("X: " + Subsystems.position.getXPosition() + ", Y: " + Subsystems.position.getYPosition());
        //System.out.println("Auto mode:" + SmartDashboard.getNumber("automode", 0));
    }

    @Override
	public void disabledInit() {
        // Update the PID variables when the robot is disabled
        Reference.initPIDVariables();
        Subsystems.leftPID.setPID(Reference.kP, Reference.kI, Reference.kD);
        Subsystems.rightPID.setPID(Reference.kP, Reference.kI, Reference.kD);
        Subsystems.anglePID.setPID(Reference.kAP, Reference.kAI, Reference.kAD);
        // Reset the coders to 0 when the robot is disabled
        Subsystems.encoders.reset();
        // Reset the angle when the robot is disabled
        Subsystems.angle.reset();
        //Reset the position when robot is disabled
        Subsystems.position.reset();
        // Reset the autocontroller when the robot is disabled
        // This means the robot code doesn't need to be restarted everytime auto is run
        autoController.reset();
        //SmartDashboard.putBoolean("reset_graph", true);
        SmartDashboard.putBoolean("time_running", false);
    }
    
	@Override
	public void disabledPeriodic() {
        //Subsystems.led.rotateColors(1000);
        //autoController.checkAuto();
        if(Subsystems.inputs.autoSelector()) autoController.incrementRoutine();
        //Reference.updatePIDVariables();
    }

    @Override
    public void autonomousInit() {
        SmartDashboard.putBoolean("reset_graph", false);
        Reference.initPIDVariables();
        Subsystems.leftPID.setPID(Reference.kP, Reference.kI, Reference.kD);
        Subsystems.rightPID.setPID(Reference.kP, Reference.kI, Reference.kD);
        Subsystems.anglePID.setPID(Reference.kAP, Reference.kAI, Reference.kAD);
        Subsystems.encoders.reset();
        Subsystems.angle.reset();
        //Subsystems.led.setRGB(Subsystems.led.off, true, true);
        autoController.Start();
    }

    @Override
    public void autonomousPeriodic() {
        autoController.Handle();
        Subsystems.position.Handle(Subsystems.encoders.getLeftDistance(),
            Subsystems.encoders.getRightDistance(),
            Subsystems.angle.getAngle());
    }

    @Override
    public void teleopInit() {
        //Subsystems.led.setRGB(Subsystems.led.off, true, true);
        operatorController.Start();
        // Let the smart dashboard know that teleop has begun
        SmartDashboard.putBoolean("time_running", true);
    }

    @Override
    public void teleopPeriodic() {
        operatorController.Handle();
        Subsystems.position.Handle(Subsystems.encoders.getLeftDistance(),
            Subsystems.encoders.getRightDistance(),
            Subsystems.angle.getAngle());
        
    }
}
