package com.explodingbacon.piggyplotter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseTracker implements MouseListener {

    public Board board;
    
    public MouseTracker(Board board) {
        this.board = board;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        board.mouseClick(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        board.mouseRelease(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
