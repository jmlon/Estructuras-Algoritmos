package edu.upb.estalg.ADTs.bombaObjetivo;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/**
 * Implementacion del ADT Bomba
 *
 * @author Jorge Londoño
 *
 */
public class Bomba implements IBomba {

    private double x;   // Coordenada X
    private double y;   // Coordenada Y
    private double t0;  // Tiempo de lanzamiento
    private double y0;  // Altura inicial

    public Bomba(double x, double y) {
        this.x = x;
        this.y = y0 = y;
        t0 = System.currentTimeMillis()/1000.0;
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

    @Override
    public void caer(double t) {
        double deltaT = t-t0;
        y = y0 - 9.8*deltaT*deltaT/2;
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
