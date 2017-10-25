package org.team5499.robots.frc2017.subsystems;

import org.team5499.robots.frc2017.Reference;
import org.team5499.robots.frc2017.subsystems.Subsystems;

public class Position {

    // Coordinates of the robot
    private double xPosition = 0;
    private double zPosition = 0;

    private double last_distance = 0;

    public Position() {}

    public void handle() {
        double angle = Subsystems.angle.getAngle(); 

    }

    public void reset() {
        xPosition = 0;
        zPosition = 0;
    }
}