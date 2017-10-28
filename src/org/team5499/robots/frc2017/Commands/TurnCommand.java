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

        Subsystems.anglePID.setInput(Subsystems.angle.getAngle());

        Subsystems.anglePID.calculate();
        double driveOutput = Subsystems.anglePID.getOutput();
        
        //System.out.println("Actual:" + driveOutput);

        if(Math.abs(driveOutput) > 0.35) {
            driveOutput = (driveOutput < 0)?-0.35:0.35;
        }

        Subsystems.drivetrain.drive(-driveOutput, driveOutput);
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