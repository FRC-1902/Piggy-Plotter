package com.explodingbacon.amap;

public class DriveCommand extends Command {
    
    public double startX;
    public double startY;
    public double endX;
    public double endY;
    
    public DriveCommand(double startX, double startY, double endX, double endY) {        
        this.startX = startX; //gear ratio is 8.45:1, circumference 4 * PI
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        
        double angle = Math.atan((endY - startY) / (endX - startX));
        double turnRad = 15;
        double distance = (turnRad * (angle - Board.robot.angle) / (Math.PI * 4)) * 1440;     
        System.out.println("Made a command to turn " + distance + ".");
        Board.robot.angle = angle;
        data.add(new String[]{"drive", -distance + "", distance + ""});
        
        double inchDistance = Math.sqrt(((endY - startY) * (endY - startY)) + ((endX - startX) * (endX - startX)));
        distance = (inchDistance * 8.45) / (Math.PI * 4) * 1440;
        System.out.println("Made a command to drive " + distance + " clicks to get to " + inchDistance + " inches.");
        data.add(new String[]{"drive", distance + "", distance + ""});       
    }
}
