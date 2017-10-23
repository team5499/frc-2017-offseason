package org.team5499.robots.frc2017.subsystems;

import org.team5499.robots.frc2017.subsystems.*;
import org.team5499.robots.frc2017.Reference;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;

public class Subsystems {
    public static Drivetrain drivetrain = new Drivetrain();
    public static Climber climber = new Climber();
    public static Gearmech gearmech = new Gearmech();
    public static Inputs inputs = new Inputs();
    public static Encoders encoders = new Encoders();
    public static LED led = new LED();
    public static PID leftPID = new PID(Reference.kP, Reference.kI, Reference.kD, 1); 
    public static PID rightPID = new PID(Reference.kP, Reference.kI, Reference.kD, 1);
    public static PID anglePID = new PID(Reference.kAP, Reference.kAI, Reference.kAD, 1);
    public static Angle angle = new Angle();
    public static Position position = new Position();
    public static BuiltInAccelerometer accel = new BuiltInAccelerometer();
}