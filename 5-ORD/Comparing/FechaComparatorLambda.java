
import java.util.Comparator;

class FechaY {

    private int año;
    private byte mes;
    private byte dia;

    public FechaY(int a, int m, int d) {
        año = a;
        mes = (byte) m;
        dia = (byte) d;
    }

    public int getAño() {
        return año;
    }

    public byte getMes() {
        return mes;
    }

    public byte getDia() {
        return dia;
    }

}

public class FechaComparatorLambda {

    static FechaY f1 = new FechaY(2020, 3, 17);
    static FechaY f2 = new FechaY(2020, 3, 16);
    static FechaY f3 = new FechaY(2020, 4, 17);
    static FechaY f4 = new FechaY(2020, 3, 17);

    // Comparator como una clase interna anonima
    private static Comparator<FechaY> comparator = new Comparator<>() {
        @Override
        public int compare(FechaY f1, FechaY f2) {
            if (f1.getAño() != f2.getAño())
                return f1.getAño() - f2.getAño();
            if (f1.getMes() != f2.getMes())
                return f1.getMes() - f2.getMes();
            return f1.getDia() - f2.getDia();
        }
    };

    public static void demoClaseInternaAnonima() {
        assert (comparator.compare(f1, f2) > 0);
        assert (comparator.compare(f1, f3) < 0);
        assert (comparator.compare(f3, f1) > 0);
        assert (comparator.compare(f1, f4) == 0);
    }

    // Info sobre Interfaces Funcionales:
    // https://www.geeksforgeeks.org/functional-interfaces-java/
    public static void demoFunctionalInterface() {
        // Crear una funcion lambda
        Comparator<FechaY> fi = (fx, fy) -> {
            if (fx.getAño() != fy.getAño())
                return fx.getAño() - fy.getAño();
            if (fx.getMes() != fy.getMes())
                return fx.getMes() - fy.getMes();
            return fx.getDia() - fy.getDia();
        };
        assert (fi.compare(f1, f2) > 0);
        assert (fi.compare(f1, f3) < 0);
        assert (fi.compare(f3, f1) > 0);
        assert (fi.compare(f1, f4) == 0);
    }

    // Pruebas unitarias del Comparator de Fecha
    public static void main(String[] args) {
        demoClaseInternaAnonima();
        demoFunctionalInterface();
    }

}


//
