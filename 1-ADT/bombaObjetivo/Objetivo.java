package edu.upb.estalg.ADTs.bombaObjetivo;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/**
 * Implementacion del ADT Objetivo
 *
 * @author Jorge Londoño
 *
 */
public class Objetivo implements IObjetivo {

    private double x;
    private double y;
    private double w;
    private double h;

    public Objetivo(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public boolean detectarColision(IBomba b) {
        if (b.getX()>x && b.getX()<x+w && b.getY()>=y && b.getY()<=y+h) return true;
        return false;
    }

    @Override
    public String toString() {
        return "Objetivo{" + "x=" + x + ", y=" + y + ", w=" + w + ", h=" + h +'}';
    }

    public void dibujar() {
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(x+w/2,y+h/2,w/2,h/2);
    }


    public static void main(String[] args) {
        IBomba b1 = new Bomba(5, 1);    // Bomba fuera del area
        IBomba b2 = new Bomba(10, 2);   // Bomba dentro del area
        IObjetivo obj = new Objetivo(1,0, 6, 2);

        assert( obj.detectarColision(b1) );
        assert( obj.detectarColision(b2)==false );

        StdOut.println(b1);
        StdOut.println(b2);
        StdOut.println(obj);
    }


}
