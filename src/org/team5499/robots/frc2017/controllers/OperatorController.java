package org.team5499.robots.frc2017.controllers;

import org.team5499.robots.frc2017.subsystems.Subsystems;

public class OperatorController {


    public OperatorController() {
    }

    public void Start() {
        System.out.println("Operator Controller started");
    }

    /**
     * 
     */

    public void Handle() {
        Subsystems.drivetrain.drive(Subsystems.inputs.getLeftStick()  * Subsystems.inputs.isSlow(), Subsystems.inputs.getRightStick() * Subsystems.inputs.isSlow());
        Subsystems.climber.setClimb(Subsystems.inputs.getClimb());
        Subsystems.gearmech.setArm(Subsystems.inputs.getArm());
        Subsystems.gearmech.setRoller(Subsystems.inputs.getRoller());
        //System.out.println(Subsystems.accel.getX());
        // if(accel.getY() > 0.5) Subsystems.led.rotateColors(400);

        // if(Subsystems.gearmech.detectGear()) Subsystems.led.flash(Subsystems.led.white);

    }
}