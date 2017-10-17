package org.team5499.robots.frc2017.subsystems;

import org.team5499.robots.frc2017.subsystems.*;
import org.team5499.robots.frc2017.Reference;

public class Subsystems {

    public static Drivetrain drivetrain;
    public static Climber climber;
    public static Gearmech gearmech;
    public static Inputs inputs;
    public static Encoders encoders;
    public static LED led;
    public static PID leftPID;
    public static PID rightPID;
    public static PID anglePID;
    public static Angle angle;


    public Subsystems() {
        drivetrain = new Drivetrain();
        climber = new Climber();
        gearmech = new Gearmech();
        inputs = new Inputs();
        encoders = new Encoders();
        led = new LED();
        leftPID = new PID(0, 0, 0, 1);
        rightPID = new PID(0, 0, 0, 1);
        anglePID = new PID(0, 0, 0, 1);
        angle = new Angle();
    }
}