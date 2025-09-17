package ejercicio0;

public class funciones {
    public static void a(int n1, int n2){
        if (n1 > n2) {
            do { 
                System.out.println(n1);
                n1--;
            } while (n1 > n2-1);
        }else{
            do { 
                System.out.println(n2);
                n2--;
            } while (n2 > n1-1);
        }
    }
    public static int b(int n){
        int cont = 0;
        do { 
            if (n % 2 != 0) {
                cont += n;
            }
            n--;
        } while (n > 0);

        return cont;
    }
    public static void c(int x){
        int[] resul = new int[9];
        for (int i = 0; x > 0 ; i++) {
            resul[i] = x%2;
            x /= 2;
        }
        boolean flag = true;
        for (int i = resul.length - 1; i >= 0; i--) {
            if (resul[i] == 1) {
                flag = false;
            }
            if (!flag) { 
               System.out.print(resul[i]); 
            }
            
        }}
}
