package org.team5499.robots.frc2017.subsystems;

import org.team5499.robots.frc2017.Reference;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Angle {
    
    private double angle, lastLeftDistance, lastRightDistance;

    public Angle() {
        angle = 0;
        lastLeftDistance = 0;
        lastRightDistance = 0;
    }

    public void handle(double leftValue, double rightValue) {
        double leftDistance = (leftValue - lastLeftDistance);
        double rightDistance = (rightValue - lastRightDistance);
        double difference = leftDistance - rightDistance;
        double angleDelta = (180*difference) /(Reference.CENTER_WHEEL_DIST_INCHES * Reference.PI);
        angle+=angleDelta;
        lastLeftDistance = leftValue;
        lastRightDistance = rightValue;

        SmartDashboard.putNumber("angle", angle);
    }

    public double getAngle() {
        return angle;
    }

    public void resetLastDistances() {
        lastLeftDistance = 0;
        lastRightDistance = 0;
    }

    public void reset() {
        System.out.println("reset");
        angle = 0;
        resetLastDistances();
    }

}