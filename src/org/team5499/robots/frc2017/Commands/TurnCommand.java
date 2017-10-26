package org.team5499.robots.frc2017.commands;

import org.team5499.robots.frc2017.commands.GenericCommand;
import org.team5499.robots.frc2017.Reference;
import org.team5499.robots.frc2017.subsystems.*;

public class TurnCommand extends GenericCommand {

    private double setPoint;

    public TurnCommand(double to, double sp) {
        super(to);
        setPoint = sp;
    }

    @Override
    public void start() {
        super.start();
        Subsystems.anglePID.setPID(Reference.kAP, Reference.kAI, Reference.kAD);
        Subsystems.anglePID.setSetpoint(setPoint);
    }

    public void handle() {
        Subsystems.leftPID.setSetpoint(-(Subsystems.encoders.getRightDistance()-Subsystems.leftPID.getSetpoint()));
        Subsystems.rightPID.setSetpoint(-(Subsystems.encoders.getLeftDistance()-Subsystems.rightPID.getSetpoint()));

        Subsystems.anglePID.setInput(Subsystems.angle.getAngle());
        Subsystems.leftPID.setInput(Subsystems.encoders.getLeftDistance());
        Subsystems.rightPID.setInput(Subsystems.encoders.getRightDistance());

        Subsystems.anglePID.calculate();
        Subsystems.leftPID.calculate();
        Subsystems.rightPID.calculate();
        double driveOutput = Subsystems.anglePID.getOutput();
        
        System.out.println("Actual:" + driveOutput);

        if(Math.abs(driveOutput) > 0.2) {
            driveOutput = (driveOutput < 0)?-0.2:0.2;
        }

        System.out.println("Error:" + Subsystems.anglePID.getError() + " Output:" + driveOutput);

        Subsystems.drivetrain.drive(-driveOutput+Subsystems.leftPID.getOutput(), driveOutput+Subsystems.rightPID.getOutput());
    }

    @Override
    public boolean isFinished() {
        if(super.isFinished()) {
            Subsystems.anglePID.setPID(Reference.kATP, Reference.kATI, Reference.kATD);
            Subsystems.encoders.reset();
            Subsystems.angle.resetLastDistances();
            Subsystems.leftPID.reset();
            Subsystems.rightPID.reset();
        }
        return super.isFinished();
    }

    @Override
    public void reset() {
        
    }


}