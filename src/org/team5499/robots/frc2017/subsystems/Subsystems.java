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
    // public static PIDController leftPID, rightPID, anglePID;
    public static PID leftPID, rightPID, anglePID;
    public static Angle angle;

    public Subsystems() {
        drivetrain = new Drivetrain();
        climber = new Climber();
        gearmech = new Gearmech();
        inputs = new Inputs();
        encoders = new Encoders();
        led = new LED();
        angle = new Angle();
        leftPID = new PID(Reference.kP, Reference.kI, Reference.kD, 1);
        rightPID = new PID(Reference.kP, Reference.kI, Reference.kD, 1);
        anglePID = new PID(Reference.kAP, Reference.kAI, Reference.kAD, 1);

    }
}