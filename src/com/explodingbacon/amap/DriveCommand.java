package com.explodingbacon.amap;

import java.awt.geom.Line2D;

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
      
        Line2D line1;
        Line2D line2 = new Line2D.Double(startX, startY, endX, endY);
        DriveCommand last = Board.robot.getLastDrive();
        if (last != null) {
            line1 = new Line2D.Double(last.startX, last.startY, last.endX, last.endY);
        } else {
            line1 = new Line2D.Double(0, Board.robot.y + Board.robot.height, 0, Board.robot.y);
        }           
        double angle = angle(line1, line2);
        angle *= 57.2957795; //Convert from radians to degrees
        System.out.println("Turn Angle: " + angle + " degrees.");
        //Board.robot.angle += angle;
        data.add(new String[]{"turn", angle + ""});
      
        double inchDistance = Math.sqrt((endY - startY) * (endY - startY) + (endX - startX) * (endX - startX));
        inchDistance = Main.scaleDown(inchDistance);
        double distance = inchDistance / (Math.PI * 4) * 1024; //Convert from inches to encoder clicks
        System.out.println("Drive Distance : " + inchDistance + " inches.");
        data.add(new String[]{"drive", distance + "", distance + ""});       
    }
    
    public static double angle(Line2D line1, Line2D line2) {
        double angle1 = Math.atan2(line1.getY1() - line1.getY2(), line1.getX1() - line1.getX2());
        double angle2 = Math.atan2(line2.getY1() - line2.getY2(), line2.getX1() - line2.getX2());
        return Math.abs(angle1) - Math.abs(angle2);
    }
}
