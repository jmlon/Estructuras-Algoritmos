using System;

/*
 * Sobre la clase Object en .NET 4.7.2
 * https://docs.microsoft.com/en-us/dotnet/api/system.object?view=netframework-4.7.2
 */

namespace PuntosPlano
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			Console.WriteLine ("Pruebas del ADT Punto2D");
			IPunto2D origen = new Punto2DCartesiano ();
			IPunto2D a = new Punto2DCartesiano (1, 2);
			IPunto2D b = new Punto2DPolar (3, ToRadians (45));
			IPunto2D c = new Punto2DCartesiano (b.getX(), b.getY());

			// Probando el metodo ToString
			Console.WriteLine (origen);
			Console.WriteLine (a);
			Console.WriteLine (b);
			Console.WriteLine (c);

			// Probando el metodo Equals
			Console.WriteLine( "a==b? {0}", a.Equals(b));
			Console.WriteLine( "b==c? {0}", b.Equals(c));

			// Probando el metodo distancia
			Console.WriteLine("distancia(origen,a) = {0}", origen.distancia(a));
			Console.WriteLine("distancia(a,b) = {0}", a.distancia(b));
			Console.WriteLine("distancia(b,c) = {0}", b.distancia(c));


		}

		public static double ToRadians(double phi)
		{
			return phi*Math.PI/180.0;
		}

		public static double ToDegrees(double phi)
		{
			return phi*180.0/Math.PI;
		}

	}


	// La interfaz IPunto2D declara el API del ADT Punto2D
	public interface IPunto2D 
	{

		double getX();

		double getY();

		double distancia (IPunto2D p);

	}


	// Punto2DCartesiano es una implementacion del ADT Punto2D
	public class Punto2DCartesiano: IPunto2D 
	{
	
		// Representacion cartesiana del ADT Punto2D
		private double x;
		private double y;

		public Punto2DCartesiano() 
		{}

		public Punto2DCartesiano(double x, double y) 
		{
			this.x = x;
			this.y = y;
		}


		public double getX() 
		{
			return x;
		}

		public double getY() 
		{
			return y;
		}

		public double distancia(IPunto2D p) 
		{
			return Math.Sqrt( (getX()-p.getX())*(getX()-p.getX()) + (getY()-p.getY())*(getY()-p.getY()) );
		}

		public override string ToString()
		{
			return String.Format ("({0},{1})", x, y);
		}

		public override bool Equals(Object obj)
		{
			if (obj == null)
				return false;
			if (! (obj is IPunto2D) )
				return false;
			IPunto2D p = (IPunto2D)obj;
			return x == p.getX () && y == p.getY ();

		}

		public override int GetHashCode ()
		{
			return x.GetHashCode()^y.GetHashCode();
		}

	}


	// Punto2DPolar es otra implementacion del ADT Punto2D
	public class Punto2DPolar: IPunto2D
	{
		private double radio;
		private double theta;

		public Punto2DPolar()
		{}

		public Punto2DPolar(double radio, double theta)
		{
			this.radio = radio;
			this.theta = theta;
		}

		public double getX()
		{
			return radio * Math.Cos (theta);
		}

		public double getY()
		{
			return radio * Math.Sin (theta);
		}

		public double distancia(IPunto2D p) 
		{
			return Math.Sqrt( (getX()-p.getX())*(getX()-p.getX()) + (getY()-p.getY())*(getY()-p.getY()) );
		}

		public override string ToString()
		{
			return String.Format("mag={0}, ang={1}",radio, MainClass.ToDegrees(theta));
		}

		public override bool Equals(Object obj)
		{
			if (obj == null)
				return false;
			if (! (obj is IPunto2D) )
				return false;
			IPunto2D p = (IPunto2D)obj;
			return getX() == p.getX () && getY() == p.getY ();

		}

		public override int GetHashCode ()
		{
			return radio.GetHashCode ()^theta.GetHashCode();
		}

	}

}
