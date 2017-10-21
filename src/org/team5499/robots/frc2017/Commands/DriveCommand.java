package org.team5499.robots.frc2017.commands;

import org.team5499.robots.frc2017.Reference;
import org.team5499.robots.frc2017.commands.GenericCommand;
import org.team5499.robots.frc2017.subsystems.Subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveCommand extends GenericCommand {
    private double m_setpoint, m_start_time;

    public DriveCommand(double timeout, double setPoint){
        super(timeout);
        m_setpoint = setPoint;
    }


    @Override
    public void start() {
        super.start();
        Subsystems.leftPID.setSetpoint(m_setpoint);
        Subsystems.rightPID.setSetpoint(m_setpoint);
        Subsystems.anglePID.setSetpoint(0);
        m_start_time = Timer.getFPGATimestamp();
    }

    @Override
    public void handle() {
        Subsystems.rightPID.setInput(Subsystems.encoders.getRightDistance());
        Subsystems.leftPID.setInput(Subsystems.encoders.getLeftDistance());
        Subsystems.anglePID.setInput(Subsystems.angle.getAngle());

        Subsystems.rightPID.calculate();
        Subsystems.leftPID.calculate();
        Subsystems.anglePID.calculate();

        double leftDrive = Subsystems.leftPID.getOutput();
        double rightDrive = Subsystems.rightPID.getOutput();

        System.out.println(leftDrive + ":" + rightDrive);

        if(Math.abs(leftDrive) > Reference.MAX_AUTO_SPEED)
            leftDrive = (leftDrive>0) ? Reference.MAX_AUTO_SPEED : -Reference.MAX_AUTO_SPEED;

        if(Math.abs(rightDrive) > Reference.MAX_AUTO_SPEED)
            rightDrive = (rightDrive>0) ? Reference.MAX_AUTO_SPEED : -Reference.MAX_AUTO_SPEED;

        System.out.println("Angle Output:" + Subsystems.anglePID.getOutput() + " Angle:" + Subsystems.angle.getAngle());

        Subsystems.drivetrain.drive(-Subsystems.anglePID.getOutput(), Subsystems.anglePID.getOutput());

        updateSmartDash();
    }


    @Override
    public boolean isFinished() {
        return super.isFinished();
    }

    public void updateSmartDash() {
        SmartDashboard.putNumber("auto/curr_time", Timer.getFPGATimestamp() - m_start_time);
        SmartDashboard.putNumber("auto/left_error", Subsystems.leftPID.getError());
        SmartDashboard.putNumber("auto/right_error", Subsystems.rightPID.getError());
        SmartDashboard.putNumber("auto/angle_error", Subsystems.anglePID.getError());
    }

    @Override
    public void reset() {

    }

}