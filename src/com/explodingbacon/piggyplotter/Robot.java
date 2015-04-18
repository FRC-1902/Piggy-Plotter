package com.explodingbacon.piggyplotter;

import java.util.ArrayList;
import java.util.List;

public class Robot extends FieldPiece {
    
    public List<CommandGroup> commandGroups = new ArrayList<>();
    public double startingAngle = 0;
    public double angle = 0;
    
    public Robot(double x, double y, double width, double height) {
        super(x, y, width, height, Main.baconOrange, "Robot");
    }
    
    @Override
    public boolean clicked() {
        new RobotConfig(this).setVisible(true);
        return true;
    }
    
    public DriveCommand getLastDrive() {
        DriveCommand last = null;
        for (CommandGroup cg : commandGroups) {
            for (Command c : cg.commands) {
                if (c instanceof DriveCommand) last = (DriveCommand) c;
            }
        }
        return last;
    }
}
