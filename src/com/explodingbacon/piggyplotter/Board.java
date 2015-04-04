package com.explodingbacon.piggyplotter;

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

Make the robot distance display actually show correct information.
Change the DriveCommand class to be a DriveGroup class that generates a drive and turn command and makes itself invisible and uneditable. 
COMPLETELY fix distance measurements freaking out when starting on top of a field piece (i.e. scoring platform) and then re-enable it
Add the ability to create turn commands independently from drive commands.
Add autonomous loading.
Add a target/robot at the end of each drive command.
Make objects that follow the mouse not lag behind if it moves too fast.
Make the robot be able to run through the autonomous on-screen.
*/

public class Board extends JPanel implements ActionListener {
   
    public static List<Entity> entities = new ArrayList<>();
    public static Robot robot = null;
    public static FieldPiece arena = null;
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
          
        arena = new FieldPiece(0, 0, 324, 648, new Color(57, 106, 198), null);
        FieldPiece scoringPlatform1 = new FieldPiece(0, 73.25, 187, 34.25, Color.WHITE, "Scoring Platform One");
        FieldPiece scoringPlatform2 = new FieldPiece(137, scoringPlatform1.y + scoringPlatform1.height + 78, 187, 34.25, Color.WHITE, "Scoring Platform Two");
        FieldPiece step = new FieldPiece(0, scoringPlatform2.y + scoringPlatform2.height + 78, 324, 25, Color.WHITE, "the Step"); //The 78 here is NOT final
        
        entities.add(arena);
        entities.add(scoringPlatform1);
        entities.add(scoringPlatform2);
        entities.add(step);
        
        //All the totes
        for (int i=0; i<5; i++) {
            entities.add(new Tote(i * Tote.w, step.y - Tote.h, Color.GRAY));
        }
        
        double x = 0;
        double y = 0;
        for (int i=0; i<2; i++) {
            y = step.y - Tote.h - Tote.w;
            for (int j=0; j<2; j++) {
                x += j !=0 ? Tote.h : 0;               
                entities.add(new Tote(x, y, Color.GRAY, true));
            }
            x += Tote.h;
            for (int j=0; j<2; j++) {
                y = step.y - (Tote.h * 2) - (j * Tote.h);
                entities.add(new Tote(x, y, Color.GRAY));
            }
            x += Tote.w + 0.5;
        }
        y = step.y - Tote.h - Tote.w;
        entities.add(new Tote(x - 0.5, y, Color.GRAY, true));
        
        x = arena.width - Tote.h;
        y = 0;
        for (int i=0; i<2; i++) {
            y = step.y - Tote.h - Tote.w;
            for (int j=0; j<2; j++) {
                x -= j !=0 ? Tote.h : 0;               
                entities.add(new Tote(x, y, Color.GRAY, true));
            }
            x -= Tote.w;
            for (int j=0; j<2; j++) {
                y = step.y - (Tote.h * 2) - (j * Tote.h);
                entities.add(new Tote(x, y, Color.GRAY));
            }
            x -= Tote.h;
        }
        y = step.y - Tote.h - Tote.w;
        entities.add(new Tote(x, y, Color.GRAY, true));
        
        for (int i=0; i<5; i++) {
            entities.add(new Tote((arena.width - Tote.w) - (i * Tote.w), step.y - Tote.h, Color.GRAY));
        }
        
        //Zone overlays + Loading Zone contents
        entities.add(new FieldPiece(0.5, step.y - 51, arena.width - 1, 51, Color.YELLOW, false, null));
        for (int i=0; i<3; i++) {
            x = 56.5 + (i * (48 + 33));
            y = scoringPlatform1.y - 33.75 - 21;
            entities.add(new Tote(x + 1.5, y + 1.5, Color.YELLOW));
            entities.add(new FieldPiece(x + Tote.w + 1.5, y + 1.0, 18, 18, new Color(16, 186, 71), "Recycling Bin"));
            entities.add(new FieldPiece(x, y, 48, 21, Color.YELLOW, false, null));
        }
        
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
    
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D g = (Graphics2D) graphics;
        for (Entity e : entities) {
            e.draw(g);
        }
        if (robot != null) {
            for (CommandGroup cg : robot.commandGroups) {
                for (Command c : cg.commands) {
                    c.draw(g);
                }
                cg.draw(g);
            }
        }
        Point p = MouseInfo.getPointerInfo().getLocation();
        Point p2 = getLocationOnScreen();
        int mouseX = p.x - p2.x;
        int mouseY = p.y - p2.y;
        if (mouseX > 0 && mouseX < getWidth() && mouseY > 0 && mouseY < getHeight()) { //If the mouse is within the bounds of this JPanel
            if (Main.selected == Main.robotButton) {
                if (robot == null) g.fillRect(mouseX - (Main.scaleUp(28) / 2), mouseY - (Main.scaleUp(24) / 2), Main.scaleUp(28), Main.scaleUp(24));
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
        if (robot != null) {
            for (CommandGroup cg : robot.commandGroups) {
                if (cg.getRect().contains(mouseX, mouseY)) {
                    if (cg.clicked()) {
                        return;
                    }
                }
            }
        }
        if (Main.selected == Main.robotButton) {
            if (Board.robot == null) new RobotConfig(new Robot((mouseX / Main.multiplier) - (Main.scaleUp(7)), (mouseY / Main.multiplier) - (Main.scaleUp(6)), 28, 24)).setVisible(true);
        } else if (Main.selected == Main.driveButton) {
            if (robot != null) {
                double lastX = robot.x + (robot.width / 2);
                double lastY = robot.y + (robot.height / 2);
                for (CommandGroup cg : robot.commandGroups) {
                for (Command c : cg.commands) {
                        if (c instanceof DriveCommand) {
                            DriveCommand d = (DriveCommand) c;
                            lastX = d.endX;
                            lastY = d.endY;
                        }
                    }
                }
                CommandGroup cg = new CommandGroup(false);
                cg.commands.add(new DriveCommand(lastX, lastY, mouseX / Main.multiplier, mouseY / Main.multiplier));
                robot.commandGroups.add(cg);
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
                new CommandGroupConfig(new CommandGroup(x, y)).setVisible(true);
            }
        }
    }
    
    public void mouseRelease(MouseEvent m) {}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }   
}
