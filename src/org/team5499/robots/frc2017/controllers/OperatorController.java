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
        Subsystems.led.setRGB(Subsystems.led.off, true, true);
        if(Subsystems.accel.getY() > 1.0) Subsystems.led.rotateColors(400);
        if(Subsystems.gearmech.detectGear()) Subsystems.led.flash(Subsystems.led.white);
    }

    public void changeControlMethod(ControlMethod method) {
        currentControlMethod = method;
    }
}