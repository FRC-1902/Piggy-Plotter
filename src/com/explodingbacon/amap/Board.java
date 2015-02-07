package com.explodingbacon.amap;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
===THE GREAT AND MIGHTY TODO LIST===

==Necessary Features==

Add a target at the end of each drive command.
Add custom turn command support.
Move the conversion of inches to encoder ticks out of here and into the robot.
Add autonomous loading.
Change the gray command squares to command group squares with multiple commands within them.
Make objects that follow the mouse not lag behind if it moves too fast.

==When everything else is implemented==

Make the robot go through the driving and waiting segments of it's autonomous on-screen.
*/

public class Board extends JPanel implements ActionListener {
   
    public static List<Entity> entities = new ArrayList<>();
    public static Robot robot = null;
    public FieldPiece arena = null;
    public FieldPiece scoringPlatform1 = null;
    public FieldPiece scoringPlatform2 = null;
    public FieldPiece step = null;    
    public Timer timer;
    public static Board self;
    
    public Board() {
          boolean export = false;  
//          new FieldPiece(0, 0, 240, 192, Color.LIGHT_GRAY, "arena");
//          new FieldPiece(60, 192, 180, 36, Color.LIGHT_GRAY, "more_arena");
//          
//          new FieldPiece(24, 204, 6, 6, Color.YELLOW, "pole1");
//          new FieldPiece(48, 204, 6, 6, Color.YELLOW, "pole2");
//          
//          new FieldPiece(120, 216, 12, 12, Color.RED, "placement_marker");
          
//        arena = new FieldPiece(0, 0, 324, 648, Color.BLUE, null);
//        scoringPlatform1 = new FieldPiece(0, 73.25, 187, 34.25, Color.WHITE, "Scoring Platform One");
//        scoringPlatform2 = new FieldPiece(137, scoringPlatform1.y + scoringPlatform1.height + 78, 187, 34.25, Color.WHITE, "Scoring Platform Two");
//        step = new FieldPiece(0, scoringPlatform2.y + scoringPlatform2.height + 78, 324, 25, Color.WHITE, "the Step"); //The 78 here is NOT final
//        
//        //Totes mah goats
//        for (int i=0; i<5; i++) {
//            new Tote(i * Tote.w, step.y - Tote.h, Color.GRAY);
//        }
//        
//        double x = 0;
//        double y = 0;
//        for (int i=0; i<2; i++) {
//            y = step.y - Tote.h - Tote.w;
//            for (int j=0; j<2; j++) {
//                x += j !=0 ? Tote.h : 0;               
//                new Tote(x, y, Color.GRAY, true);
//            }
//            x += Tote.h;
//            for (int j=0; j<2; j++) {
//                y = step.y - (Tote.h * 2) - (j * Tote.h);
//                new Tote(x, y, Color.GRAY);
//            }
//            x += Tote.w + 0.5;
//        }
//        y = step.y - Tote.h - Tote.w;
//        new Tote(x - 0.5, y, Color.GRAY, true);
//        
//        x = arena.width - Tote.h;
//        y = 0;
//        for (int i=0; i<2; i++) {
//            y = step.y - Tote.h - Tote.w;
//            for (int j=0; j<2; j++) {
//                x -= j !=0 ? Tote.h : 0;               
//                new Tote(x, y, Color.GRAY, true);
//            }
//            x -= Tote.w;
//            for (int j=0; j<2; j++) {
//                y = step.y - (Tote.h * 2) - (j * Tote.h);
//                new Tote(x, y, Color.GRAY);
//            }
//            x -= Tote.h;
//        }
//        y = step.y - Tote.h - Tote.w;
//        new Tote(x, y, Color.GRAY, true);
//        
//        for (int i=0; i<5; i++) {
//            new Tote((arena.width - Tote.w) - (i * Tote.w), step.y - Tote.h, Color.GRAY);
//        }
//        
//        //Zone overlays + Loading Zone contents
//        new FieldPiece(0.5, step.y - 51, arena.width - 1, 51, Color.YELLOW, false);
//        for (int i=0; i<3; i++) {
//            x = 56.5 + (i * (48 + 33));
//            y = scoringPlatform1.y - 33.75 - 21;
//            new Tote(x + 1.5, y + 1.5, Color.YELLOW);
//            new FieldPiece(x + Tote.w + 1.5, y + 1.5, 18, 18, Color.GREEN, "Recycling Bin");
//            new FieldPiece(x, y, 48, 21, Color.YELLOW, false, "Loading Zone " + (i + 1));
//        }
        addMouseListener(new MouseTracker(this));
        timer = new Timer(25, this);
        timer.start();             
        if (export) {
            String data = "";
            for (Entity e : entities) {
                if (e instanceof Tote) {
                    Tote t = (Tote) e;
                    data = data + "tote:" + (t.x + ":") + (t.y + ":") + (t.color.getRed() + ":") + (t.color.getGreen() + ":") + (t.color.getBlue() + ":") + (t.rotate + "]");
                } else if (e instanceof FieldPiece) {
                    FieldPiece p = (FieldPiece) e;
                    data = data + "fieldPiece:" + (p.x + ":") + (p.y + ":") + (p.width + ":") + (p.height + ":") + (p.color.getRed() + ":") + (p.color.getGreen() + ":") + (p.color.getBlue() + ":") + (p.fill + ":") + (p.display + "]");
                }
            }
            try {
                File file = new File("generated.field");
                if (file.exists()) file.delete();
                file.createNewFile();
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write(data);
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        self = this;
    }
    
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D g = (Graphics2D) graphics;
        for (Entity e : entities) {
            e.draw(g);
        }
        Point p = MouseInfo.getPointerInfo().getLocation();
        Point p2 = getLocationOnScreen();
        int mouseX = p.x - p2.x;
        int mouseY = p.y - p2.y;
        if (mouseX > 0 && mouseX < getWidth() && mouseY > 0 && mouseY < getHeight()) { //If the mouse is within the bounds of this JPanel
            if (Main.selected == Main.robotButton) {
                g.fillRect(mouseX, mouseY, Main.scaleUp(32), Main.scaleUp(32));
            }
        }
        graphics.dispose();
    }
    
    public void mouseClick(MouseEvent m) { //The first three lines are for getting the coordinates of the mouse relative to this JPanel
        Point p = getLocationOnScreen();
        int mouseX = m.getXOnScreen() - p.x; 
        int mouseY = m.getYOnScreen() - p.y;
        for (Entity e : entities) {
            if (e.getRect().contains(mouseX, mouseY)) {
                if (e.clicked()) {
                    return;
                }
            }
        }
        if (Main.selected == Main.robotButton) {
            new RobotConfig(mouseX / Main.multiplier, mouseY / Main.multiplier).setVisible(true);
        } else if (Main.selected == Main.driveButton) {
            if (robot != null) {
                double lastX = robot.x + (robot.width / 2);
                double lastY = robot.y + (robot.height / 2);
                for (Command c : robot.commands) {
                    if (c instanceof DriveCommand) {
                        DriveCommand d = (DriveCommand) c;
                        lastX = d.endX;
                        lastY = d.endY;
                    }
                }
                robot.commands.add(new DriveCommand(lastX, lastY, mouseX / Main.multiplier, mouseY / Main.multiplier));
            }
        } else if (Main.selected == Main.commandButton) {
            if (robot != null) {
                double x = robot.x + (robot.width / 2);
                double y = robot.y + (robot.height / 2);
                DriveCommand d = robot.getLastDrive();
                if (d != null) {
                    x = d.endX;
                    y = d.endY;
                }
                new CommandConfig(x, y).setVisible(true);
            }
        }
    }
    
    public void mouseRelease(MouseEvent m) {}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }   
}
