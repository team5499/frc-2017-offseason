package org.team5499.robots.frc2017.commands;

import org.team5499.robots.frc2017.commands.GenericCommand;
import org.team5499.robots.frc2017.Reference;
import org.team5499.robots.frc2017.subsystems.*;

public class TurnCommand extends GenericCommand {

    private double setPoint;
    private double initLeftValue;
    private double initRightValue;

    public TurnCommand(double to, double sp) {
        super(to);
        setPoint = sp;
    }

    @Override
    public void start() {
        super.start();
        Subsystems.anglePID.setPID(Reference.kAP, Reference.kAI, Reference.kAD);
        Subsystems.anglePID.setSetpoint(setPoint);

        initLeftValue = Subsystems.encoders.getLeftDistance();
        initRightValue = Subsystems.encoders.getRightDistance();
    }

    public void handle() {
        // (Turn left)positive if right distance is greater than left distance
        // (Turn right)positive if left distance is greater than right distance
        double offset = (Subsystems.encoders.getLeftDistance()-initLeftValue)+(Subsystems.encoders.getRightDistance()-initRightValue);

        Subsystems.leftPID.setSetpoint((Subsystems.encoders.getLeftDistance()-initLeftValue)-(offset/2));
        Subsystems.rightPID.setSetpoint((Subsystems.encoders.getRightDistance()-initRightValue)-(offset/2));

        Subsystems.leftPID.setInput(Subsystems.encoders.getLeftDistance());
        Subsystems.rightPID.setInput(Subsystems.encoders.getRightDistance());

        Subsystems.leftPID.calculate();
        Subsystems.rightPID.calculate();

        Subsystems.anglePID.setInput(Subsystems.angle.getAngle());

        Subsystems.anglePID.calculate();
        double driveOutput = Subsystems.anglePID.getOutput();
        
        //System.out.println("Actual:" + driveOutput);
        if(Math.abs(driveOutput) > 0.2) {
            driveOutput = (driveOutput < 0)?-0.2:0.2;
        }

        Subsystems.drivetrain.drive(-driveOutput-Subsystems.leftPID.getOutput(), driveOutput-Subsystems.rightPID.getOutput());
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