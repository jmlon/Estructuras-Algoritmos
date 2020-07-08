package edu.upb.estalg.votos;

import edu.princeton.cs.algs4.StdOut;

/** 
 * Una implementacion del ADT Contador
 * @author jmlon
 *
 * Para activar la comprobacion de validaciones, ejecutar con
 * la bandera -ea, por ejemplo:
 * java -ea edu.upb.estalg.votos.ImplementacionContador
 *
 */
public class ImplementacionContador implements Contador {

	// Representacion
	private String id;
	private int conteo;
	
	
	/**
	 * Construye una instancia con un id
	 */
	public ImplementacionContador(String id) {
		this.id = id;
	}
	
	// Implementacion de la interfaz publica
	
	@Override
	public void incrementar() {
		conteo++;
	}

	@Override
	public int getConteo() {
		return conteo;
	}

	@Override
	public String getId() {
		return id;
	}
	
	
	
	/**
	 * Pruebas unitarias de la clase
	 * @param args
	 */
	public static void main(String[] args) {
		// La prueba unitaria es un cliente del ADT que permite verificar su correcto funcionamiento
		Contador a = new ImplementacionContador("Prueba conteo");
		a.incrementar();
		a.incrementar();
		assert(a.getConteo() == 2);
		StdOut.println("El valor de "+a.getId()+" es "+a.getConteo());
	}

	
}
