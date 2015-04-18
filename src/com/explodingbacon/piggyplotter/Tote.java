package com.explodingbacon.piggyplotter;

import java.awt.Color;

public class Tote extends FieldPiece {
    
    public static double w = 26.9;
    public static double h = 16.9;
    public boolean rotate = false;
    
    public Tote(double x, double y, Color color) {
        super(x, y, w, h, color, "Mystery Tote");
        if (similar(color, Color.YELLOW) || similar(color, new Color(255, 255, 0))) {
            display = "Yellow Tote";
        } else {
            display = "Gray Tote";
        }
    } 
    
    public Tote(double x, double y, Color color, boolean rotate) {
        super(x, y, rotate ? h : w, rotate ? w : h, color, "Mystery Tote");
        this.rotate = rotate;
        if (similar(color, Color.YELLOW) || similar(color, new Color(255, 255, 0))) {
            display = "Yellow Tote";
        } else {
            display = "Gray Tote";
        }
    }
    
    public boolean similar(Color c1, Color c2) {
        return (c1.getRed() == c2.getRed() && c1.getGreen() == c2.getGreen() && c1.getBlue() == c2.getBlue());
    }
}
