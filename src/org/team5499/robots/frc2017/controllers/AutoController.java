package org.team5499.robots.frc2017.controllers;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team5499.robots.frc2017.subsystems.Subsystems;
import org.team5499.robots.frc2017.commands.DriveCommand;
import org.team5499.robots.frc2017.commands.GearmechCommand;
import org.team5499.robots.frc2017.commands.DoNothingCommand;
import org.team5499.robots.frc2017.commands.TurnCommand;
import org.team5499.robots.frc2017.commands.Routine;


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
        center.addCommand(new DriveCommand(3,80));
        center.addCommand(new GearmechCommand(1, GearmechCommand.Direction.DOWN));
        center.addCommand(new DriveCommand(2, -40));
        center.addCommand(new GearmechCommand(1, GearmechCommand.Direction.UP));
        center.addCommand(new GearmechCommand(1, GearmechCommand.Direction.NONE));

        // Left auto
        left.addCommand(new TurnCommand(6, 60));

        // Right auto
        right.addCommand(new DoNothingCommand(2));

        // Test
        test.addCommand(new DoNothingCommand(2));

        autoChoice = 1;
        SmartDashboard.putNumber("automode", autoChoice);
    }

    public void Start() {
        System.out.println("Auto Controller started");
        autoChoice = (int) SmartDashboard.getNumber("automode", 1);
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
                System.err.println("ERROR: Auto selected not found");

        }

        currRoutine.start();
    }


    public void Handle() {
        currRoutine.handle();
    }

    public void reset() {
        Subsystems.climber.stop();
        Subsystems.gearmech.stop();
        Subsystems.drivetrain.stop();

        left.reset();
        center.reset();
        right.reset();
        test.reset();
    }
    
}