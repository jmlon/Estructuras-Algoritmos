package edu.upb.estalg.ADTs.bombaObjetivo;

import edu.princeton.cs.algs4.StdDraw;

/**
 * Implementacion del ADT Bomba
 *
 * @author Jorge Londoño
 *
 */
public class Bomba implements IBomba {

    private double x;
    private double y;

    public Bomba(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void mover() {
        y -= 0.1;
    }

    public String toString() {
        return "Bomba{"+x+","+y+"}";
    }

    public void dibujar() {
        StdDraw.setPenRadius(0.02);
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.point(x,y);
    }

}
