/*
  Implementacion del ADT Punto2D

  @author: Jorge Londono

  Para ejecutar: node punto2D.js

 */



// Puntos 2D en representacion cartesiana
function Punto2DCartesiano(x,y) {
  this.x = x;
  this.y = y;
  this.toString = function() { return "("+this.x+","+this.y+")" };
  this.getX = function() { return this.x };
  this.getY = function() { return this.y };
}

// Puntos 2D en representacion polar
function Punto2DPolar(r,t) {
  this.toRadians = function(t) { return t*Math.PI/180; };
  this.toDegrees = function(t) { return t*180/Math.PI; };
  this.r = r;
  this.theta = this.toRadians(t);
  this.toString = function() { return `Magnitud: ${this.r}, Angulo: ${this.toDegrees(this.theta)}` };
  this.getX = function() { return this.r*Math.cos(this.theta) };
  this.getY = function() { return this.r*Math.sin(this.theta) };
}

const distancia = function(p2) {
  return Math.sqrt(
    (this.getX()-p2.getX())*(this.getX()-p2.getX()) + (this.getY()-p2.getY())*(this.getY()-p2.getY())
  ) };

const equals = function(p2) {
  return this.getX()===p2.getX() && this.getY()===p2.getY();
}

// Utilizar una misma implementacion del metodo distancia para ambas clases
Punto2DCartesiano.prototype.distancia = distancia;
Punto2DPolar.prototype.distancia = distancia;

// Utilizar una misma implementacion del metodo equals para ambas clases
Punto2DCartesiano.prototype.equals = equals;
Punto2DPolar.prototype.equals = equals;


// Ejemplos de uso de los objetos

let punto1 = new Punto2DCartesiano(5,4);
console.log(punto1.toString());

let punto2 = new Punto2DPolar(7,30);
console.log(punto2.toString());
console.log("("+punto2.getX()+","+punto2.getY()+")");

// Observar el uso polimorfico de los métodos distancia e equals
console.log( punto1.distancia(punto2) );
console.log( punto2.distancia(punto1) );
console.log( punto1.equals(punto2) );

// Son iguales punto3 y punto4? Analizar
let punto3 = new Punto2DCartesiano(1,1);
let punto4 = new Punto2DPolar(Math.sqrt(2), 45);
console.log( punto3.equals(punto4) );
