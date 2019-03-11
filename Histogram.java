package com.ckarlsoft;

import java.lang.*;
import java.util.ArrayList;

/* The Histogram class provides a means to collect values within some range,
 * where the range is devided into a number of intervals with equal length.
 * Each value that is to be stored into a histogram falls in one of these
 * intervals or lies outside the range of the hostogram.
 * For each interval, a counter is present.
 * A histogram can be printed b printing the number of stored values per interval
 * using 'x'-characters. Each interval value will occupy one line.
 * A histogram is thus printed 90-degrees rotated.
 */
public class Histogram extends Object {
    double low, width, high;
    int n, counter = 0;
    Cell[] cell;

    /* The constructor needs three parameters:
     * l = lower limit of the range of the histogram
     * h = upper lomit of the range of the histogram
     * n = number of intervals in this range
     * The range now equals [l,h), where l lies inside the range and h lies outside
     * the range.
     */
    public Histogram(double l, double h, int m) {
        System.out.println("constructor to be implemented");
        this.low = l;
        this.high = h;
        this.n = m;
        cell = new Cell[m];
        width = (h - l) / m;



    }

    /* resets counting: counters for all intervals are reset to zero
     */
    public void reset() {
        System.out.println("reset to be implemented");
        counter = 0;
    }

    /* update(val) updates the histogram with value val. If l <= val < h then
     * the corresponding interval will be increased by one
     */
    public void update(double val) {
        int counter = 0;
        double l = low, h = low + width;
        Cell cell = new Cell();
        while (counter < n) {

            if (val >= l && val < h) {
                cell.plus1();
                System.out.println("low " + l + "high " + h);
            }

            l = h;
            h = h + width;


            counter++;
        }

        this.cell[this.counter] = cell;
        this.counter++;

        System.out.println("update to be implemented");
    }

    private void printForm(String str, int i) {
        System.out.print(str);
        for (int j = str.length(); j < i; j++)
            System.out.print(" ");
    }

    /* a histogram is printed by printing an interval per line. For each
     * interval [a,b) the number of occurances will be displayed using
     * 'x'-characters: as many will be printed as the coresponding counter for
     * this interval
     * On each such line, first the values a and b are printed to denote the
     * range of the interval.
     * <pre>
     * 1	-	3.5	: xxx
     * 3.5	-	-6	: xx
     * 6	-	8.5	: xxxxxxx
     * 8.5	-	11	: xxxxxxxx
     * </pre>
     * e.g, there where two stored values within teh interval [10.20).
     */
    public void print() {
        double curVal = low;
        for (int i = 0; i < n; i++) {

            String str = String.valueOf(curVal);

            this.printForm(str, 8);

            this.printForm("-", 4);

            // System.out.print("-");

            curVal += width;

            str = String.valueOf(curVal);

            this.printForm(str, 8);

            System.out.print(": ");
            cell[i].print();
            // System.out.println();
        }
    }
}

class Cell {
    private int value = 0;

    public void print() {
        for (int j = 1; j <= value; j++)
            System.out.print("x");
        System.out.println();
    }

    public void reset() {
        value = 0;
    }

    public void plus1() {
        value++;
    }
}