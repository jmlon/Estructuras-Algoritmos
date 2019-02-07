package edu.upb.estalg.punto


fun main(args: Array<String>) {
    val origen = Punto2DCartesiano()                        // (0,0)
    val punto1 = Punto2DCartesiano(4.0,0.0)         // (4,0)
    val punto2 = Punto2DPolar(3.0, Math.PI/2)   // (0,3)

    // Para activar la comprobacion de asserts, ejecutar con la bandera -ea
    assert( punto1.distancia(origen)==4.0 )
    assert( punto2.distancia(origen)==3.0 )

    // Obtener la distancia entre dos puntos
    println("Distancia entre punto1 y punto2 ${punto1.distancia(punto2)}")

}


interface Punto2D {
    fun getX(): Double
    fun getY(): Double
    fun distancia(punto: Punto2D): Double {
        return Math.sqrt((this.getX()-punto.getX())*(this.getX()-punto.getX())+(this.getY()-punto.getY())*(this.getY()-punto.getY()))
    }
}


class Punto2DCartesiano(private val xx: Double = 0.0, private val yy: Double =0.0): Punto2D {

    override fun getX() = xx

    override fun getY() = yy

}


class Punto2DPolar(private val radio: Double = 0.0, private val theta: Double = 0.0) : Punto2D {

    override fun getX() = radio*Math.cos(theta)

    override fun getY() = radio*Math.sin(theta)

}


