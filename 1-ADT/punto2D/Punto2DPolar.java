package edu.upb.estalg.punto;

/**
 * Implementacion del ADT Punto2D representado por medio de
 * coordenadas polares
 *  
 * @author jmlon
 *
 */
public class Punto2DPolar implements Punto2D {

	// Representacion del punto mediante coordenadas polares
	private double radio;
	private double theta;

	// Constructores
	public Punto2DPolar() {}	// Crea el punto (0,0)
	
	public Punto2DPolar(double radio, double theta) {
		this.radio = radio;
		this.theta = theta;
	}
	
	
	// Implementacion de la interfaz publica
	
	public double getX() {
		return radio*Math.cos(theta);
	}

	public double getY() {
		return radio*Math.sin(theta);
	}

	public double distancia(Punto2D p) {
		return Math.sqrt( (getX()-p.getX())*(getX()-p.getX()) + (getY()-p.getY())*(getY()-p.getY()) );
	}

	
	// TODO: Metodos heredados de la clase Object

	/**
	 * Obtener una representacion textual del objeto
	 * @see java.lang.Object#toString()
	 *
	 * @return
	 */
	public String toString() {
		return "mag = "+radio+", angulo = "+Math.toDegrees(theta);
	}
	
	/**
	 * Determinar igualdad con otros objetos
	 * @see java.lang.Object#equals(java.lang.Object)
	 *
	 * @param a		Objecto con respecto al cual se compara
	 * @return
	 */
	public boolean equals(Object a) {
		if (a==null) return false;
		if ( !(a instanceof Punto2D) ) return false;
		Punto2D px = (Punto2D) a;
		if (px.getX()==this.getX() && px.getY()==this.getY()) return true;
		return false;
	}
	
	
}
