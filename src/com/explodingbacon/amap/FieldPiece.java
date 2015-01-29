package com.explodingbacon.amap;

import java.awt.Color;
import java.awt.Graphics2D;

public class FieldPiece {
    
    public double x = 0;
    public double y = 0;
    public double width = 0;
    public double height = 0;
    public Color color = null;
    public boolean fill = true;
    public String display ;
    
    public FieldPiece(double x, double y, double width, double height, Color color, String display) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.display = display;
        Board.pieces.add(this);
    }
    
    public FieldPiece(double x, double y, double width, double height, Color color, boolean fill, String display) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.fill = fill;
        this.display = display;
        Board.pieces.add(this);
    }
    
    public void draw(Graphics2D g) {
        Color oldColor = g.getColor();
        g.setColor(color);
        if (fill) {
            g.fillRect((int) Math.round(x * Main.multiplier),(int) Math.round(y * Main.multiplier),(int) Math.round(width * Main.multiplier), (int) Math.round(height * Main.multiplier));
            g.setColor(oldColor);
        }
        g.drawRect((int) Math.round(x * Main.multiplier),(int) Math.round(y * Main.multiplier),(int) Math.round(width * Main.multiplier), (int) Math.round(height * Main.multiplier));
        g.setColor(oldColor);
    }
}
