package com.explodingbacon.piggyplotter.fields;

import com.explodingbacon.piggyplotter.FieldPiece;
import com.explodingbacon.piggyplotter.RC;
import com.explodingbacon.piggyplotter.Tote;
import com.explodingbacon.piggyplotter.fields.Field;
import java.awt.Color;

public class RecycleRush extends Field {
    
    public RecycleRush() {
        arena = new FieldPiece(0, 0, 324, 648, new Color(57, 106, 198), null);
        FieldPiece scoringPlatform1 = new FieldPiece(0, 73.25, 187, 34.25, Color.WHITE, "Scoring Platform One");
        FieldPiece scoringPlatform2 = new FieldPiece(137, scoringPlatform1.y + scoringPlatform1.height + 78, 187, 34.25, Color.WHITE, "Scoring Platform Two");
        FieldPiece step = new FieldPiece(0, scoringPlatform2.y + scoringPlatform2.height + 78, 324, 25, Color.WHITE, "the Step"); //The 78 here is NOT final

        parts.add(arena);
        parts.add(scoringPlatform1);
        parts.add(scoringPlatform2);
        parts.add(step);

        //The landfill. *shudder*
        for (int i = 0; i < 5; i++) {
            parts.add(new Tote(i * Tote.w, step.y - Tote.h, Color.GRAY));
        }

        double x = 0;
        double y = 0;
        for (int i = 0; i < 2; i++) {
            y = step.y - Tote.h - Tote.w;
            for (int j = 0; j < 2; j++) {
                x += j != 0 ? Tote.h : 0;
                parts.add(new Tote(x, y, Color.GRAY, true));
            }
            x += Tote.h;
            for (int j = 0; j < 2; j++) {
                y = step.y - (Tote.h * 2) - (j * Tote.h);
                parts.add(new Tote(x, y, Color.GRAY));
            }
            x += Tote.w + 0.5;
        }
        y = step.y - Tote.h - Tote.w;
        parts.add(new Tote(x - 0.5, y, Color.GRAY, true));

        x = arena.width - Tote.h;
        y = 0;
        for (int i = 0; i < 2; i++) {
            y = step.y - Tote.h - Tote.w;
            for (int j = 0; j < 2; j++) {
                x -= j != 0 ? Tote.h : 0;
                parts.add(new Tote(x, y, Color.GRAY, true));
            }
            x -= Tote.w;
            for (int j = 0; j < 2; j++) {
                y = step.y - (Tote.h * 2) - (j * Tote.h);
                parts.add(new Tote(x, y, Color.GRAY));
            }
            x -= Tote.h;
        }
        y = step.y - Tote.h - Tote.w;
        parts.add(new Tote(x, y, Color.GRAY, true));

        for (int i = 0; i < 5; i++) {
            parts.add(new Tote((arena.width - Tote.w) - (i * Tote.w), step.y - Tote.h, Color.GRAY));
        }

        //Left set of totes and containers on the step
        x = 0;
        for (int i = 0; i < 8; i++) {
            if (i != 2 && i != 6) {
                parts.add(new Tote(x, step.y, Color.GRAY, true));
                x += Tote.h;
            } else {
                parts.add(new RC(x, step.y + 3.5));
                x += RC.w;
            }
        }

        //Right set of totes and containers on the step
        x = arena.width - Tote.h;
        for (int i = 0; i < 8; i++) {
            if (i != 2 && i != 6) {
                parts.add(new Tote(x, step.y, Color.GRAY, true));
                if (i + 1 == 2 || i + 1 == 6) {
                    x -= RC.w;
                } else {
                    x -= Tote.h;
                }
            } else {
                parts.add(new RC(x, step.y + 3.5));
                x -= Tote.h;
            }
        }

        //Zone overlays + Loading Zone contents
        parts.add(new FieldPiece(0.5, step.y - 51, arena.width - 1, 51, Color.YELLOW, false, null));
        for (int i = 0; i < 3; i++) {
            x = 56.5 + (i * (48 + 33));
            y = scoringPlatform1.y - 33.75 - 21;
            parts.add(new Tote(x + 1.5, y + 1.5, Color.YELLOW));
            parts.add(new RC(x + Tote.w + 1.5, y + 1.0));
            parts.add(new FieldPiece(x, y, 48, 21, Color.YELLOW, false, null));
        }
    }    
}
