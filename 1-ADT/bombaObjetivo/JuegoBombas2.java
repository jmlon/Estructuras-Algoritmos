package edu.upb.estalg.ADTs.bombaObjetivo;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.event.KeyEvent;
import java.util.LinkedList;

/**
 * Versión con colección de objetos Bomba
 * Esta version genera eventualmente excepciones: ConcurrentModificationException
 *
 * @author Jorge Londoño
 *
 */
public class JuegoBombas2 {


    private static void pintarPiso() {
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.line(0,0, 10,0);
    }


    public static void main(String[] args) throws InterruptedException {

        Objetivo o = new Objetivo(3,0, 3, 2);

        LinkedList<IBomba> listaBombas = new LinkedList<>();

        // Activar el modo de doble-buffering, inicializar la escala
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0,10);
        StdDraw.setYscale(0,10);

        // Inicializar la imagen
        StdDraw.clear();
        pintarPiso();
        o.dibujar();
        StdDraw.show();


        // Lanzar bombas hasta que el usuario salga presionando ESC
        while(true) {
            StdDraw.pause(DELAY);

            StdDraw.clear();
            pintarPiso();
            o.dibujar();

            // hacer caer las bombas y dibujarlas
            for(IBomba b: listaBombas) {
                double t = System.currentTimeMillis()/1000.0; // tiempo en segundos
                b.caer(t);
                b.dibujar();
                if (o.detectarColision(b)) {
                    StdDraw.text(b.getX(), b.getY(), "BOOM!");
                }
                if (b.getY()<0)
                    listaBombas.remove(b);
            }
            StdDraw.show();

            // Salir del programa con la tecla ESC
            if (StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) break;

            if (StdDraw.isMousePressed()) {
                // Crear una bomba en el lugar que se presiono el mouse
                IBomba b = new Bomba(StdDraw.mouseX(),StdDraw.mouseY());
                listaBombas.add(b);
            }

        }
        // Para dar por terminada aplicación con GUI
        System.exit(0);
    }


    private static final int DELAY = 33; // 33mseg para 30 fps

}
