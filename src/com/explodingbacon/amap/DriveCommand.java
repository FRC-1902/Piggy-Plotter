package com.explodingbacon.amap;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class DriveCommand extends Command {
    
    public double endX;
    public double endY;
    
    public DriveCommand(double startX, double startY, double endX, double endY) {
        super(startX, startY);
        this.endX = endX;
        this.endY = endY;
      
        Line2D line1;
        Line2D line2 = new Line2D.Double(startX, startY, endX, endY);
        DriveCommand last = Board.robot.getLastDrive();
        if (last != null) {
            line1 = new Line2D.Double(last.x, last.y, last.endX, last.endY);
        } else {
            line1 = new Line2D.Double(0, Board.robot.y + Board.robot.height, 0, Board.robot.y + (Board.robot.height / 2));
        }           
        System.out.println("==========================");
        double angle = angle(line1, line2);
        angle *= 57.2957795; //Convert from radians to degrees
        Board.robot.angle += angle;
        System.out.println("Turn Angle: " + angle + " degrees (robot angle should be " + Board.robot.angle + ")");
        data.add(new String[]{"turn", Board.robot.angle + ""});
      
        double inchDistance = Math.sqrt((endY - startY) * (endY - startY) + (endX - startX) * (endX - startX));
        inchDistance = Main.scaleDown(inchDistance);
        double distance = inchDistance / (Math.PI * 4) * 1024; //Convert from inches to encoder clicks
        //System.out.println("Drive Distance : " + inchDistance + " inches.");
        data.add(new String[]{"drive", distance + "", distance + ""});       
    }
    
    @Override
    public void draw(Graphics2D g) {
        g.drawLine(Main.scaleUp(x), Main.scaleUp(y), Main.scaleUp(endX), Main.scaleUp(endY));
    }
    
    @Override
    public boolean clicked() {
        return false;
    }
    
    public double angle(Line2D line1, Line2D line2) {
        //double angle1 = Math.atan2(line1.getY1() - line1.getY2(), line1.getX1() - line1.getX2());
        //double angle2 = Math.atan2(line2.getY1() - line2.getY2(), line2.getX1() - line2.getX2());
        //System.out.println("Angle1: " + angle1 + ", Angle2: " + angle2);
        //double angle = Math.abs(angle1) - Math.abs(angle2);
        double xDiff1 = line1.getX2() - line1.getX1();
        double xDiff2 = line2.getX2() - line2.getX1();
        double yDiff1 = line1.getY2() - line1.getY1();
        double yDiff2 = line2.getY2() - line2.getY1();
        double angle = Math.atan2(xDiff1 * yDiff2 - yDiff1 * xDiff2, xDiff1 * xDiff2 + yDiff1 * yDiff2);
        double[] crossProduct = crossProduct(new double[]{xDiff1, yDiff1, 0}, new double[]{xDiff2, yDiff2, 0});
        if (Main.sign(crossProduct[2]) == -1) { //Turn left
            if (angle < 0) {
                angle *= -1;
            }
        } else { //Turn right
            if (angle > 0) {
                angle *= -1;
            }
        }
        return angle;
    }
    
    public double[] crossProduct(double[] v0, double[] v1) {
        double crossProduct[] = new double[3];

        crossProduct[0] = v0[1] * v1[2] - v0[2] * v1[1];
        crossProduct[1] = v0[2] * v1[0] - v0[0] * v1[2];
        crossProduct[2] = v0[0] * v1[1] - v0[1] * v1[0];

        return crossProduct;
    }
}
