package org.team5499.robots.frc2017.commands_timed;

import org.team5499.robots.frc2017.commands.GenericCommand;
import org.team5499.robots.frc2017.subsystems.Subsystems;
import edu.wpi.first.wpilibj.Timer;

public class TimedDriveCommand extends GenericCommand {

    private double duration;
    private double speed;
    private double startTime;

    public TimedDriveCommand(double to, double dur, double speed) {
        super(to);
        duration = dur;
        this.speed = speed;
    }

    @Override
    public void start() {
        super.start();
        startTime = Timer.getFPGATimestamp();
        Subsystems.drivetrain.drive(speed, speed * 0.98); // worked at 0.960
    }

    public void handle() {
        if(Timer.getFPGATimestamp() - startTime >= duration){
            Subsystems.drivetrain.stop();
        }
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }

    @Override
    public void reset() {

    }

}