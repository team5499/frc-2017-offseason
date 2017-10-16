package org.team5499.robots.frc2017.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import org.team5499.robots.frc2017.Reference;

public class Encoders {

    private Encoder rightEncoder, leftEncoder;


    public Encoders() {
        rightEncoder = new Encoder(Reference.rightEncoder_port1, Reference.rightEncoder_port2, true);
        leftEncoder = new Encoder(Reference.leftEncoder_port1, Reference.leftEncoder_port2);
        rightEncoder.setDistancePerPulse(Reference.distance_per_pulse);
        leftEncoder.setDistancePerPulse(Reference.distance_per_pulse);
    }

    public double getLeftDistance() {
        return leftEncoder.getDistance();
    }
    
    public double getRightDistance() {
        return rightEncoder.getDistance();
    }

    public void reset() {
        rightEncoder.reset();
        leftEncoder.reset();
    }
}