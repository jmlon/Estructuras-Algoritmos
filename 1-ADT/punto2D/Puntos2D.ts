/**
 * ADT Punto2D con multiples implementaciones
 * 
 * interface Punto2D       : Define el API del ADT
 * class Punto2DCartesiano : Implementación en coordenadas cartesianas
 * class Punto2DPolar      : Implementación utilizando coordenadas polares
 * 
 * @author: Jorge Londoño
 */


interface Punto2D {
    getX(): number;
    getY(): number;
    distancia(q: Punto2D): number;
    equals(q: Punto2D): boolean;
}


class Punto2DCartesiano implements Punto2D {

    private x: number;
    private y: number;

    constructor(x: number, y:number) {
        this.x = x;
        this.y = y;
    }

    public getX(): number {
        return this.x;
    }
    
    public getY(): number {
        return this.y;
    }

    public distancia(q: Punto2D): number {
        return Math.sqrt( (this.x-q.getX())*(this.x-q.getX()) + (this.y-q.getY())*(this.y-q.getY()) );
    }
    
    public equals(q: Punto2D): boolean {
        return this.distancia(q)<1E-8;
    }

    public toString(): string {
        return `(${this.x},${this.y})`;
    }

}


class Punto2DPolar implements Punto2D {

    private mag: number;
    private theta: number;

    constructor(mag: number, theta: number) {
        this.mag = mag;
        this.theta = theta;
    }

    public getX(): number {
        return this.mag*Math.cos(this.theta);
    }
    
    public getY(): number {
        return this.mag*Math.sin(this.theta);
    }

    public distancia(q: Punto2D): number {
        return Math.sqrt( (this.getX()-q.getX())*(this.getX()-q.getX()) + (this.getY()-q.getY())*(this.getY()-q.getY()) );
    }

    public equals(q: Punto2D): boolean {
        return this.distancia(q)<1E-8;
    }

    public toString(): string {
        return `mag=${this.mag}, theta=${this.theta}`;
    }


}


// Algunos ejemplos y pruebas unitarias

import assert from "assert";

// Puntos en coordenadas cartesianas
let c0 = new Punto2DCartesiano(0,0)
let c1 = new Punto2DCartesiano(3,4);
let c2 = new Punto2DCartesiano(1,1);
assert.deepStrictEqual(c0.distancia(c0), 0, "La distancia del origen al origen debe ser cero");
assert.deepStrictEqual(c1.distancia(c0), 5.0, "La distancia de (3,4) al origen debe ser 5.0");

// Los mismos puntos en coordenadas polares
let p0 = new Punto2DPolar(0,0);
let p1 = new Punto2DPolar(5.0,Math.atan2(4,3));
let p2 = new Punto2DPolar(Math.sqrt(2),45.0*Math.PI/180.0);
assert.deepStrictEqual(p0.distancia(p0), 0, "La distancia del origen al origen debe ser cero");
assert.deepStrictEqual(p1.distancia(p0), 5, "La distancia de p1 al origen debe ser 5.0");

// Comprobar la igualdad entre Punto2D
assert( c0.equals(p0), "El origen debe ser igual" );
assert( c1.equals(p1), "c1 y p2 deben ser iguales" );
assert( p2.equals(c2), "p2 y c2 deben ser iguales" );

// Convertir a representación como string
console.log(`c1 = ${c1.toString()}`);
console.log(`c2 = ${c2.toString()}`);
console.log(`p1 = ${p1.toString()}`);
console.log(`p2 = ${p2.toString()}`);