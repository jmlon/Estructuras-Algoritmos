public class FechaComparable implements Comparable<FechaComparable> {

    private int año;
    private byte mes;
    private byte dia;

    public FechaComparable(int a, int m, int d) {
        año = a;
        mes = (byte) m;
        dia = (byte) d;
    }

    @Override
    public int compareTo(FechaComparable f) {
        if (año != f.año)
            return año - f.año;
        if (mes != f.mes)
            return mes - f.mes;
        if (dia != f.dia)
            return dia - f.dia;
        return 0;
    }

    // Pruebas unitarias de la implementacion de Comparable
    public static void main(String[] args) {
        FechaComparable f1 = new FechaComparable(2020, 3, 17);
        FechaComparable f2 = new FechaComparable(2020, 3, 16);
        FechaComparable f3 = new FechaComparable(2020, 4, 17);
        FechaComparable f4 = new FechaComparable(2020, 3, 17);

        assert (f1.compareTo(f2) > 0);
        assert (f1.compareTo(f3) < 0);
        assert (f3.compareTo(f1) > 0);
        assert (f1.compareTo(f4) == 0);

    }

}
