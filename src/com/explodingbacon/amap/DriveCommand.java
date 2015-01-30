package com.explodingbacon.amap;

public class DriveCommand extends Command {
    
    public double startX;
    public double startY;
    public double endX;
    public double endY;
    
    public DriveCommand(double startX, double startY, double endX, double endY) {        
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        //TODO Do encoder math to make the encoder values
    }
}
