
package Reto4;

import LIBRERIARESTA.Mesa;
import java.util.Scanner;
import LIBRERIARESTA.RegPlato;
import java.io.File;
import LIBRERIARESTA.Mostrar;




public class Reto4 {

    
    public static void main(String[] args) {
        //System.out.println (new File (".").getAbsolutePath ());     //DIRECCION DONDE QUEDARA EL TXT
        String ruta=new File (".").getAbsolutePath ();  //DIRECCION DONDE QUEDARA EL TXT
        ruta = ruta.substring(0, ruta.length()-1);
        
       //String[] n= new String[3];
       //System.out.println(n[2]); 
       while (true){
        // TODO code application logic here
        System.out.println("\n MENU PRINCIPAL"
                + "\n"
                + "1) REGISTRAR PLATOS \n"
                + "2) VENTAS \n"
                + "3) REGISTRAR MESAS \n");
        Scanner lector= new Scanner(System.in);
        int l=lector.nextInt();
        //Integer b = new Integer(l);
        //System.out.println(b);
        
        
        
        
        
        
        if(l==1){
            System.out.println("1) Ver \n2) Agregar");
            lector=new Scanner(System.in);
            byte op=lector.nextByte();
            if(op==2){
            
            lector= new Scanner(System.in);
            System.out.println("Codigo: ");
            int codigo=lector.nextInt();
            
            lector= new Scanner(System.in);
            System.out.println("Nombre: ");
            String nombre= lector.nextLine();
            
            lector= new Scanner(System.in);
            System.out.println("Descripcion: ");
            String Descripcion=lector.nextLine();
            
            lector= new Scanner(System.in);
            System.out.println("Costo: ");
            int Costo=lector.nextInt();
            
            lector= new Scanner(System.in);
            System.out.println("Precio: ");
            int Precio=lector.nextInt();
            
            lector= new Scanner(System.in);
            System.out.println("Tipo De Comida: ");
            String TipoDeComida=lector.nextLine();
            
            //System.out.println(codigo+" "+nombre+" "+Costo);
            RegPlato N=new RegPlato(codigo,nombre,Descripcion,Costo,Precio,TipoDeComida,ruta);
            }
            
            if (op==1){
                Mostrar.plato(ruta);
            }
            
        }
        
        if(l==2){
            System.out.println("1) Ver \n2) Agregar");
            lector=new Scanner(System.in);
            byte op=lector.nextByte();
            if(op==2){

            int Codigo=0;
            do{
            lector= new Scanner(System.in);
            System.out.println("Codigo:             (o ingrese 0 para finalizar)");
            Codigo=lector.nextInt();
            RegPlato.ventas(Codigo, ruta);}
            //REGPLATOS N= new REGPLATOS(Codigo,ruta);}
            while (Codigo!= 0);}
            
            if (op==1){
                Mostrar.pedidos(ruta);
            }
            
            
            
        }
        if (l==3){
            System.out.println("1) Ver \n2) Agregar");
            lector=new Scanner(System.in);
            byte op=lector.nextByte();
            if(op==2){
            int N=1;
            do{
                //MESAS N=new MESAS(ruta);
                N= Mesa.mesa(ruta);
            }
            while(N!=-9);
        }
            if(op==1){
                Mostrar.mesa(ruta);
            }
        }
        
        if(l<1 || l>3){
            break;
        }
    }

    } 
    
}
