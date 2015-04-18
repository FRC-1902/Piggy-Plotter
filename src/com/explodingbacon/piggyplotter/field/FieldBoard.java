package com.explodingbacon.piggyplotter.field;

import com.explodingbacon.piggyplotter.ClickableJPanel;
import com.explodingbacon.piggyplotter.MouseTracker;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class FieldBoard extends ClickableJPanel implements ActionListener {

    public List<FieldDisplay> displays = new ArrayList<>();
    public Timer timer;
    
    public FieldBoard() {
        addMouseListener(new MouseTracker(this));
        int x = 40;
        int y = 0;
        int page = 1; //TODO multiple pages of fields. Only needed if we have more than 8
        List<Field> fields = new ArrayList<>();
        fields.add(new RecycleRush());
        int spaceAmount = -1;
        while (!fields.isEmpty()) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    if (fields.isEmpty()) break;
                    Field f = fields.get(j);
                    displays.add(new FieldDisplay(f, x, y));
                    fields.remove(f);
                    if (spaceAmount == -1) {
                        spaceAmount = f.image.getWidth(null) + 10; 
                    }
                    x += spaceAmount;
                }
                x = 40;
                y += spaceAmount;
                if (fields.isEmpty()) break;
            }
            page++;
        }
        timer = new Timer(25, this);
        timer.start();
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        //TODO clicking field buttons to select fields
    }
    
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D g = (Graphics2D) graphics;
        
        for (FieldDisplay f : displays) {
            f.draw(g);
        }     
        
        graphics.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }         
}
