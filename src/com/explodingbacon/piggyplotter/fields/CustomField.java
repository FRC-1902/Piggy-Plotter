package com.explodingbacon.piggyplotter.fields;

import com.explodingbacon.piggyplotter.FieldPiece;
import com.explodingbacon.piggyplotter.Main;
import com.explodingbacon.piggyplotter.Tote;
import com.explodingbacon.piggyplotter.fields.Field;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomField extends Field {

    public CustomField(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String info = br.readLine();
            for (String command : info.split("]")) {
                String[] s = command.split(":");
                if (s[0].equals("tote")) {
                    parts.add(new Tote(Double.parseDouble(s[1]), Double.parseDouble(s[2]), new Color(Integer.parseInt(s[3]), Integer.parseInt(s[4]), Integer.parseInt(s[5])), Boolean.parseBoolean(s[6])));
                } else {
                    FieldPiece f = new FieldPiece(Double.parseDouble(s[1]), Double.parseDouble(s[2]), Double.parseDouble(s[3]), Double.parseDouble(s[4]), new Color(Integer.parseInt(s[5]), Integer.parseInt(s[6]), Integer.parseInt(s[7])), Boolean.parseBoolean(s[8]), s[9]);
                    parts.add(f);
                    if (f.display.equals("Arena")) {
                        arena = f;
                    }
                }
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
