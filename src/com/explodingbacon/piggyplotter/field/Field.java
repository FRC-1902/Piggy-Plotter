package com.explodingbacon.piggyplotter.field;

import com.explodingbacon.piggyplotter.FieldPiece;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Field {

    public FieldPiece arena = null;
    public List<FieldPiece> parts = new ArrayList<>();
    public Image image = null;
    
    public Field(String imagePath) {
        image = new ImageIcon(this.getClass().getResource(imagePath)).getImage();
    }
    
    public Field(Image image) {
        this.image = image;
    }
}
