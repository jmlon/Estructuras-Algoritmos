
trait Punto2D {
    fn get_x(&self) -> f64;
    fn get_y(&self) -> f64;
    fn distancia(&self, p: &dyn Punto2D) -> f64;
    fn to_string(&self) -> String;
}

struct Punto2DCartesiano {
    x: f64,
    y: f64
}

struct Punto2DPolar {
    radio: f64,
    theta: f64
}

impl Punto2D for Punto2DCartesiano {
    fn get_x(&self) -> f64 {
        self.x
    }
    fn get_y(&self) -> f64 {
        self.y
    }
    fn distancia(&self, p: &dyn Punto2D) -> f64 {
        ((self.x-p.get_x())*(self.x-p.get_x()) + (self.y-p.get_y())*(self.y-p.get_y())).sqrt()
    }
    fn to_string(&self) -> String {
        format!("Punto cartesiano: ({},{})", self.x, self.y)
    }
}


impl Punto2D for Punto2DPolar {
    fn get_x(&self) -> f64 {
        self.radio*self.theta.cos()
    }
    fn get_y(&self) -> f64 {
        self.radio*self.theta.sin()
    }
    fn distancia(&self, p: &dyn Punto2D) -> f64 {
        ((self.get_x()-p.get_x())*(self.get_x()-p.get_x()) + (self.get_y()-p.get_y())*(self.get_y()-p.get_y())).sqrt()
    }
    fn to_string(&self) -> String {
        format!("Punto polar: radio={}, angulo={})", self.radio, self.theta)
    }
}


impl Punto2DCartesiano {
    fn new(x: f64, y: f64) -> Punto2DCartesiano {
        return Punto2DCartesiano{ x: x, y: y }
    }
}

impl Punto2DPolar {
    fn new(r: f64, t: f64) -> Punto2DPolar {
        return Punto2DPolar{ radio: r, theta: t }
    }
}


fn main() {
    let a = Punto2DCartesiano::new(5.0, 6.0);
    println!("Punto a: {}", a.to_string());

    let b = Punto2DPolar::new(1.0, std::f64::consts::PI/4.0);
    println!("Punto b: {}", b.to_string());

    let distancia = a.distancia(&b);
    println!("Distancia entre a y b: {}", distancia);

}