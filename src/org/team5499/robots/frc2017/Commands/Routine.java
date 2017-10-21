package org.team5499.robots.frc2017.commands;

import java.util.ArrayList;
import org.team5499.robots.frc2017.commands.GenericCommand;
import org.team5499.robots.frc2017.subsystems.Subsystems;

public class Routine {
    
    private ArrayList<GenericCommand> commands = new ArrayList<>();
    private GenericCommand currentCommand;
    private int stepNumber ;

    public Routine() {
        stepNumber = 0;
    }

    public void addCommand(GenericCommand command) {
        commands.add(command);
        currentCommand = commands.get(0); 
    }

    public void start() {
        currentCommand.start();
    }

    public void handle() {
        if(currentCommand.isFinished()) {
            System.out.println("INFO:isFinished");
            Subsystems.drivetrain.stop();
            if(!advanceRoutine()) return;
        } else {
            currentCommand.handle();
        }
    }

    public boolean advanceRoutine() {
        if(!(stepNumber + 1 < commands.size()))
            return false;
        stepNumber++;
        currentCommand = commands.get(stepNumber);
        currentCommand.start();
        return true;
    }

    public void reset() {
        stepNumber = 0;
        Subsystems.leftPID.reset();
        Subsystems.rightPID.reset();
        Subsystems.anglePID.reset();
        for(int i = 0;i<commands.size();i++)
        {
            commands.get(i).reset();
        }
        currentCommand = commands.get(0);
    }

}