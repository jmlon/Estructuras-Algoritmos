package edu.upb.estalg.punto;

/**
 * Definicion del API para el ADT Punto2D
 * 
 * @author jmlon
 *
 */
public interface Punto2D {
	
	/**
	 * 
	 * @return La coordenada X del punto
	 */
	double getX();

	/**
	 * 
	 * @return La coordenada Y del punto
	 */
	double getY();

	/**
	 * 
	 * @return La distancia euclideana entre 'this' y 'punto'
	 */
	double distancia(Punto2D punto);
	
}
