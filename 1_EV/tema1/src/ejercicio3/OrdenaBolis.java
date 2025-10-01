
package ejercicio3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OrdenaBolis {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        ArrayList<Boligrafo> boli = new ArrayList<>();
        
        boli.add(new Boligrafo("Pilot","SuperGrip",1));
        boli.add(new Boligrafo("Pilot","G2",1.3));
        boli.add(new Boligrafo("Bic","Cristal",0.5));
        boli.add(new Boligrafo("Pilot","SuperGrip",1.3));
        
        System.out.println("Comparar el boli 1 con el boli 2");
        
        if (boli.get(0).equals(boli.get(1))) {
            System.out.println("Son iguales");
        }else{
            System.out.println("No son iguales");
        }
        
        System.out.println("Comparar el boli 2 con el boli 4");
        
        if (boli.get(1).equals(boli.get(3))) {
            System.out.println("Son iguales");
        }else{
            System.out.println("No son iguales");
        }
        
        Collections.sort(boli);
        
        // System.out.println(boli);
        
    }
    
}
