package org.team5499.robots.frc2017.subsystems;

import org.team5499.robots.frc2017.Reference;

public class Angle {
    
    private double angle, last_left_distance, last_right_distance;

    public Angle() {
        angle = 0;
        last_left_distance = 0;
        last_right_distance = 0;
    }

    public void Handle(double leftValue, double rightValue) {
        double left_dist = (leftValue - last_left_distance);
        double right_dist = (rightValue - last_right_distance);
        double difference = left_dist - right_dist;
        double angleDelta = (180*difference) /(Reference.center_wheel_dist_inches * Reference.PI);
        angle+=angleDelta;
        last_left_distance = leftValue;
        last_right_distance = rightValue;
    }

    public double getAngle() {
        return angle;
    }

    public void resetLastDistances() {
        last_left_distance = 0;
        last_right_distance = 0;
    }

    public void reset() {
        angle = 0;
        resetLastDistances();
    }

}