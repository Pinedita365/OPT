package ejercicio2;

public class funciones {
    public static int aleatorio(){
        int n = (int)(Math.random()*11);
        return n;
    }
    public static int[] MetodoBurbuja(int[] array){
        int aux;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
                
            }
        }
        return array;
    }
}
