package edu.upb.estalg.ADTs.bombaObjetivo;

/**
 * API del ADT Bomba
 *
 * @author Jorge Londoño
 *
 */
public interface IBomba {

    double getX();      // obtener coordenada x
    double getY();      // obtener coordenada y
    void mover();       // mover la Bomba hacia abajo
    void dibujar();     // dibujar la Bomba

}
