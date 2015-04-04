package com.explodingbacon.piggyplotter;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class DriveCommand extends Command {
    
    public double endX;
    public double endY;
    public double inchDistance;
    public double angle;
    
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
            line1 = new Line2D.Double(0, Board.robot.y + (Board.robot.height / 2), 0, Board.robot.y + (Board.robot.height / 2) - 1);
        }           
        angle = Util.angle(line1, line2);
        angle *= 57.2957795; //Convert from radians to degrees
        boolean firstTurn = false;
        if (Board.robot.commandGroups.isEmpty()) {
            firstTurn = true;
        } else {
            for (CommandGroup cg : Board.robot.commandGroups) {
                boolean foundTurn = false;
                for (Command c : cg.commands) {
                    if (c instanceof DriveCommand) {
                        foundTurn = true;
                        break;
                    }
                }
                if (!foundTurn) {
                    firstTurn = true;
                }
            }
        }
        if (firstTurn) {
            angle -= Board.robot.angle;
            Board.robot.angle = 0;
        }
        
        Board.robot.angle += angle;
        //System.out.println("Turn Angle: " + angle + " degrees (robot angle should be " + Board.robot.angle + ")");
        data.add(new String[]{"turn", Board.robot.angle + ""});
      
        inchDistance = Math.sqrt((endY - startY) * (endY - startY) + (endX - startX) * (endX - startX));
        inchDistance = Main.scaleDown(inchDistance);
        //double distance = inchDistance / (Math.PI * 4) * 1024; //Convert from inches to encoder clicks
        //System.out.println("Drive Distance : " + inchDistance + " inches.");
        data.add(new String[]{"drive", inchDistance + "", inchDistance + ""}); 
    }
    
    @Override
    public void draw(Graphics2D g) {
        g.drawLine(Main.scaleUp(x), Main.scaleUp(y), Main.scaleUp(endX), Main.scaleUp(endY));
    }
    
    @Override
    public boolean clicked() {
        return false;
    }   
}
