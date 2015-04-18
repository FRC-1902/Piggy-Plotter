package com.explodingbacon.piggyplotter;

import java.awt.geom.Line2D;
import java.util.List;

public class Util {
    
    /**
     * Shift the index of an object in a list up or down a certain amount.
     * @param list The list the object is in.
     * @param o The object who's index is being changed. 
     * @param change How much the index should be changed.
     */
    public static <T> void shiftIndex(List<T> list, Object o, int change) {
        int index = 0;
        T type = null;
        for (T t : list) {
            if (t == o) {
                type = t;
                break;
            }
            index++;
        }
        if (type != null) {
            list.remove(type);
            list.add(index + change, type);
        }
    }
    
    /**
     * Get the angle of two lines.
     * @param line1 The first line.
     * @param line2 The second line.
     * @return The angle of the two lines.
     */
    public static double angle(Line2D line1, Line2D line2) {
        double xDiff1 = line1.getX2() - line1.getX1();
        double xDiff2 = line2.getX2() - line2.getX1();
        double yDiff1 = line1.getY2() - line1.getY1();
        double yDiff2 = line2.getY2() - line2.getY1();
        double angle = Math.atan2(xDiff1 * yDiff2 - yDiff1 * xDiff2, xDiff1 * xDiff2 + yDiff1 * yDiff2);
        double[] crossProduct = crossProduct(new double[]{xDiff1, yDiff1, 0}, new double[]{xDiff2, yDiff2, 0});
        if (Main.sign(crossProduct[2]) == -1) { //Turn left
            if (angle < 0) {
                angle *= -1; //Make it positive
            }
        } else { //Turn right
            if (angle > 0) {
                angle *= -1; //Make it negative
            }
        }
        angle *= 57.2957795; //Convert from radians to degrees
        return angle;
    }
    
    public static double[] crossProduct(double[] v0, double[] v1) {
        double crossProduct[] = new double[3];

        crossProduct[0] = v0[1] * v1[2] - v0[2] * v1[1];
        crossProduct[1] = v0[2] * v1[0] - v0[0] * v1[2];
        crossProduct[2] = v0[0] * v1[1] - v0[1] * v1[0];

        return crossProduct;
    }
}
