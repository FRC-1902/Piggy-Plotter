package com.explodingbacon.piggyplotter;

import java.awt.geom.Line2D;
import java.util.List;

public class Util {
    
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
        list.remove(type);
        list.add(index + change, type);
    }
    
    public static double angle(Line2D line1, Line2D line2) {
        double xDiff1 = line1.getX2() - line1.getX1();
        double xDiff2 = line2.getX2() - line2.getX1();
        double yDiff1 = line1.getY2() - line1.getY1();
        double yDiff2 = line2.getY2() - line2.getY1();
        double angle = Math.atan2(xDiff1 * yDiff2 - yDiff1 * xDiff2, xDiff1 * xDiff2 + yDiff1 * yDiff2);
        double[] crossProduct = crossProduct(new double[]{xDiff1, yDiff1, 0}, new double[]{xDiff2, yDiff2, 0});
        if (Main.sign(crossProduct[2]) == -1) { //Turn left
            if (angle < 0) {
                angle *= -1;
            }
        } else { //Turn right
            if (angle > 0) {
                angle *= -1;
            }
        }
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
