package org.team5499.robots.frc2017.subsystems;

import com.ctre.MotorControl.CANTalon;
import org.team5499.robots.frc2017.Reference;

public class Climber {
    private CANTalon climb1, climb2;

    public Climber() {
        climb1 = new CANTalon(Reference.climb1_port);
        climb2 = new CANTalon(Reference.climb2_port);
    }

    public void setClimb(double c) {
        climb1.set(c);
        climb2.set(c);
    }

    public void stop() {
        setClimb(0);
    }

}