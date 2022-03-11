import java.util.Comparator;

class FechaX {

    private int año;
    private byte mes;
    private byte dia;

    public FechaX(int a, int m, int d) {
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

public class FechaComparator implements Comparator<FechaX> {

    @Override
    public int compare(FechaX f1, FechaX f2) {
        if (f1.getAño() != f2.getAño())
            return f1.getAño() - f2.getAño();
        if (f1.getMes() != f2.getMes())
            return f1.getMes() - f2.getMes();
        return f1.getDia() - f2.getDia();
    }

    // Pruebas unitarias del Comparator de Fecha
    public static void main(String[] args) {
        FechaX f1 = new FechaX(2020, 3, 17);
        FechaX f2 = new FechaX(2020, 3, 16);
        FechaX f3 = new FechaX(2020, 4, 17);
        FechaX f4 = new FechaX(2020, 3, 17);

        FechaComparator fc = new FechaComparator();

        assert (fc.compare(f1, f2) > 0);
        assert (fc.compare(f1, f3) < 0);
        assert (fc.compare(f3, f1) > 0);
        assert (fc.compare(f1, f4) == 0);

    }

}
