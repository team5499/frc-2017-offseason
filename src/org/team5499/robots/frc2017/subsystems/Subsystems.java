package org.team5499.robots.frc2017.subsystems;

import org.team5499.robots.frc2017.subsystems.*;
import org.team5499.robots.frc2017.Reference;

public class Subsystems {

    public static Drivetrain drivetrain = new Drivetrain();
    public static Climber climber = new Climber();
    public static Gearmech gearmech = new Gearmech();
    public static Inputs inputs = new Inputs();
    public static Encoders encoders = new Encoders();
    //public static LED led = new LED();
    // public static PIDController leftPID, rightPID, anglePID;
    public static PID leftPID = new PID(Reference.kP, Reference.kI, Reference.kD, 1), rightPID = new PID(Reference.kP, Reference.kI, Reference.kD, 1), anglePID = new PID(Reference.kAP, Reference.kAI, Reference.kAD, 1);
    public static Angle angle = new Angle();

    public Subsystems() {
        /*
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
        */
    }
}