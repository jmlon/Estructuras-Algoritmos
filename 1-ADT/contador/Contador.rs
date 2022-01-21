// Para compilar:
// rustc Contador.rs


pub struct Contador {
    id : String,
    conteo : u64
}


impl Contador {

    fn new(nombre: &str) -> Contador {
        return Contador {
            id : nombre.to_string(),
            conteo : 0
        }
    }

    fn to_string(self: &Contador) -> String {
        format!("ID: {}, valor: {}", self.id, self.conteo)
    }

    fn incrementar(&mut self) {
        self.conteo += 1;
    }

}



fn main() {
    let mut c1 = Contador::new("Contador1");
    println!("{}", c1.to_string());
    assert_eq!(c1.conteo, 0);
    c1.incrementar();
    c1.incrementar();
    println!("{}", c1.to_string());
    assert_eq!(c1.conteo, 2);
}