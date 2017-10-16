package org.team5499.robots.frc2017.controllers;

import org.team5499.robots.frc2017.subsystems.Subsystems;

public class OperatorController {

    public OperatorController() {
        Subsystems.led.setRGB(Subsystems.led.white, true, true);
    }

    public void Start() {
        System.out.println("Operator Controller started");
    }


    public void Handle() {
        Subsystems.drivetrain.drive(Subsystems.inputs.getLeftStick() * Subsystems.inputs.isSlow(), Subsystems.inputs.getRightStick() * Subsystems.inputs.isSlow());
        Subsystems.climber.setClimb(Subsystems.inputs.getClimb());
        Subsystems.gearmech.setArm(Subsystems.inputs.getArm());
        Subsystems.gearmech.setRoller(Subsystems.inputs.getRoller());
    }



}