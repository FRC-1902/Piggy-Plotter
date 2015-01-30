package com.explodingbacon.amap;

import java.awt.Color;

public class Tote extends FieldPiece {
    
    public static double w = 26.9;
    public static double h = 16.9;
    public boolean rotate = false;
    
    public Tote(double x, double y, Color color) {
        super(x, y, w, h, color, color == Color.YELLOW ? "Yellow Tote" : "Gray Tote");
    } 
    
    public Tote(double x, double y, Color color, boolean rotate) {
        super(x, y, rotate ? h : w, rotate ? w : h, color, color == Color.YELLOW ? "Yellow Tote" : "Gray Tote");
        this.rotate = rotate;
    }    
}
