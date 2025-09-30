
package ejercicio3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Ordena {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        ArrayList<Telefono> ordenar = new ArrayList<>();
        ordenar.add(new Telefono("Iphone 12 max pro",1259));
        ordenar.add(new Telefono("Aiaomi Mi 10 Pro",999));
        ordenar.add(new Telefono("Huawei P40 Pro+",1399));
        ordenar.add(new Telefono("Samsung Z Flip 5G",1550));
        ordenar.add(new Telefono("Samsung S20",1500));
        ordenar.add(new Telefono("LG V50",899));
        ordenar.add(new Telefono("Xiaomi Mi 10 Pro",100));
        ordenar.add(new Telefono("Huawei P40 Pro+",1399));
        ordenar.add(new Telefono("Samsung Z Flip 5G",1550));
        ordenar.add(new Telefono("Samsung S30",1300));
        ordenar.add(new Telefono("Huawei P50 Pro+",1399));
        ordenar.add(new Telefono("Samsung Z Flip 5G",1550));
        
        Collections.sort(ordenar, new Comparator<Telefono>(){
            public int compare(Telefono t1, Telefono t2){
                return Integer.compare(t1.precio, t2.precio);
            }
        }); 
        
        for(Telefono i : ordenar){System.out.println(i);}
        System.out.println("-----------------------------------");
        
       
        Collections.sort(ordenar);
        
        for(Telefono i : ordenar){System.out.println(i);}
        
        System.out.println("-----------------------------------");
        
        
    }
    
}
