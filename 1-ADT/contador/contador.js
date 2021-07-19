/*
  Implementacion del ADT Contador

  @author: Jorge Londono

  Para ejecutar: node contador.js

 */

/*
    Esta forma de importar modulos require ES6
    Se debe definir un package.json que contenga la especificacion: "type": "module"
*/
import assert from 'assert';


function Contador(id) {
    this.conteo = 0;
    this.id = id;
    this.incrementar = function() { this.conteo++; };
    this.getConteo = function() { return this.conteo; };
    this.getId = function() { return this.id; };
}


// Ejemplos de uso
let c = new Contador('Eventos');
assert.strictEqual(c.conteo, 0, 'El conteo inicial debe ser cero');
c.incrementar();
c.incrementar();
assert.strictEqual(c.conteo, 2, 'El conteo inicial debe ser 2');
assert.strictEqual(c.id, 'Eventos');
console.log(`El contador ${c.id} tiene un valor de ${c.conteo}`);
