package edu.upb.estalg.objectSize;

/*
 * Instrucciones para utilizar la Instrumentacion en un programa:
 * 
 * 1. Compilar la clase InstrumentationAgent
 * 2. Crear un archivo manifest.txt con el contenido:
 *    Premain-Class: edu.upb.estalg.objectSize.InstrumentationAgent
 * 3. Crear un archivo .jar con el manifiesto y la clase compilada
 *    jar -cmf manifest.txt agent.jar bin/edu/upb/estalg/objectSize/InstrumentationAgent.class
 * 4. Ejecutar el codigo donde se quiere realizar la medicion de tamano de objetos,
 *    pasando el agente a la JVM
 *    java -javaagent:agent.jar -cp ./bin edu.upb.estalg.objectSize.ObjectSizeTest
 *    
 * 
 */


import java.lang.instrument.Instrumentation;

public class InstrumentationAgent {

	private static volatile Instrumentation globalInstr;
	
	
	public static void premain(String args, Instrumentation inst) {
		globalInstr = inst;
	}
	
	
	public static long getObjectSize(Object obj) {
		if (globalInstr == null)
			throw new IllegalStateException("Agent not initted");
		return globalInstr.getObjectSize(obj);
	}	


}
