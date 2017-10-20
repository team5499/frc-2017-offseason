package org.team5499.robots.frc2017.controllers;

import org.team5499.robots.frc2017.subsystems.Subsystems;

public class OperatorController {

    private static final int driverControlMethod = 0; // 0 is controller, 1 is wheel

    public OperatorController() {
    }

    public void Start() {
        System.out.println("Operator Controller started");
    }

    /**
     * 
     */

    public void Handle() {
        switch(driverControlMethod) {
            case(0): 
                Subsystems.drivetrain.drive(Subsystems.inputs.getLeftStick()  * Subsystems.inputs.isSlow(), Subsystems.inputs.getRightStick() * Subsystems.inputs.isSlow());
                break;
            case(1):
                double driveVal = Subsystems.inputs.getThrottle() * Subsystems.inputs.throttleLimiter();
                double turnVal = Subsystems.inputs.getWheel() * Subsystems.inputs.wheelLimiter();
                Subsystems.drivetrain.drive(driveVal - turnVal, driveVal + turnVal);
        }
        
        Subsystems.climber.setClimb(Subsystems.inputs.getClimb());
        Subsystems.gearmech.setArm(Subsystems.inputs.getArm());
        Subsystems.gearmech.setRoller(Subsystems.inputs.getRoller());
        //System.out.println(Subsystems.accel.getX());
        if(Subsystems.accel.getY() > 0.2) Subsystems.led.rotateColors(400);
        if(Subsystems.gearmech.detectGear()) Subsystems.led.flash(Subsystems.led.white);
    }
}