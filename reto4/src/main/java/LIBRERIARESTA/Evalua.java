/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIBRERIARESTA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author saxss
 */
public class Evalua {
    
    //METODOS
     public static String eva(int numero, String ruta) throws FileNotFoundException, IOException {
        
        
       
        String cadena;
        FileReader f = new FileReader(ruta+"CLIENTES.TXT");
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            String[] l=cadena.split("#");
            if (Integer.parseInt(l[1])==numero){
                return l[0];
                
            }
        }
        return null;
     }
     
     public static boolean mesa(String ruta,int numero)throws FileNotFoundException, IOException{
        String cadena;
        FileReader f = new FileReader(ruta+"MESAS.TXT");
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            String[] l=cadena.split("#");
            if (Integer.parseInt(l[0])==numero){
                return true;
                
            }
        }
        return false;
         
     }
     public static String[] platos(String ruta, int codigo)throws FileNotFoundException, IOException{
        String cadena;
        FileReader f = new FileReader(ruta+"REGISTRO.TXT");
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            String[] l=cadena.split("#");
            if (Integer.parseInt(l[0])==codigo){
                return l;
            }
            
     }
        String[] n= new String[3];
        return n;
    
}
}
