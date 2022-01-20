
class Contador {

    private id: string;
    private count: number;

    constructor(id: string) {
        this.id = id;
        this.count = 0;
    }

    public incrementar(): void {
        this.count++;
    }

    public getConteo(): number {
        return this.count;
    }

    public getId(): string {
        return this.id;
    }

}


// Codigo cliente demostrativa del ADT Contador
const prueba1 = new Contador('Prueba 1');
const prueba2 = new Contador('Prueba 2');
prueba1.incrementar();
prueba1.incrementar();
prueba2.incrementar();
console.log(`Valor del contador "${prueba1.getId()}" : ${prueba1.getConteo()}`);
console.log(`Valor del contador "${prueba2.getId()}" : ${prueba2.getConteo()}`);

// Pruebas unitarias del ADT Contador
import assert from "assert";
const test = new Contador("Prueba unitaria");
assert.strictEqual(test.getConteo(), 0, "El contador debe ser cero inicialmente");
test.incrementar();
assert.strictEqual(test.getConteo(), 1, "El contador debe valer 1");
assert.strictEqual(test.getId(), "Prueba unitaria", 'El nombre del contador debe ser "Prueba unitaria"')


