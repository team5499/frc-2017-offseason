package org.team5499.robots.frc2017.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import org.team5499.robots.frc2017.Reference;

public class Encoders {

    private Encoder rightEncoder, leftEncoder;


    public Encoders() {
        rightEncoder = new Encoder(Reference.RIGHT_ENCODER_PORT1, Reference.RIGHT_ENCODER_PORT2, false);
        leftEncoder = new Encoder(Reference.LEFT_ENCODER_PORT1, Reference.LEFT_ENCODER_PORT2, true);
        rightEncoder.setDistancePerPulse(Reference.DISTANCE_PER_PULSE);
        leftEncoder.setDistancePerPulse(Reference.DISTANCE_PER_PULSE);
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