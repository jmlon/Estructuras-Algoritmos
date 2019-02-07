package edu.upb.estalg.ADTs.bombaObjetivo;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.event.KeyEvent;

/**
 * Aplicacion cliente: Uso de los ADT Bomba y Objetivo
 *
 *  @author Jorge Londoño
 *
 */
public class JuegoBombas {


    private static void pintarPiso() {
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.line(0,0, 10,0);
    }


    public static void main(String[] args) throws InterruptedException {

        Objetivo o = new Objetivo(3,0, 3, 2);

        // Activar el modo de doble-buffering, inicializar la escala
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0,10);
        StdDraw.setYscale(0,10);

        // Inicializar la imagen
        StdDraw.clear();
        pintarPiso();
        o.dibujar();
        StdDraw.show();


        // Espera que se presione el mouse para lanzar una bomba
        while(! StdDraw.isMousePressed())
            StdDraw.pause(50);

        // Crear la bomba en el lugar que se presiono el mouse
        Bomba b = new Bomba(StdDraw.mouseX(),StdDraw.mouseY());

        // Animacion de la caida de la bomba
        while(b.getY()>0) {
            StdDraw.clear();
            pintarPiso();
            b.mover();
            o.dibujar();
            b.dibujar();
            if (o.detectarColision(b)) {
                StdDraw.text(b.getX(), b.getY(), "BOOM!");
            }
            StdDraw.show();
            StdDraw.pause(50);

            // Salir del programa con la tecla ESC
            if (StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) break;
        }
        // Para dar por terminada aplicación con GUI
        System.exit(0);
    }

}
