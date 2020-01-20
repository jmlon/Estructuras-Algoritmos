/*
  Implementacion del ADT Contador

  @author: Jorge Londono

  Para ejecutar: node contador.js

 */

function Contador(id) {
  this.conteo = 0;
  this.id = id;
  this.incrementar = function() { this.conteo++; };
  this.getConteo = function() { return this.conteo; };
  this.getId = function() { return this.id; };
}

// Ejemplos de uso
let c = new Contador('Eventos');
c.incrementar();
c.incrementar();
console.log(`El contador ${c.id} tiene un valor de ${c.conteo}`);
