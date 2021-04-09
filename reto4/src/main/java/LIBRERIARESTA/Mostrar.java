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
public class Mostrar {
    public static void plato(String ruta)throws FileNotFoundException, IOException{
        String cadena;
        FileReader f = new FileReader(ruta+"REGISTRO.TXT");
        BufferedReader b = new BufferedReader(f);
        System.out.println("Codigo \t"+"Nombre \t"+"\t"+"\t"+"Costo \t"+"Precio \t"+"Tipo de comida \t"+"Descripcion \t");
        while((cadena = b.readLine())!=null) {
            String[] l=cadena.split("#");
            String space=l[2];
            while(space.length()<18)
                    space+=" ";
            String c=l[6];
            while(c.length()<8)
                    c+=" ";
            System.out.println(l[0]+"\t"+space+"\t"+l[4]+"\t"+l[5]+"\t"+c+"\t"+l[3]);
    }
}
    
    public static void pedidos(String ruta)throws FileNotFoundException, IOException{
        String cadena;
        FileReader f = new FileReader(ruta+"PEDIDOS.TXT");
        BufferedReader b = new BufferedReader(f);
        System.out.println("Codigo \t"+"Nombre \t"+"\t"+"    "+"Cantidad \t"+"Mesa \t"+"\t"+"Fecha");
        int cantidad=0, dias=0;
        String fecha="";
        while((cadena = b.readLine())!=null) {
            String[] l=cadena.split("#");
            String space=l[3];
            while(space.length()<18)
                    space+=" ";
            String c=l[1];
            while(c.length()<9)
                    c+=" ";
            System.out.println(l[2]+"\t"+space+"\t"+l[4]+"\t"+c+"\t"+l[0]);
            String[] fec=l[0].split(" ");           //fecha y hora
            //fe[0];            //solo Fecha
            //System.out.println();
            if  (fecha.equals(fec[0])){
            }
            else{
                dias+=1;
                fecha=fec[0];
            }
            cantidad+=Integer.parseInt(l[4]);
    }
        float promedio=(float)cantidad/dias;
        System.out.println("\n En promedio se venden "+(promedio)+" platillos diarios.");
}
    
    public static void mesa(String ruta)throws FileNotFoundException, IOException{
        String cadena;
        FileReader f = new FileReader(ruta+"MESAS.TXT");
        BufferedReader b = new BufferedReader(f);
        System.out.println("#De Mesa \t"+"Capacidad max \t"+"Descripcion");
        while((cadena = b.readLine())!=null) {
            String[] l=cadena.split("#");
            System.out.println(l[0]+"\t"+"\t"+l[1]+" personas"+"\t"+l[2]);
        
    }
    }
}
