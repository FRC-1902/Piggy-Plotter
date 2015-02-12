package com.explodingbacon.amap;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Robot extends FieldPiece {
    
    public List<Command> commands = new ArrayList<>();
    public double angle = 0;
    
    public Robot(double x, double y, double width, double height) {
        super(x, y, width, height, Color.BLACK, "Robot");
    }
    
    @Override
    public boolean clicked() {
        new RobotConfig(this).setVisible(true);
        return true;
    }
    
    public DriveCommand getLastDrive() {
        DriveCommand last = null;
        for (Command c : commands) {
            if (c instanceof DriveCommand) last = (DriveCommand) c;
        }
        return last;
    }
}
