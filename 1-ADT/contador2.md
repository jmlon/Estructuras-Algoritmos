{% highlight java %}

package edu.upb.estalg.votos;

/**
 * Definicion del API para el ADT Contador
 *  
 * @author jmlon
 *
 */
public interface Contador {

	/**
	 * Incrementa el valor del contador
	 */
	void incrementar();
	
	/**
	 * Obtiene el valor del contador
	 */
	int getConteo();
	
	/**
	 * Obtiene el id del contador
	 */
	String getId();
	
}

{% endhighlight %}

