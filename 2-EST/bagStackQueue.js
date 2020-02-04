/*
  Implementacion de las estructuras basicas: Bag, Stack, Queue
  reutilizando las listas de Javascript

  @author: Jorge Londono

  Para ejecutar: node bagStackQueue.js

 */


/**
 * Implementacion del Bag
 * @constructor
 */
function Bag() {
  this.items = [];
  this.add = function(item) { this.items.push(item); }
  this.size = function() { return this.items.length; }
  this.isEmpty = function() { return this.items.length===0; }
}


// Ejemplo de uso del Bag
console.log('\nBag ----------');
let bag = new Bag();
console.log(bag.size());    // 0
console.log(bag.isEmpty()); // true
bag.add(1);
bag.add('Hola');
console.log(bag.size());    // 2
console.log(bag.isEmpty()); // false


/**
 * Implementacion del Stack
 * @constructor
 */
function Stack() {
  this.items = [];
  this.push = function(item) { this.items.push(item); }
  this.pop = function() { return this.items.pop(); }
  this.size = function() { return this.items.length; }
  this.isEmpty = function() { return this.items.length===0; }
}


// Ejemplo de uso del Stack
console.log('\nStack ----------');
let stack = new Stack();
console.log(stack.size());    // 0
console.log(stack.isEmpty()); // true
stack.push(1);
stack.push('Hola');
console.log(stack.size());    // 2
console.log(stack.isEmpty()); // false
console.log(stack.pop());     // 'Hola'
console.log(stack.pop());     // 1
console.log(stack.size());    // 0
console.log(stack.isEmpty()); // true


/**
 * Implementacion del Queue
 * @constructor
 */
function Queue() {
  this.items = [];
  this.enqueue = function(item) { this.items.push(item); }
  this.dequeue = function() { return this.items.shift(); }
  this.size = function() { return this.items.length; }
  this.isEmpty = function() { return this.items.length===0; }
}


// Ejemplo de uso del Queue
console.log('\nQueue ----------');
let q = new Queue();
console.log(q.size());    // 0
console.log(q.isEmpty()); // true
q.enqueue(1);
q.enqueue('Hola');
console.log(q.size());    // 2
console.log(q.isEmpty()); // false
console.log(q.dequeue()); // 1
console.log(q.dequeue()); // 'Hola'
console.log(q.size());    // 0
console.log(q.isEmpty()); // true
