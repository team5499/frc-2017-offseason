package org.team5499.robots.frc2017.Commands;

import java.util.ArrayList;

public class Routine {
    
    private ArrayList<GenericCommand> commands = new ArrayList<>();

    public Routine() {

    }

    public void addCommand(GenericCommand command) {
        commands.add(command);
    }

}