package org.team5499.robots.frc2017;

public class Reference {

    // Talon Ports
    public static final int left1_port = 1;
    public static final int left2_port = 2;
    public static final int right1_port = 3;
    public static final int right2_port = 4;

    public static final int climb1_port = 5;
    public static final int climb2_port = 6;

    public static final int arm_port = 7;
    public static final int roller_port = 8;

    // Encoder Ports
    public static final int rightEncoder_port1 = 0;
    public static final int rightEncoder_port2 = 1;
    public static final int leftEncoder_port1 = 2;
    public static final int leftEncoder_port2 = 3;

    // Digital Output ports
    public static final int red_port = 4;
    public static final int green_port = 5;
    public static final int blue_port = 6;

    // Input Ports
    public static final int driver_port = 0;
    public static final int codriver_port = 1;
    public static final int wheel_port = 2;
    public static final int joystick_port = 3;

    // variables 
    public static final double armMult = 0.5;
    public static final double rollerSpeed = 0.9;
    public static final double climbSpeed = 0.99;
    public static final double slowMult = 0.3;
    public static final double maxAutoSpeed = 0.4;

    // Constants
    public static final double PI = 3.1414926;
    public static final double distance_per_pulse = (PI * 4.0) / 256.0;
    public static final double center_wheel_dist_inches = 25.0;

    // PID constants
    public static double kP = 0.04;
    public static double kI = 0.0;
    public static double kD = 0.01;
    public static double kAP = 0.035;
    public static double kAI = 0.0;
    public static double kAD = 0.0;

    public static void initPIDVariables() {
        // Need to find a Json parser
    }



}