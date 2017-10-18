package org.team5499.robots.frc2017.controllers;

import org.team5499.robots.frc2017.subsystems.Gearmech;
import org.team5499.robots.frc2017.subsystems.Subsystems;
import org.team5499.robots.frc2017.Commands.*;


public class AutoController {

    private Routine center, left, right, test;
    private Routine currRoutine;
    private int autoChoice;

    public AutoController() {

        // Center auto 
        center.addCommand(new DriveCommand(4,80));
        center.addCommand(new GearmechCommand(1, GearmechCommand.Direction.DOWN));
        center.addCommand(new DriveCommand(2, -40));

        // Left auto

        // Right auto

        autoChoice = 0;
    }

    public void Start() {
        System.out.println("Auto Controller started");

        switch(autoChoice) {

        }
    }


    public void Handle() {

    }
    
}