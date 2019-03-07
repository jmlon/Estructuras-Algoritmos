package edu.upb.estalg.objectSize;


/**
 * Clase ejemplo que utiliza el InstrumentationAgent para determinar el
 * tamano de objetos en memoria
 * 
 * @author Jorge Londono
 *
 * @see https://stackoverflow.com/questions/258120/what-is-the-memory-consumption-of-an-object-in-java
 * 
 */
public class ObjectSizeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer myInt = Integer.valueOf(1);
		System.out.println("Integer : "+InstrumentationAgent.getObjectSize(myInt));		// 16 bytes
		
		Character myChar = Character.valueOf('A');
		System.out.println("Char : "+InstrumentationAgent.getObjectSize(myChar));		// 16 bytes
		
		Boolean myBool = Boolean.valueOf(true);
		System.out.println("Boolean : "+InstrumentationAgent.getObjectSize(myBool));	// 16 bytes

		Float myFloat = Float.valueOf(0.0F);
		System.out.println("Float : "+InstrumentationAgent.getObjectSize(myFloat));		// 16 bytes

		Double myDouble = Double.valueOf(0.0);
		System.out.println("Double : "+InstrumentationAgent.getObjectSize(myDouble));	// 24 bytes
		
		
		// Arreglo de char
		char[] charArray0 = { };
		System.out.println("charArray0 : "+InstrumentationAgent.getObjectSize(charArray0));	// 24 bytes

		char[] charArray2 = { 'a', 'b' };
		System.out.println("charArray2 : "+InstrumentationAgent.getObjectSize(charArray2));	// 24 bytes

		char[] charArray4 = { 'a', 'b', 'c', 'd' };
		System.out.println("charArray4 : "+InstrumentationAgent.getObjectSize(charArray4));	// 24 bytes

		char[] charArray6 = { 'a', 'b', 'c', 'd', 'e', 'f' };
		System.out.println("charArray6 : "+InstrumentationAgent.getObjectSize(charArray6));	// xx bytes
		
		char[] charArray8 = { 'a', 'b', 'c', 'd', 'a', 'b', 'c', 'd' };
		System.out.println("charArray8 : "+InstrumentationAgent.getObjectSize(charArray8));	// 32 bytes

		// Arreglo de int
		int[] intArray2 = new int[2];
		System.out.println("intArray2 : "+InstrumentationAgent.getObjectSize(intArray2));	// 24 bytes

		int[] intArray4 = new int[4];
		System.out.println("intArray4 : "+InstrumentationAgent.getObjectSize(intArray4));	// 32 bytes

		int[] intArray8 = new int[8];
		System.out.println("intArray8 : "+InstrumentationAgent.getObjectSize(intArray8));	// 48 bytes

		// Bidimensional array
		int[][] intArray7x11 = new int[7][11];
		for(int i=0; i<intArray7x11.length; i++)
			for(int j=0; j<intArray7x11[0].length; j++)
				intArray7x11[i][j]=i+j;
		System.out.println("intArray7x11 : "+InstrumentationAgent.getObjectSize(intArray7x11));	// 48 bytes
		
		
		// String
		// Nota: Solo reporta el objeto String, no incluye el array de chars
		String str2 = "ab";
		System.out.println("str2 : "+InstrumentationAgent.getObjectSize(str2));	// 24 bytes
		
		String str4 = "abcd";
		System.out.println("str4 : "+InstrumentationAgent.getObjectSize(str4));	// 24 bytes

		String str8 = "abcdefgh";
		System.out.println("str8 : "+InstrumentationAgent.getObjectSize(str8));	// 24 bytes

		
		// Object
		Object obj = new Object();
		System.out.println("obj : "+InstrumentationAgent.getObjectSize(obj));	// 16 bytes

		// DemoClass
		DemoClass demoClass = new DemoClass();
		System.out.println("demoClass : "+InstrumentationAgent.getObjectSize(demoClass));	// 24 bytes

		// Una clase interna
		DemoClass.Node demoClassNode = demoClass.new Node();
		System.out.println("demoClassNode : "+InstrumentationAgent.getObjectSize(demoClassNode));	// 24 bytes
		
		
	}

}
