package org.team5499.robots.frc2017.commands;

import org.team5499.robots.frc2017.commands.GenericCommand;
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
        Subsystems.anglePID.setSetpoint(setPoint);
    }

    public void handle() {
        Subsystems.anglePID.setInput(Subsystems.angle.getAngle());
        Subsystems.anglePID.calculate();
        double driveOutput = Subsystems.anglePID.getOutput();
        
        System.out.println("Actual:" + driveOutput);

        if(Math.abs(driveOutput) > 0.4) {
            driveOutput = (driveOutput < 0)?-0.4:0.4;
        }

        System.out.println("Error:" + Subsystems.anglePID.getError() + " Output:" + driveOutput);

        Subsystems.drivetrain.drive(-driveOutput, driveOutput);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }

    @Override
    public void reset() {
        
    }


}