package com.explodingbacon.piggyplotter;

import java.awt.Color;

public class RC extends FieldPiece {
    
    public static double w = 18;
    public static double h = 18;
    
    public RC(double x, double y) {
        super(x, y, w, h, new Color(16, 186, 71), "Recycling Container");
    }
}