/**
 * Bag: Implementación de la bolsa en TypeScript
 * 
 * @author: Jorge Londoño
 */

import assert from "assert";


class Bag<T> implements Iterable<T> {

    private items: Array<T> = [];
    private n: number = 0;

    add(item: T): void { 
        this.items.push(item);
        this.n++;
    }

    isEmpty(): boolean {
        return this.n==0;
    }

    size(): number {
        return this.n;
    }

    [Symbol.iterator]() {
        let pos = 0;
        const items = this.items;

        return {
            next(): IteratorResult<T> {
                if (pos<items.length) {
                    return { value: items[pos++], done: false };
                }
                return { value: null, done: true };
            }
        }
    }

    static factory<T>(): Bag<T> {
        return new Bag<T>();
    }

}


// Pruebas unitarias de Bag
const bolsaStr: Bag<string> = new Bag();
assert.ok(bolsaStr.isEmpty(), "La bolsa debe estar vacia al comienzo");
assert.strictEqual(bolsaStr.size(), 0, "Tamaño inicial debe ser cero");
bolsaStr.add("Hola");
bolsaStr.add("Mundo");
assert.equal(bolsaStr.size(), 2, "Tamaño incorrecto");


// Cliente ejemplo de Bag
const bolsaNum: Bag<number> = new Bag();
bolsaNum.add(1);
bolsaNum.add(2);
bolsaNum.add(3);

for(let x of bolsaNum) {
    console.log(x);
}
