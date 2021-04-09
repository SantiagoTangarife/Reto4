/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIBRERIARESTA;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import LIBRERIARESTA.Evalua;

/**
 *
 * @author saxss
 */
public class Mesa {
    public static int mesa(String ruta)throws IOException{
        File mesas= new File(ruta+"MESAS.txt");        //CREA EL TXT
        BufferedWriter bw;
        FileWriter fw = new FileWriter(mesas.getAbsoluteFile(), true);//HABILITA EL APPEND EN EL TXT
        bw = new BufferedWriter(fw);
         System.out.println("\n"+"\n");
        Scanner lector= new Scanner(System.in);
        System.out.println("#DE LA MESA ó 0 PARA SALIR");
        int N=lector.nextInt();
        if (N==0){
            return (-9);
        }
        boolean a=Evalua.mesa(ruta, N);         //EXISTE?
        if (a==true){
            System.out.println("LA MESA YA EXISTE");
            return 0;
        }
        
        lector= new Scanner(System.in);
        System.out.println("CAPACIDAD DE LA MESA");
        int C=lector.nextInt();
        
        lector= new Scanner(System.in);
        System.out.println("DESCRIPCION DE LA MESA");
        String D=lector.nextLine();
        
        bw.write(N+"#"+C+"#"+D+"\n");
        bw.close();
        return 0;
        
    }
    
    
}
