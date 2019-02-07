package edu.upb.estalg.ADTs.bombaObjetivo;

/**
 * API del ADT Objetivo
 *
 * @author Jorge Londoño
 *
 */
public interface IObjetivo {

    boolean detectarColision(IBomba b);     // Detecta una colision de la Bomba con el Objetivo
    void dibujar();                         // Dibujar el Objetivo

}
