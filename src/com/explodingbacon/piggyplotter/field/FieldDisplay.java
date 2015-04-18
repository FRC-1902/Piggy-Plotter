package com.explodingbacon.piggyplotter.field;

import com.explodingbacon.piggyplotter.Entity;
import com.explodingbacon.piggyplotter.Main;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class FieldDisplay extends Entity {
    
    public Field f;
    
    public FieldDisplay(Field f, int x, int y) {
        super(x, y, 64, 64);
        this.f = f;
    }
    
    @Override
    public Rectangle getRect() {
        return new Rectangle(Main.scaleUp(x), Main.scaleUp(y), f.image.getWidth(null), f.image.getHeight(null));
    }
    
    @Override
    public void draw(Graphics2D g) {
        g.drawImage(f.image, Main.scaleUp(x), Main.scaleUp(y), null);
    }
}
