package org.team5499.robots.frc2017.commands;

import org.team5499.robots.frc2017.subsystems.Subsystems;
import org.team5499.robots.frc2017.Reference;

import edu.wpi.first.wpilibj.Timer;

public class GenericCommand {

    private double m_timeout;
    private double m_start_time;

    public GenericCommand(double to) {
        m_timeout = to;
    }

    public void handle() {

    }

    public void start() {
        m_start_time = Timer.getFPGATimestamp();
    }

    public boolean isFinished() {
        return (m_timeout < Timer.getFPGATimestamp() - m_start_time);
    }


    public void reset() {
        
    }
    

}