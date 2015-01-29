package com.explodingbacon.amap;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
   
    public static List<FieldPiece> pieces = new ArrayList<>();
    public FieldPiece arena = null;
    public FieldPiece scoringPlatform1 = null;
    public FieldPiece scoringPlatform2 = null;
    public FieldPiece step = null;    
    public Timer timer;
    
    public Board() { //This will eventually be changed to reading field data from a file. Until then, have this.
        arena = new FieldPiece(0, 0, 324, 648, Color.BLUE, null);
        scoringPlatform1 = new FieldPiece(0, 73.25, 187, 34.25, Color.WHITE, "Scoring Platform One");
        scoringPlatform2 = new FieldPiece(137, scoringPlatform1.y + scoringPlatform1.height + 78, 187, 34.25, Color.WHITE, "Scoring Platform Two");
        step = new FieldPiece(0, scoringPlatform2.y + scoringPlatform2.height + 78, 324, 25, Color.WHITE, "the Step"); //The 78 here is NOT final
        addMouseListener(new MouseTracker(this));
        
        //Totes mah goats
        for (int i=0; i<5; i++) {
            new Tote(i * Tote.w, step.y - Tote.h, Color.GRAY);
        }
        
        double x = 0;
        double y = 0;
        for (int i=0; i<2; i++) {
            y = step.y - Tote.h - Tote.w;
            for (int j=0; j<2; j++) {
                x += j !=0 ? Tote.h : 0;               
                new Tote(x, y, Color.GRAY, true);
            }
            x += Tote.h;
            for (int j=0; j<2; j++) {
                y = step.y - (Tote.h * 2) - (j * Tote.h);
                new Tote(x, y, Color.GRAY);
            }
            x += Tote.w + 0.5;
        }
        y = step.y - Tote.h - Tote.w;
        new Tote(x - 0.5, y, Color.GRAY, true);
        
        x = arena.width - Tote.h;
        y = 0;
        for (int i=0; i<2; i++) {
            y = step.y - Tote.h - Tote.w;
            for (int j=0; j<2; j++) {
                x -= j !=0 ? Tote.h : 0;               
                new Tote(x, y, Color.GRAY, true);
            }
            x -= Tote.w;
            for (int j=0; j<2; j++) {
                y = step.y - (Tote.h * 2) - (j * Tote.h);
                new Tote(x, y, Color.GRAY);
            }
            x -= Tote.h;
        }
        y = step.y - Tote.h - Tote.w;
        new Tote(x, y, Color.GRAY, true);
        
        for (int i=0; i<5; i++) {
            new Tote((arena.width - Tote.w) - (i * Tote.w), step.y - Tote.h, Color.GRAY);
        }
        
        //Zone overlays + Loading Zone contents
        new FieldPiece(0.5, step.y - 51, arena.width - 1, 51, Color.YELLOW, false, null);
        for (int i=0; i<3; i++) {
            x = 56.5 + (i * (48 + 33));
            y = scoringPlatform1.y - 33.75 - 21;
            new Tote(x + 1.5, y + 1.5, Color.YELLOW);
            new FieldPiece(x + Tote.w + 1.5, y + 1.5, 18, 18, Color.GREEN, "Recycling Bin");
            new FieldPiece(x, y, 48, 21, Color.YELLOW, false, null);
        }
        timer = new Timer(25, this);
        timer.start();
    }
    
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D g = (Graphics2D) graphics;
        for (FieldPiece p : pieces) {
            p.draw(g);
            if (p instanceof Robot) {
                System.out.println("Drew a robot. (wat)");
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
        if (Main.selected  == Main.robotButton) {
            new RobotConfig(mouseX / Main.multiplier, mouseY / Main.multiplier).setVisible(true);
        }
    }
    
    public void mouseRelease(MouseEvent m) {}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }   
    
    /*
    Here, have some copy-pasted file reading and writing code
    
    BufferedReader br = new BufferedReader(new FileReader("otherVersion.txt"));
    double otherVersion = Double.parseDouble(br.readLine().split("=")[1]);
    br.close();
    
    BufferedWriter bw = new BufferedWriter(new FileWriter(versionFile));
    bw.write("version=" + otherVersion);
    bw.close();
    */
}
