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

/**
 *
 * @author saxss
 */
public class Clientela {
    public Clientela(int numero,String ruta)throws IOException{     //agregar CLIENTE nuevo
        File CLIENTES= new File(ruta+"CLIENTES.txt");        //CREA EL TXT
        BufferedWriter bw;
        FileWriter fw = new FileWriter(CLIENTES.getAbsoluteFile(), true);//HABILITA EL APPEND EN EL TXT
        bw = new BufferedWriter(fw);
        
        
        Scanner lector= new Scanner(System.in);
        System.out.println("1)CC "+"\n"+"2)NIT");
        int i=lector.nextInt();
        String info="";
        if(i==1){ 
            info="CC";}
        else{ info="NIT";}
        
        
        
        lector= new Scanner(System.in);
        System.out.println("NOMBRE DEL CLIENTE: ");      
        String Nombre=lector.nextLine();
        
        
        bw.write(info+"#"+numero+"#"+Nombre+"\n");
        bw.close();
        
        
        //bw.write(codigo+"#"+ventas+"#"+nombre+"#"+descripcion+"#"+costo+"#"+precio+"#"+tipoD+"\n");
}
    
}
        
        
        
        
        /*if(!REGISTROPLATOS.exists()) {      // SI NO EXISTE LO CREA
            bw = new BufferedWriter(new FileWriter(REGISTROPLATOS));
            bw.write(codigo+","+nombre+","+descripcion+","+costo+","+precio+","+tipoD+"\n");
}       else {*/
        
