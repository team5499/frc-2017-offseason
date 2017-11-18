package org.team5499.robots.frc2017.subsystems;

import org.team5499.robots.frc2017.Reference;
import org.team5499.robots.frc2017.subsystems.Subsystems;

public class Position {

    // Coordinates of the robot
    private double xPosition = 0;
    private double yPosition = 0;

    private double lastTimeLeft = 0;
    private double lastTimeRight = 0;
    private double lastTimeAngle = 0;

    public Position() {}

    public void Handle(double leftVal, double rightVal, double angle) {
        // System.out.println(leftVal + ":" + rightVal + ":" + angle);
        double deltaK = angle - lastTimeAngle;
        double leftDelta = leftVal - lastTimeLeft;
        double rightDelta =  rightVal - lastTimeRight;
        // System.out.println(leftDelta + ":" + rightDelta + ":" + deltaK);
        double a = (rightDelta - leftDelta) / 2.0;
        // System.out.println("A:" + a);
        
        double r = 0;
        if(deltaK != 0) {
            r = a / deltaK;
        }
        // r = a / deltaK;

        double deltaX = r * Math.cos(lastTimeAngle - r);
        double deltaY = r * Math.sin(lastTimeAngle);
        double aX = deltaX * Math.cos(lastTimeAngle) + deltaY * Math.sin(lastTimeAngle);
        double aY = deltaY * Math.cos(lastTimeAngle) - deltaX * Math.sin(lastTimeAngle);
        xPosition += aX;
        yPosition += aY;
        lastTimeLeft = leftVal;
        lastTimeRight = rightVal;
        lastTimeAngle = angle;
    }

    public void reset() {
        xPosition = 0;
        yPosition = 0;
        lastTimeAngle = 0;
        lastTimeRight = 0;
        lastTimeLeft = 0;
    }

    public double getXPosition() {
        return xPosition;
    }

    public double getYPosition() {
        return yPosition;
    }
}