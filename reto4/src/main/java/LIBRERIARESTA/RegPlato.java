/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIBRERIARESTA;
import java.io.BufferedReader;
import java.io.FileWriter;      //ESCRIBIR Y CREAR
import java.io.IOException;     //YA CREADO?
import LIBRERIARESTA.Evalua;    //clae de evaluaciones
import LIBRERIARESTA.Clientela;    //claSe CREA CLIENTES NUEVOS
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author saxss
 */
public class RegPlato {
    // CONSTRUCTORES
    public RegPlato (int codigo,String nombre, String descripcion, int costo, int precio, String tipoD, String ruta)throws IOException{     //agregar platillo nuevo
        this.codigo=codigo;
        this.ventas=0;
        this.nombre= nombre;
        this.descripcion=descripcion;
        this.costo=costo;
        this.precio=precio;
        this.tipoDeComida=tipoD;
        this.ruta=ruta;
   
        // envio la info a un txt en la carpeta
        
        
        
        File REGISTROPLATOS = new File(ruta+"REGISTRO.txt");        //CREA EL TXT
        BufferedWriter bw;
        
        FileWriter fw = new FileWriter(REGISTROPLATOS.getAbsoluteFile(), true);//HABILITA EL APPEND EN EL TXT
            bw = new BufferedWriter(fw);
            
            bw.write(codigo+"#"+ventas+"#"+nombre+"#"+descripcion+"#"+costo+"#"+precio+"#"+tipoD+"\n");

        bw.close();
       
    }
   
    
    //ATRIBUTOS
    private int codigo;
    private String nombre;
    private String descripcion;
    private int costo;
    private int precio;
    private String tipoDeComida;
    private int ventas;
    private String ruta;
    
    // METODOS
     public static void ventas(int codigo, String ruta) throws FileNotFoundException, IOException {
        if (codigo==0) return;
        Date fechaActual = new Date();
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat formatoHora = new SimpleDateFormat("HH:mm");
        //System.out.println(formatoFecha.format(fechaActual));
        String l[]=Evalua.platos(ruta, codigo);
        if(l[2]==null){
            System.out.println("CODIGO NO ENCONTRADO INTENTE DE NUEVO O CREE UNO");
            return;}
        else{
                System.out.println(l[2]);
                Scanner lector= new Scanner(System.in);
                System.out.println("#DE UNIDADES VENDIDAS ");
                int V=lector.nextInt();
                
                lector= new Scanner(System.in);
                System.out.println("#DE IDENTIFICACION DEL CLIENTE ");
                int numero=lector.nextInt();
                
                
                String E=Evalua.eva(numero,ruta); //CLIENTE VIEJO? obtiene el tipo de id(cc o nit)
                if (E==null){      //LO CREA
                    Clientela C= new Clientela(numero,ruta);
                     E=Evalua.eva(numero,ruta);     //obtiene el tipo de id(cc o nit)
                }
                
                
                
                File VENTAS = new File(ruta+"VENTAS.txt");        //CREA EL TXT
                BufferedWriter bw;
                FileWriter fw = new FileWriter(VENTAS.getAbsoluteFile(), true);//HABILITA EL APPEND EN EL TXT
                bw = new BufferedWriter(fw);
                bw.write(codigo+"#"+l[2]+"#"+V+"#"+(Integer.parseInt(l[5])*V)+"#"+formatoFecha.format(fechaActual)+"#"+E+"#"+numero+"\n");

                bw.close();         //CIERRA VENTAS.TXT
                
                lector= new Scanner(System.in);
                System.out.println("#DE LA MESA O 0 PARA DOMICILIO");
                int M=lector.nextInt();
                String mesa="";
                if(M==0){
                     mesa="DOMICILIO";
                }
                else{
                    mesa=Integer.toString(M);
                }
        
                File PEDIDOS = new File(ruta+"PEDIDOS.txt");        //CREA EL TXT
                //BufferedWriter bw;
                fw = new FileWriter(PEDIDOS.getAbsoluteFile(), true);//HABILITA EL APPEND EN EL TXT
                bw = new BufferedWriter(fw);
                bw.write(formatoFecha.format(fechaActual)+" "+formatoHora.format(fechaActual)+"#"+mesa+"#"+l[0]+"#"+l[2]+"#"+V+"\n");

                bw.close();     //CIERRA PEDIDOS.TXT
                
                
                
                
            }    
            
        }
        
    }       
 