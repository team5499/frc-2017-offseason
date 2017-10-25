package org.team5499.robots.frc2017.controllers;

import org.team5499.robots.frc2017.subsystems.Subsystems;

public class OperatorController {

    private static final int driverControlMethod = 1; // 0 is xbox, 1 is wheel

    public OperatorController() {
    }

    public void Start() {
        System.out.println("Operator Controller started");
    }

    public void Handle() {
        
        switch(driverControlMethod) {
            case(0): 
                Subsystems.drivetrain.drive(Subsystems.inputs.getLeftStick()  * Subsystems.inputs.isSlow(), Subsystems.inputs.getRightStick() * Subsystems.inputs.isSlow());
                break;
            case(1):
                double driveVal = Subsystems.inputs.getThrottle() * Subsystems.inputs.throttleLimiter();
                double turnVal = Subsystems.inputs.getWheel() * Subsystems.inputs.wheelLimiter();
                Subsystems.drivetrain.drive(driveVal - turnVal, driveVal + turnVal);
                break;
            default:
                System.err.println("ERROR: Invalid driver control method (" + driverControlMethod + ")");
                break;
        }
        
        Subsystems.climber.setClimb(Subsystems.inputs.getClimb());
        Subsystems.gearmech.setArm(Subsystems.inputs.getArm());
        Subsystems.gearmech.setRoller(Subsystems.inputs.getRoller());
        Subsystems.led.setRGB(Subsystems.led.off, true, true);
        if(Subsystems.accel.getY() > 1.0) Subsystems.led.rotateColors(500);
        if(Subsystems.gearmech.detectGear()) Subsystems.led.flash(Subsystems.led.white);
    }
}