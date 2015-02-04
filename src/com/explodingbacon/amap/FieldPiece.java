package com.explodingbacon.amap;

import java.awt.Color;

public class FieldPiece extends Entity {
    
    public String display;
    
    public FieldPiece(double x, double y, double width, double height, Color color, String display) {
        super(x, y, width, height, color);
        this.display = display;
    }
    
    public FieldPiece(double x, double y, double width, double height, Color color, boolean fill, String display) {
        super(x, y, width, height, color, fill);
        this.display = display;
    }
}
