package com.explodingbacon.piggyplotter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseTracker implements MouseListener {

    ClickableJPanel p;
    
    public MouseTracker(ClickableJPanel p) {
        this.p = p;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        p.mouseClicked(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        p.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}   
}
