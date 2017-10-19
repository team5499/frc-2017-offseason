package org.team5499.robots.frc2017.controllers;

import org.team5499.robots.frc2017.subsystems.Gearmech;
import org.team5499.robots.frc2017.subsystems.Subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.team5499.robots.frc2017.Commands.DriveCommand;
import org.team5499.robots.frc2017.Commands.GearmechCommand;
import org.team5499.robots.frc2017.Commands.DoNothingCommand;
import org.team5499.robots.frc2017.Commands.TurnCommand;
import org.team5499.robots.frc2017.Commands.Routine;


public class AutoController {

    private Routine center, left, right, test;
    private Routine currRoutine;
    private int autoChoice;

    public AutoController() {

        center = new Routine();
        left = new Routine();
        right = new Routine();
        test = new Routine();
        //enter auto
        center.addCommand(new DriveCommand(4,80));
        center.addCommand(new GearmechCommand(1, GearmechCommand.Direction.DOWN));
        center.addCommand(new DriveCommand(2, -40));
        center.addCommand(new GearmechCommand(1, GearmechCommand.Direction.NONE));

        // Left auto
        left.addCommand(new DriveCommand(4, 60));
        left.addCommand(new TurnCommand(6, 45));
        left.addCommand(new DoNothingCommand(2));

        // Right auto
        right.addCommand(new DoNothingCommand(2));

        // Test
        test.addCommand(new DoNothingCommand(2));

        autoChoice = 0;
    }

    public void Start() {
        System.out.println("Auto Controller started");
        SmartDashboard.getNumber("automode", 0);
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