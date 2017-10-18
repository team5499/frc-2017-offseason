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
        center.addCommand(new GearmechCommand(1, GearmechCommand.Direction.NONE));
        // Left auto
        

        // Right auto

        autoChoice = 0;
    }

    public void Start() {
        System.out.println("Auto Controller started");

        switch(autoChoice) {
            case 0:
                currRoutine = center;
                System.out.println("Center auto selected");
                break;
            case 1:
                currRoutine = left;
                System.out.println("Left auto selected");
                break;
            case 2:
                currRoutine = right;
                System.out.println("Right auto selected");
                break;
            case 3:
                currRoutine = test;
                System.out.println("Test auto selected");
                break;
            default:
                System.err.println("ERRORL: Auto selected not found");

        }

        currRoutine.start();
    }


    public void Handle() {
        currRoutine.handle();
    }

    public void reset() {
        left.reset();
        center.reset();
        right.reset();
        test.reset();
    }
    
}