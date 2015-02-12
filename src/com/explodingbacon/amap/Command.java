package com.explodingbacon.amap;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Command extends Entity {
    
    public List<String[]> data = new ArrayList<>();

    public Command(double x, double y) {
        super(x, y, 0, 0, Color.PINK);
    }

    public Command(double x, double y, String[] data) {
        super(x, y, 0, 0, Color.PINK);
        this.data.add(data);
    }
    
    @Override
    public void draw(Graphics2D g) {}
    
    public String dataToString() {
        String stringData = "";
        for (String[] array : data) {
            for (String s : array) {
                stringData = stringData + s + " ";
            }
        }
        return stringData;
    }
}
