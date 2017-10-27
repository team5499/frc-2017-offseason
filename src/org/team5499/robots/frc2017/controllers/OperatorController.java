package org.team5499.robots.frc2017.controllers;

import org.team5499.robots.frc2017.subsystems.Subsystems;

public class OperatorController {

    public static enum ControlMethod {
        CONTROLLER,
        WHEEL
    }
    private static ControlMethod currentControlMethod;

    public OperatorController() {
        currentControlMethod = ControlMethod.CONTROLLER;
    }

    public void Start() {
        System.out.println("Operator Controller started");
    }

    public void Handle() {
        
        switch(currentControlMethod) {
            case CONTROLLER: 
                Subsystems.drivetrain.drive(Subsystems.inputs.getLeftStick()  * Subsystems.inputs.isSlow(), Subsystems.inputs.getRightStick() * Subsystems.inputs.isSlow());
                break;
            case WHEEL:
                double driveVal = Subsystems.inputs.getThrottle() * Subsystems.inputs.throttleLimiter();
                double turnVal = Subsystems.inputs.getWheel() * Subsystems.inputs.wheelLimiter();
                Subsystems.drivetrain.drive(driveVal - turnVal, driveVal + turnVal);
                break;
            default:
                System.err.println("ERROR: Invalid driver control method");
                break;
        }
        
        Subsystems.climber.setClimb(Subsystems.inputs.getClimb());
        Subsystems.gearmech.setArm(Subsystems.inputs.getArm());
        Subsystems.gearmech.setRoller(Subsystems.inputs.getRoller());
        System.out.println("Z axis: " + Subsystems.accel.getZ());
        
        if(Subsystems.gearmech.detectGear()) Subsystems.led.flash(Subsystems.led.white);
        if(Subsystems.inputs.getClimb() > 0.5 || Subsystems.inputs.getClimb() < -0.5) Subsystems.led.rotateColors(200);
        else Subsystems.led.setRGB(Subsystems.led.off, true, true);
    }

    public void changeControlMethod(ControlMethod method) {
        currentControlMethod = method;
    }
}