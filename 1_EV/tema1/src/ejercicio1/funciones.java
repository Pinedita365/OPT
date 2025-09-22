package ejercicio1;

public class funciones {
    public static String a(String c1, String c2){
        String cadfin = "";
        String[] str2 = c2.replace(" ", "").split("");
        for (int i = 0; i < str2.length; i++) {
            if (c1.contains(str2[i]) == false) {
                cadfin += str2[i];
            }
        }
        

        return cadfin;
    }
    public static int PasarDias(String date) throws NumberFormatException, ExtraException{
        String[] partes = date.split("/");

        if (partes.length != 3) {
            throw new NumberFormatException("Formato incorrecto. La fecha debe ser dd/MM/yyyy. ");
        }

        int d = Integer.parseInt(partes[0]);
        int m = Integer.parseInt(partes[1]);
        int y = Integer.parseInt(partes[2]);

        if (d > 30 || d < 1 || m < 1 || m > 12 || y < 1) {
            throw new NumberFormatException("Formato incorrecto. La fecha debe ser dd/MM/yyyy. ");
        }

        if (d == 22 && m == 1 && y == 2006) {
        throw new ExtraException("Excepcion propia lanzada");
        }

        return (y * 365) + (m * 30) + d;

    }
    public static int DifDate(String f1, String f2) throws NumberFormatException, ExtraException {
    int dias1 = PasarDias(f1);
    int dias2 = PasarDias(f2);

    return Math.abs(dias1 - dias2); 
    
}

}
