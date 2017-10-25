package org.team5499.robots.frc2017.commands_timed;

import org.team5499.robots.frc2017.commands.GenericCommand;
import org.team5499.robots.frc2017.subsystems.Subsystems;

import edu.wpi.first.wpilibj.Timer;

public class TimedTurnCommand extends GenericCommand {

    private double duration;
    private double startTime;
    private Direction direction;

    private final double turnSpeed = 0.2;

    public enum Direction {
        LEFT,
        RIGHT
    }

    public TimedTurnCommand(double to, double dur, Direction dir) {
        super(to);
        duration = dur;
        direction = dir;
    }

    @Override
    public void start() {
        super.start();
        startTime = Timer.getFPGATimestamp();
        switch(direction) {
            case LEFT:
                Subsystems.drivetrain.drive(turnSpeed, -turnSpeed);
                break;
            case RIGHT:
                Subsystems.drivetrain.drive(-turnSpeed, turnSpeed);
                break;
            default:
                System.err.println("ERROR: Unrecognized direction!");
                break;
        }
    }

    @Override
    public void handle() {
        if(Timer.getFPGATimestamp() - startTime >= duration) Subsystems.drivetrain.stop();
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }

    @Override
    public void reset() {

    }

}