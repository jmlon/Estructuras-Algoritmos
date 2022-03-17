// Sorting arrays

// Using the native comparator 
names = [ 'Zapata', 'Alvarez', 'Lopez' ];
names.sort();
console.log(names);


// Defining a compare function to compare instances
class Fecha {
    constructor(anno, mes, dia) {
        this.anno = anno;
        this.mes = mes;
        this.dia = dia;
    }
}
function compararFechas(a, b) {
    if (a.anno!==b.anno) return a.anno-b.anno;
    if (a.mes!==b.mes) return a.mes-b.mes;
    if (a.dia!==b.dia) return a.dia-b.dia;
}

f1 = new Fecha(2022,3,15);
f2 = new Fecha(2022,4,15);
f3 = new Fecha(2021,3,10);
f4 = new Fecha(2021,3,2);
fechas = [ f1, f2, f3, f4 ];
fechas.sort(compararFechas);
console.log(fechas);
