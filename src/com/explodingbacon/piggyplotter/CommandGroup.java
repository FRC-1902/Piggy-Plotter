package com.explodingbacon.piggyplotter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class CommandGroup extends Entity {
    
    public String name = "Command Group";
    public List<Command> commands = new ArrayList<>();
    public boolean visible = true;
    
    public CommandGroup(double x, double y) {
        super(x, y, 16, 16, Color.LIGHT_GRAY);
        this.x = x;
        this.y = y;
    }
    
    public CommandGroup(boolean visible) {
        super(0, 0, 0, 0, Color.LIGHT_GRAY);
    }
    
    @Override
    public boolean clicked() {
        if (visible) {
            new CommandGroupConfig(this).setVisible(true);
            return true;
        }
        return false;
    }
    
    @Override
    public Rectangle getRect() {
        Rectangle rect = new Rectangle(-1, -1, 0, 0);
        if (visible) {
            x -= (width / 2);
            y -= (height / 2);
            rect = super.getRect();
            x += (width / 2);
            y += (height / 2);
        }
        return rect;
    }
    
    @Override
    public void draw(Graphics2D g) {
        if (visible) {
            x -= (width / 2);
            y -= (height / 2);
            super.draw(g);
            int textWidth = g.getFontMetrics().stringWidth(name);
            g.drawString(name, Main.scaleUp(x + (width / 2) - (textWidth / 4) ), Main.scaleUp(y - (height / 2)));
            x += (width / 2);
            y += (height / 2);
        }
    }
}
