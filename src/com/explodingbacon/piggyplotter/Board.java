package com.explodingbacon.piggyplotter;

import com.explodingbacon.piggyplotter.field.RecycleRush;
import com.explodingbacon.piggyplotter.field.Field;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/*
===THE GREAT AND MIGHTY TODO LIST===

COMPLETELY fix distance measurements freaking out when starting on top of a field piece (i.e. scoring platform) and then re-enable it
Finish built-in field selection.
Add the ability to create turn commands independently from drive commands.
Add autonomous loading.
Add a target/robot at the end of each drive command.
Make the robot be able to run through the autonomous on-screen.
*/
public class Board extends ClickableJPanel implements ActionListener {

    public static Field field = new RecycleRush();
    public static Robot robot = null;
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

        addMouseListener(new MouseTracker(this));
        timer = new Timer(25, this);
        timer.start();
        if (export) {
            String data = "";
            for (Entity e : field.parts) {
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
                if (file.exists()) {
                    file.delete();
                }
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
        for (Entity e : field.parts) {
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
                if (robot == null) {
                    Color oldColor = g.getColor();
                    g.setColor(Main.robotColor);
                    g.fillRect(mouseX - (Main.scaleUp(28) / 2), mouseY - (Main.scaleUp(24) / 2), Main.scaleUp(28), Main.scaleUp(24));
                    g.setColor(oldColor);
                }
            }
        }
        graphics.dispose();
    }

    @Override
    public void mouseReleased(MouseEvent m) { //The first three lines are for getting the coordinates of the mouse relative to this JPanel
        Point p = getLocationOnScreen();
        int mouseX = m.getXOnScreen() - p.x;
        int mouseY = m.getYOnScreen() - p.y;
        if (robot != null) {
            for (CommandGroup cg : robot.commandGroups) {
                if (cg.getRect().contains(mouseX, mouseY)) {
                    if (cg.clicked()) {
                        return;
                    }
                }
            }
        }
        for (Entity e : field.parts) {
            if (e.getRect().contains(mouseX, mouseY)) {
                if (e.clicked()) {
                    return;
                }
            }
        }        
        if (Main.selected == Main.robotButton) {
            if (Board.robot == null) {
                new RobotConfig(new Robot((mouseX / Main.multiplier) - (Main.scaleUp(7)), (mouseY / Main.multiplier) - (Main.scaleUp(6)), 28, 24)).setVisible(true);
            }
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

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
