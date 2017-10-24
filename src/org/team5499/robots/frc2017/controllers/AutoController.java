package org.team5499.robots.frc2017.controllers;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team5499.robots.frc2017.commands.DriveCommand;
import org.team5499.robots.frc2017.commands.GearmechCommand;
import org.team5499.robots.frc2017.commands.DoNothingCommand;
import org.team5499.robots.frc2017.commands.TurnCommand;
import org.team5499.robots.frc2017.commands.Routine;
import org.team5499.robots.frc2017.commands.GenericCommand;
import org.team5499.robots.frc2017.commands_timed.TimedDriveCommand;


public class AutoController {

    private Routine center, left, right, test;
    private Routine timedCenter, timedBaseline;
    private Routine currRoutine;
    private int autoChoice;

    public AutoController() {

        // PID routines
        center = new Routine();
        left = new Routine();
        right = new Routine();
        test = new Routine();

        // Timed Routines
        timedCenter = new Routine();
        timedBaseline = new Routine();

        // center auto
        center.addCommand(new DriveCommand(5,80));
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

        // Timed Center Auto
        timedCenter.addCommand(new TimedDriveCommand(5, 2, 0.2));
        timedCenter.addCommand(new GearmechCommand(2, GearmechCommand.Direction.DOWN));
        timedCenter.addCommand(new TimedDriveCommand(5, 2, -0.2));

        // Timed Center Baseline
        timedBaseline.addCommand(new TimedDriveCommand(10, 10, 0.4));

        autoChoice = 4;
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
            case 4: 
                currRoutine = timedCenter;
                System.out.println("Timed Center Auto selected");
                break;
            case 5:
                currRoutine = timedBaseline;
                System.out.println("Timed Baseline Auto Selected");
                break;
            default:
                System.err.println("ERROR: Auto selected not found");

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