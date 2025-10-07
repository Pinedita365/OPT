package ejercicio5;

public enum tipo {
    avena(5),
    maiz(8),
    trigo(12),
    chocolate(15);

    private int valor;

    tipo(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    }


}
