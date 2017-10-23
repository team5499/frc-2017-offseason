package org.team5499.robots.frc2017;

import com.google.gson.stream.JsonReader;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileReader;

public class Reference {

    private static final String VAR_FILE_PATH = "/home/lvuser/vars.json";
    private static JsonReader jReader;
    private static JsonParser jParser;
    private static JsonElement pTree;
    private static JsonObject jObject;

    static {
        try {
            jReader = new JsonReader(new FileReader(VAR_FILE_PATH));
        } catch(Exception e) {
            e.printStackTrace();
        }

        jParser = new JsonParser();
        pTree = jParser.parse(jReader);
        jObject = pTree.getAsJsonObject();

        initPIDVariables();
    }

    // Talon Ports
    public static final int LEFT1_PORT = 1;
    public static final int LEFT2_PORT = 2;
    public static final int RIGHT1_PORT = 3;
    public static final int RIGHT2_PORT = 4;
    public static final int ARM_PORT = 5;
    public static final int ROLLER_PORT = 6;
    public static final int CLIMBER1_PORT = 7;
    public static final int CLIMBER2_PORT = 8;

    // Encoder Ports
    public static final int RIGHT_ENCODER_PORT1 = 0;
    public static final int RIGHT_ENCODER_PORT2 = 1;
    public static final int LEFT_ENCODER_PORT1 = 2;
    public static final int LEFT_ENCODER_PORT2 = 3;

    // Digital Output ports
    public static final int RED_PORT = 4;
    public static final int GREEN_PORT = 5;
    public static final int BLUE_PORT = 6;

    // Input Ports
    public static final int CODRIVER_PORT = 0;
    public static final int DRIVER_PORT = 1;
    public static final int WHEEL_PORT = 2;
    public static final int JOYSTICK_PORT = 3;

    // variables 
    public static final double ARM_MULTIPLIER = 0.5;
    public static final double ROLLER_SPEED = 0.9;
    public static final double CLIMB_SPEED = 0.99;
    public static final double SLOW_MULTIPLIER = 0.5;
    public static final double MAX_AUTO_SPEED = 0.3;

    // Constants
    public static final double PI = Math.PI;
    public static final double DISTANCE_PER_PULSE = (PI * 4.0) / 256.0;
    public static final double CENTER_WHEEL_DIST_INCHES = 25.0;

    // PID constants
    public static double kP = 0.0;
    public static double kI = 0.0;
    public static double kD = 0.0;
    public static double kAP = 0.0;
    public static double kAI = 0.0;
    public static double kAD = 0.0;


    /**
    * Gets PID values from vars.json file
    */
    public static void initPIDVariables() {
        kP = jObject.get("kP").getAsDouble();
        kI = jObject.get("kI").getAsDouble();
        kD = jObject.get("kD").getAsDouble();

        kAP = jObject.get("kAP").getAsDouble();
        kAI = jObject.get("kAI").getAsDouble();
        kAD = jObject.get("kAD").getAsDouble();

        System.out.println("kP value:" + kP);
        System.out.println("kI value:" + kI);
        System.out.println("kD value:" + kD);

        System.out.println("kAP value:" + kAP);
        System.out.println("kAI value:" + kAI);
        System.out.println("kAD value:" + kAD);
    }
}