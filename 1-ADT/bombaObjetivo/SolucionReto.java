package edu.upb.estalg.ADTs.bombaObjetivo;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

/**
 * Versión con colección de objetos Bomba
 * Corrige el ConcurrentModificationException, al costo de una conversion toArray
 *
 * @author Jorge Londoño
 *
 */
public class SolucionReto {


    private static void pintarPiso() {
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.line(0,0, 10,0);
    }

    // Para ponerle colores a los objetivos
    static Color[] colores = { StdDraw.RED, StdDraw.BLUE, StdDraw.GREEN, StdDraw.CYAN, StdDraw.BLACK, StdDraw.YELLOW };


    public static void main(String[] args) throws InterruptedException {

        // Se comenta para poder crear varios objetivos
        //Objetivo o = new Objetivo(3,0, 3, 2);

        LinkedList<IBomba> listaBombas = new LinkedList<>();

        // Nuevas variables utilizadas en la solucion a los retos
        LinkedList<IBomba> bombasParaBorrar = new LinkedList<>();
        boolean mousePresionado = false;
        LinkedList<IObjetivo> objetivos = new LinkedList<>();

        // Para crear varios objetivos se implementa una lista de objetos Objetivo
        // y se inicializa con algunos "Edificios" aleatoriamente.
        for(int i=0; i<3; i++)
            objetivos.add(new Objetivo(StdRandom.uniform(0.0,10.0), // posicion x
                    0, // posicion y (siempre en altura 0)
                    StdRandom.uniform(1.0,3.0), // ancho del objetivo
                    StdRandom.uniform(1.0, 3.0), // alto del objetivo
                    colores[StdRandom.uniform(colores.length)] // Color del objetivo
                    )
            );


        // Activar el modo de doble-buffering, inicializar la escala
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0,10);
        StdDraw.setYscale(0,10);

        // Inicializar la imagen
        StdDraw.clear();
        pintarPiso();
        // pintar los objetivos
        for (IObjetivo o : objetivos) o.dibujar();
        StdDraw.show();


        // Lanzar bombas hasta que el usuario salga presionando ESC
        while(true) {
            StdDraw.pause(DELAY);

            StdDraw.clear();
            pintarPiso();
            // pintar los objetivos
            for (IObjetivo o : objetivos) o.dibujar();

            // hacer caer las bombas y dibujarlas
            bombasParaBorrar.clear();
            for(IBomba b: listaBombas.toArray(new IBomba[] {})) {
                double t = System.currentTimeMillis()/1000.0; // tiempo en segundos
                b.caer(t);
                b.dibujar();
                // Comparar con todos los objetivos para detectar posibles colisiones
                for (IObjetivo o : objetivos)
                    if (o.detectarColision(b)) {
                        StdDraw.text(b.getX(), b.getY(), "BOOM!");
                    }
                if (b.getY()<0) {
                    // El error "ConcurrentModificationException ocurre por eliminar objetos de la lista
                    // al mismo tiempo que se esta recorriendo su iterador.
//                    listaBombas.remove(b);
                    // Solucion:
                    // Se guardan en una lista temporal los objetos a remover y se remueven fuera del ciclo.
                    bombasParaBorrar.add(b);
                }
            }
            // Se borran de la lista fuera del ciclo, cuando ya se elimino el iterador de la lista
            for(IBomba b: bombasParaBorrar)
                listaBombas.remove(b);
            StdDraw.show();

            // Salir del programa con la tecla ESC
            if (StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) break;

            if (! mousePresionado && StdDraw.isMousePressed()) {
                // Crear una bomba en el lugar que se presiono el mouse

                // Se lanza mas de una bomba porque el usuario deja presionado el mouse por un tiempo
                // mayor a la duración del ciclo. Durante la ejecución se repite el ciclo y vuelve a ver
                // el mouse aun en el estado presionado.
                IBomba b = new Bomba(StdDraw.mouseX(),StdDraw.mouseY());
                listaBombas.add(b);
                // Solución: Con la bandera mousePresionado se controla que solo se crea una bomba
                // el anteriormente el mouse no estaba presionado.
                // Al ponerse la bandera en true, no volvera a crear bombar hasta que se suelte el boton
                mousePresionado = true;
            }
            // Cuando se suelta el boton se apaga la bandera mousePresionado
            if (!StdDraw.isMousePressed())
                mousePresionado = false;

        }
        // Para dar por terminada aplicación con GUI
        System.exit(0);
    }


    private static final int DELAY = 33; // 33mseg para 30 fps

}
