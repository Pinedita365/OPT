package ejercicio1;

public class ExtraException extends Exception {
    public ExtraException(String mensaje) {
        super("¡Has elegido el día de mi nacimiento!");
    }
}
