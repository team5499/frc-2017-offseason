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
        Subsystems.drivetrain.drive(-Subsystems.anglePID.getOutput(), Subsystems.anglePID.getOutput());
    }

    @Override
    public boolean isFinished() {
        super.isFinished();
        System.out.println(Subsystems.anglePID.getRate());
        if(Subsystems.anglePID.getError() < 1 && Subsystems.anglePID.getRate() < 0.2)
            return true;
        return false;
    }

    @Override
    public void reset() {
        
    }


}