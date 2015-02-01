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
        
        double xDiff2 = endX - startX;
        double yDiff2 = endY - startY;
        double xDiff1 = 0;
        double yDiff1 = 0;
        for (Command c : Board.robot.commands) {
            for (String[] array : c.data) {
                if (array[0].equals("drive")) {
                    DriveCommand d = (DriveCommand) c;
                    xDiff1 = d.endX - d.startX;
                    yDiff1 = d.endY - d.startY;
                }
            }
        }
        if (xDiff1 == 0 && yDiff1 == 0) {
            xDiff1 = 0;
            yDiff1 = Board.robot.y - (Board.robot.y + Board.robot.height);
        }
        double xDiffDiff = xDiff2 - xDiff1;
        double yDiffDiff = yDiff2 - yDiff1;
        System.out.println("xDiff1: " + xDiff1 + ", yDiff1: " + yDiff1);
        System.out.println("xDiff2: " + xDiff2 + ", yDiff2: " + yDiff2);
        System.out.println("xDiffDiff: " + xDiffDiff + ", yDiffDiff: " + yDiffDiff);
        double theta1 = Math.atan(yDiff1 / xDiff1);
        double theta2 = Math.atan(yDiff2 / xDiff2);
        System.out.println("Theta1: " + theta1 + ", Theta2: " + theta2);
        int quadrant = 0;
        if (Main.sign(xDiffDiff) == 1 && Main.sign(yDiffDiff) == 1) {
            quadrant = 1;
        } else if (Main.sign(xDiffDiff) == -1 && Main.sign(yDiffDiff) == 1) {
            quadrant = 2;
        } else if (Main.sign(xDiffDiff) == -1 && Main.sign(yDiffDiff) == -1) {
            quadrant = 3;
        } else if (Main.sign(xDiffDiff) == 1 && Main.sign(yDiffDiff) == -1) {
            quadrant = 4;
        }
        double angleDiff = 0;     
        if(quadrant == 1) {
            if (theta2 < theta1) {
                angleDiff = theta1 - theta2;
            } else if (theta2 > theta1) {
                angleDiff = theta2 - theta1;
            }
        } else if (quadrant == 2) {
            angleDiff = Math.PI - theta1 - theta2;
        } else if (quadrant == 3) {
            angleDiff = Math.PI - theta1 + theta2;
        } else if (quadrant == 4) {
            angleDiff = theta1 + theta2;
        } else if (quadrant == 0) {
            System.out.println("We're in quadrant 0. That's a problem.");
        }
        
        angleDiff *= 57.2957795; //Convert from radians to degrees
        System.out.println("angleDiff is " + angleDiff + ", robot angle is " + Board.robot.angle + ", quadrant is " + quadrant + ".");
        Board.robot.angle += angleDiff;
        //System.out.println("Made a command to turn " + Board.robot.angle + " degrees. We're in quadrant " + quadrant + ", by the way.");
        data.add(new String[]{"turn", Board.robot.angle + ""});
        
        double inchDistance = Math.sqrt(((endY - startY) * (endY - startY)) + ((endX - startX) * (endX - startX)));
        double distance = inchDistance / (Math.PI * 4) * 1024;
        //System.out.println("Made a command to drive " + distance + " clicks to get to " + inchDistance + " inches.");
        data.add(new String[]{"drive", distance + "", distance + "", Board.robot.angle + ""});       
    }
}
