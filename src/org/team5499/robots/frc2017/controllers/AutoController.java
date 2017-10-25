package org.team5499.robots.frc2017.controllers;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team5499.robots.frc2017.subsystems.Subsystems;
import org.team5499.robots.frc2017.commands.DriveCommand;
import org.team5499.robots.frc2017.commands.GearmechCommand;
import org.team5499.robots.frc2017.commands.DoNothingCommand;
import org.team5499.robots.frc2017.commands.TurnCommand;
import org.team5499.robots.frc2017.commands.Routine;
import org.team5499.robots.frc2017.commands_timed.TimedDriveCommand;
import org.team5499.robots.frc2017.commands_timed.TimedTurnCommand;
import org.team5499.robots.frc2017.commands_timed.TimedTurnCommand.Direction;


public class AutoController {

    private Routine center, left, right, test;
    private Routine timedCenter, timedLeft, timedRight, timedBaseline;
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
        timedLeft = new Routine();
        timedRight = new Routine();
        timedBaseline = new Routine();

        // center auto
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

        // Timed Center Auto
        timedCenter.addCommand(new TimedDriveCommand(3, 1.65, -0.3));
        timedCenter.addCommand(new GearmechCommand(0.5, GearmechCommand.Direction.DOWN));
        timedCenter.addCommand(new TimedDriveCommand(1, 2, 0.3));
        timedCenter.addCommand(new GearmechCommand(0.1, GearmechCommand.Direction.NONE));
        timedCenter.addCommand(new GearmechCommand(0.6, GearmechCommand.Direction.UP));
        timedCenter.addCommand(new GearmechCommand(0.1, GearmechCommand.Direction.NONE));

        // Timed Right Auto
        timedRight.addCommand(new TimedDriveCommand(3, 1.65, -0.3));
        timedRight.addCommand(new TimedTurnCommand(2, 1, Direction.LEFT));
        timedRight.addCommand(new TimedDriveCommand(2, 1.2, -0.3));
        timedRight.addCommand(new GearmechCommand(0.5, GearmechCommand.Direction.DOWN));
        timedRight.addCommand(new TimedDriveCommand(1.5, 1.5, 0.3));
        timedRight.addCommand(new GearmechCommand(0.1, GearmechCommand.Direction.NONE));
        timedRight.addCommand(new GearmechCommand(0.6, GearmechCommand.Direction.UP));
        timedRight.addCommand(new GearmechCommand(0.1, GearmechCommand.Direction.NONE));

        // Timed Left Auto
        timedLeft.addCommand(new TimedDriveCommand(3, 1.65, -0.3));
        timedLeft.addCommand(new TimedTurnCommand(2, 1, Direction.RIGHT));
        timedLeft.addCommand(new TimedDriveCommand(2, 1.2, -0.3));
        timedLeft.addCommand(new GearmechCommand(0.5, GearmechCommand.Direction.DOWN));
        timedLeft.addCommand(new TimedDriveCommand(1.5, 1.5, 0.3));
        timedLeft.addCommand(new GearmechCommand(0.1, GearmechCommand.Direction.NONE));
        timedLeft.addCommand(new GearmechCommand(0.6, GearmechCommand.Direction.UP));
        timedLeft.addCommand(new GearmechCommand(0.1, GearmechCommand.Direction.NONE));

        // Timed Center Baseline
        timedBaseline.addCommand(new TimedDriveCommand(1, 10, -0.3));

        autoChoice = 0;
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
            case 4: 
                currRoutine = timedCenter;
                System.out.println("Timed Center Auto selected");
                break;
            case 5:
                currRoutine = timedBaseline;
                System.out.println("Timed Baseline Auto Selected");
                break;
            case 6:
                currRoutine = timedRight;
                System.out.println("Timed Right Atuo selected");
                break;
            case 7:
                currRoutine = timedLeft;
                System.out.println("Timed Left Auto selected");
                break;
            default:
                System.err.println("ERROR: Auto selected not found");
                break;
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