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
}
