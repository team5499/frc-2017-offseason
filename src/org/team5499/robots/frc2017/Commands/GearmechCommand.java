package org.team5499.robots.frc2017.commands;

import org.team5499.robots.frc2017.Reference;
import org.team5499.robots.frc2017.commands.GenericCommand;
import org.team5499.robots.frc2017.subsystems.Subsystems;

public class GearmechCommand extends GenericCommand {

    private Direction dir;

    public enum Direction{
        UP,
        DOWN,
        NONE
    }

    public GearmechCommand(double to, Direction dir) {
        super(to);
        this.dir = dir;
    }

    @Override
    public void start() {
        super.start();
    }

    public void handle() {
        switch(dir) {
            case UP:
                Subsystems.gearmech.setArm(0.5);
                break;
            case DOWN:
                Subsystems.gearmech.setArm(-0.5);
                break;
            case NONE:
                Subsystems.gearmech.setArm(0);
                break;
            default:
                break;
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