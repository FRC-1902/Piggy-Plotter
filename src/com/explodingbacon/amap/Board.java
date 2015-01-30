package com.explodingbacon.amap;

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

Add encoder mathstuffs for turning X number of degrees and for driving X number of inches.
Add a target at the end of each drive command.
Add turn command support.
Add custom command support.
Add autonomous saving & loading.
Make objects that follow the mouse not lag behind if it moves too fast.

==When everything else is implemented==

Make the robot go through the driving and waiting segments of it's autonomous on-screen.
*/

public class Board extends JPanel implements ActionListener {
   
    public static List<FieldPiece> pieces = new ArrayList<>();
    public static Robot robot = null;
    public FieldPiece arena = null;
    public FieldPiece scoringPlatform1 = null;
    public FieldPiece scoringPlatform2 = null;
    public FieldPiece step = null;    
    public Timer timer;
    
    public Board() {
          boolean export = false;          
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
            for (FieldPiece p : pieces) {
                if (p instanceof Tote) {
                    Tote t = (Tote) p;
                    data = data + "tote:" + (t.x + ":") + (t.y + ":") + (t.color.getRed() + ":") + (t.color.getGreen() + ":") + (t.color.getBlue() + ":") + (t.rotate + "]");
                } else if (p instanceof FieldPiece) {
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
    }
    
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D g = (Graphics2D) graphics;
        for (FieldPiece p : pieces) {
            p.draw(g);
        }
        if (robot != null) {
            for (Command c : robot.commands) {
                if (c instanceof DriveCommand) {
                    DriveCommand d = (DriveCommand) c;
                    g.drawLine((int) Math.round(d.startX * Main.multiplier), (int) Math.round(d.startY * Main.multiplier), (int) Math.round(d.endX * Main.multiplier), (int) Math.round(d.endY * Main.multiplier));
                }
            }
        }
        Point p = MouseInfo.getPointerInfo().getLocation();
        Point p2 = getLocationOnScreen();
        int mouseX = p.x - p2.x;
        int mouseY = p.y - p2.y;
        if (mouseX > 0 && mouseX < getWidth() && mouseY > 0 && mouseY < getHeight()) { //If the mouse is within the bounds of this JPanel
            if (Main.selected == Main.robotButton) {
                g.fillRect(mouseX, mouseY, (int) Math.round(32 * Main.multiplier), (int) Math.round(32 * Main.multiplier));
            }
        }
        graphics.dispose();
    }
    
    public void mouseClick(MouseEvent m) { //The first three lines are for getting the coordinates of the mouse relative to this JPanel
        Point p = getLocationOnScreen();
        int mouseX = m.getXOnScreen() - p.x; 
        int mouseY = m.getYOnScreen() - p.y;
        for (FieldPiece f : pieces) {
            if (f.getRect().contains(mouseX, mouseY)) {
                if (f.clicked()) {
                    return;
                }
            }
        }
        if (Main.selected  == Main.robotButton) {
            new RobotConfig(mouseX / Main.multiplier, mouseY / Main.multiplier).setVisible(true);
        } else if (Main.selected == Main.driveButton) {
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
    }
    
    public void mouseRelease(MouseEvent m) {}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }   
}
