package ejercicio5;

import ejercicio5.interfaces.EsLiquido;

public class vino extends producto implements EsLiquido{

    private String tipoVino;
    private String envase;
    private int gradosAlcohol;
    private int vol;
    
    public vino(double marca, double precio, String tipoVino, int gradosAlcohol) {
        super(marca, precio);
        this.tipoVino = tipoVino;
        this.gradosAlcohol = gradosAlcohol;
    }

    @Override
    public void setVolumen(int v) {
        this.vol = 330;
    }

    @Override
    public int getVolumen() {
        return 330;
    }

    @Override
    public void setTipoEnvase(String env) {
        this.envase = "Cristal";
    }

    @Override
    public String getTipoEnvase() {
        return "Cristal";
    }

    @Override
    public String toString() {
        return "Vino{marca = " + marca + ", precio = " + precio + "tipoVino = " + tipoVino + ", grados = " + gradosAlcohol + "}";
    }

    

}
