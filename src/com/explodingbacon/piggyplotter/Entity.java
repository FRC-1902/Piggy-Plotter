package com.explodingbacon.piggyplotter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Entity {
    
    public double x;
    public double y;
    public double width;
    public double height;
    public Color color = null;
    public boolean fill = true;
    
    public Entity(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public Entity(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    
     public Entity(double x, double y, double width, double height, Color color, boolean fill) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.fill = fill;
    }
    
    public void draw(Graphics2D g) {
        Color oldColor = g.getColor();
        if (color != null) g.setColor(color);
        if (fill) {
            g.fillRect((int) Main.scaleUp(x),(int) Main.scaleUp(y),(int) Main.scaleUp(width), (int) Main.scaleUp(height));
            g.setColor(oldColor);
        }
        g.drawRect((int) Main.scaleUp(x),(int) Main.scaleUp(y),(int) Main.scaleUp(width), (int) Main.scaleUp(height));
        g.setColor(oldColor);
    }
    
    public Rectangle getRect() {
        return new Rectangle(Main.scaleUp(x), Main.scaleUp(y), Main.scaleUp(width), Main.scaleUp(height));
    }
    
    public void mouseEnter() {}
    
    public void mouseLeave() {}
    
    public boolean clicked() {
        return false;
    }
}
