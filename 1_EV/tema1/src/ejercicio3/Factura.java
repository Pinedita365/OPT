package ejercicio3;

public class Factura {

    private int ac;
    private double cant;
    private double prec;
    static double cont;
    static int mx;

    public Factura(int ac, double cant, double prec) {
        this.ac = ac;
        this.cant = cant;
        this.prec = prec;
        this.cont += prec*cant;
        if (cont > 600) {
            this.mx++;
        }
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public double getCant() {
        return cant;
    }

    public void setCant(double cant) {
        this.cant = cant;
    }

    public double getPrec() {
        return prec;
    }

    public void setPrec(double prec) {
        this.prec = prec;
    }

    

    @Override
    public String toString() {
        return "";
    }
    public double litros(){
        return getCant();
    }

    public static double getCont() {
        return cont;
    }

    public static void setCont(double cont) {
        Factura.cont = cont;
    }

    public static int getMx() {
        return mx;
    }

    public static void setMx(int mx) {
        Factura.mx = mx;
    }
    
}
