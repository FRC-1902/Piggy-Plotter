package com.explodingbacon.amap;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Robot extends FieldPiece {
    
    public List<Command> commands = new ArrayList<>();
    public double angle = 0; //Set the starting angle to the initial heading
    
    public Robot(double x, double y, double width, double height) {
        super(x, y, width, height, Color.BLACK, null);
    }
    
    @Override
    public boolean clicked() {
        new RobotConfig(this).setVisible(true);
        return true;
    }
}
