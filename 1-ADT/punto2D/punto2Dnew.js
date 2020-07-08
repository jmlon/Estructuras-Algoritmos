"use strict";
/*
  Implementacion del ADT Punto2D
  Versión basada en classes de ES6

  @author: Jorge Londoño

  Para ejecutar: node punto2Dnew.js

 */


class Punto2D {

  distancia(p2)  {
    return Math.sqrt(
      (this.getX-p2.getX)*(this.getX-p2.getX) + (this.getY-p2.getY)*(this.getY-p2.getY)
    ) 
  };
  
  equals(p2) {
    return this.distancia(p2)<1E-6;
  }

}

class Punto2DCartesiano extends Punto2D {

  constructor(x,y) {
    super();
    this.x = x;
    this.y = y;
  }

  toString() {
    return "("+this.x+","+this.y+")";
  }

  get getX() { return this.x }

  get getY() { return this.y }

  set setX(newx) { this.x = newx }

  set setY(newy) { this.y = newy }

}

class Punto2DPolar extends Punto2D {

  constructor(r,t) {
    super();
    this.r = r;
    this.theta = this.toRadians(t);
  }

  toRadians(t) { return t*Math.PI/180; };

  toDegrees(t) { return t*180/Math.PI; };

  toString() { return `Magnitud: ${this.r}, Angulo: ${this.toDegrees(this.theta)}` };

  get getX() { return this.r*Math.cos(this.theta) };

  get getY() { return this.r*Math.sin(this.theta) };

}

// Ejemplos de uso de los objetos

let punto1 = new Punto2DCartesiano(5,4);
console.log(punto1.toString());

let punto2 = new Punto2DPolar(7,30);
console.log(punto2.toString());
console.log("("+punto2.getX+","+punto2.getY+")");

// Observar el uso polimorfico de los métodos distancia e equals
console.log( punto1.distancia(punto2) );
console.log( punto2.distancia(punto1) );
console.log(`punto1.equals(punto2) ? ${punto1.equals(punto2)}`);

// Son iguales punto3 y punto4? Analizar
let punto3 = new Punto2DCartesiano(1,1);
let punto4 = new Punto2DPolar(Math.sqrt(2), 45);
console.log(`punto3.equals(punto4) ? ${punto3.equals(punto4)}`);
