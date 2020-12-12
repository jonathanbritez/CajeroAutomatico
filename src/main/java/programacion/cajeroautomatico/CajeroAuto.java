/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion.cajeroautomatico;

/**
 *
 * @author jonathan
 */
import javax.swing.*;

public class CajeroAuto {

    /**
     * @param args the command line arguments
     */
    public static int saldo = 2000;
    public static int opcion=0;
    public static int contraseña = 1234;
    public static String caja="";
    public static int pregunta;
    public static int operador;
    public static String transferencia;
    public static int transfer;
    
    public static void main(String args[]) {
        // TODO code application logic here
        
        
        
        ImageIcon Banco = new ImageIcon("src/Imagenes/logo.png");
        
        contraseña =Integer.parseInt(JOptionPane.showInputDialog("Introduca su clave: "));
        
        
        if(contraseña == 1234){
         
            opcion();
            
            while(opcion !=5){   
            
                pregunta = JOptionPane.showConfirmDialog(null,"Desea realizar Otra operacion ?","Banco",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null);
              
                if(JOptionPane.OK_OPTION == pregunta){
                
                    opcion();
                
                 }else{
                
                    break;
                }//cierre del if dentro del while
                
           }//cierre del while
        }else{
         
            JOptionPane.showMessageDialog(null,"Contraseña no valida","Banco",JOptionPane.INFORMATION_MESSAGE, Banco);
        
        }//cierre del primer if
    
    }//cierre de la funcion principal
    
    public static void opcion(){
        
        opcion = Integer.parseInt(JOptionPane.showInputDialog("1_Saldo          2_Transferir \n\n3_Retirar        4_Cambiar Clave\n\n"));
             
                switch(opcion){
                
                    case 1: 
                        caja = "Saldo";
                        saldo(caja);
                                           
                    break;
                    case 2: 
                        caja = "Transferir";
                        transferir(caja);
                        //caja = transferir(caja);
                    break;
                    case 3: 
                        caja = "Retirar";
                        retirar();
                    break;
                    case 4: 
                        caja = "Cambiar Clave";
                        
                        cambiarClave();
                    break;
                    default:
                    
                 }
        
    }
    
    public static void saldo(String c){
        
      if(saldo != saldo | saldo == saldo){  
        c= "               Banco### \n\n\nFecha          Hora          Caja \n"
                + "12/12/12      12:00         22\n\n\n Dirección: ##### \n\n\n"
                + "Su dinero disponible: $" + saldo + "\n\n\n"; 
        pregunta = JOptionPane.showConfirmDialog(null,c + "Desea Imprimir el Ticket? ","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null);
              
                if(JOptionPane.OK_OPTION == pregunta){
                
                    System.out.println(c);
                
                 }else{
                
                    System.out.println("");
                }
     
      }
     
        //JOptionPane.showMessageDialog(null,c,null,JOptionPane.INFORMATION_MESSAGE, null);
        
        
        
    }
    public static void transferir(String c){
    
        String cbu;
        
        cbu = JOptionPane.showInputDialog("introduce tu cbu: ");
        
        if(cbu.length() < 16 | cbu.length()>16){
        
                System.out.println("No es posible realizar una transferencia");
        }else{
        
             transferencia = JOptionPane.showInputDialog("Cuanto deseas transferir ? ");
             transfer = Integer.parseInt(transferencia);
             
            if(transfer > saldo ){
            
            
                System.out.println("No es posible realizar la operacion ");
        
        
            }else{
        
                saldo = saldo - Integer.parseInt(transferencia);
                System.out.println("Su saldo actual es: " + operador);
                
                 c= "               Banco### \n\n\nFecha          Hora          Caja \n"
                + "12/12/12      12:00         22\n\n\n Dirección: ##### \n\n\n"
                + "Se ha transferido al CBU: " + cbu +"\n\n\n" +" $ " +transfer + "\n\n\n"
                + "Su saldo disponible es: $" + saldo + "\n\n\n"; 
        
        pregunta = JOptionPane.showConfirmDialog(null,c + "Desea Imprimir el Ticket? ","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null);
              
                if(JOptionPane.OK_OPTION == pregunta){
                
                    System.out.println(c);
                
                 }else{
                
                    System.out.println("");
                }
    
                
                
            }//fin del if secundario
        
        } // fin del if principal
    
        
        
    }
    
    public static void retirar(){
        String[] monto = {"$200","$500","$1000","$2000","Ingresar_otra_cantidad"};
        String[] $200={"200","250"};
        String[] $500={"500"};
        String[] $1000={"1000"};
        String[] $2000={"2000"};
        String[] Ingresar_otra_cantidad={"Ingresar otro monto"};
        
        Object opcion = JOptionPane.showInputDialog(null, "Elija el monto a retirar","retiro", JOptionPane.QUESTION_MESSAGE,null, monto, monto[0]);
        
        combo($200,$500,$1000,$2000,Ingresar_otra_cantidad,opcion);
    
    
    }
     private static void combo(String[] $200,String[] $500,String[] $1000,String[] $2000,String[] Ingresar_otra_cantidad,Object opcion){
         
            if (opcion == "$200"){
                //Object fordmodelo = JOptionPane.showInputDialog(null,"Los modelos para la marca " + opcion ,"Modelos de  Autos",JOptionPane.QUESTION_MESSAGE,null,$200,$200[0]);
                
                saldo = saldo - 200;
                String c= "               Banco### \n\n\nFecha          Hora          Caja \n"
                + "12/12/12      12:00         22\n\n\n Dirección: ##### \n\n\n"
                + "Se ha retirado: " + opcion +"\n\n\n"+"Su saldo disponible es: $" + saldo + "\n\n\n";
                
                pregunta = JOptionPane.showConfirmDialog(null,c + "Desea Imprimir el Ticket? ","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null);
              
                if(JOptionPane.OK_OPTION == pregunta){
                
                    System.out.println(c);
                
                 }else{
                
                    System.out.println("");
                }
                
                System.out.println("Has retirado " + opcion + " y te quedan: " + saldo);
            
            } else if (opcion == "$500"){
               
                saldo = saldo - 500;
                String c= "               Banco### \n\n\nFecha          Hora          Caja \n"
                + "12/12/12      12:00         22\n\n\n Dirección: ##### \n\n\n"
                + "Se ha retirado: " + opcion +"\n\n\n"+"Su saldo disponible es: $" + saldo + "\n\n\n";
                
                pregunta = JOptionPane.showConfirmDialog(null,c + "Desea Imprimir el Ticket? ","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null);
              
                if(JOptionPane.OK_OPTION == pregunta){
                
                    System.out.println(c);
                
                 }else{
                
                    System.out.println("");
                }
                System.out.println("Has retirado " + opcion + " y te quedan: " + saldo);
            
            } else if (opcion == "$1000"){
                
                saldo = saldo - 1000;
                String c= "               Banco### \n\n\nFecha          Hora          Caja \n"
                + "12/12/12      12:00         22\n\n\n Dirección: ##### \n\n\n"
                + "Se ha retirado: " + opcion +"\n\n\n"+"Su saldo disponible es: $" + saldo + "\n\n\n";
                
                pregunta = JOptionPane.showConfirmDialog(null,c + "Desea Imprimir el Ticket? ","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null);
              
                if(JOptionPane.OK_OPTION == pregunta){
                
                    System.out.println(c);
                
                 }else{
                
                    System.out.println("");
                }
                System.out.println("Has retirado " + opcion + " y te quedan: " + saldo);
            
            }else if (opcion == "$2000"){
                
                saldo = saldo - 2000;
                String c= "               Banco### \n\n\nFecha          Hora          Caja \n"
                + "12/12/12      12:00         22\n\n\n Dirección: ##### \n\n\n"
                + "Se ha retirado: " + opcion +"\n\n\n"+"Su saldo disponible es: $" + saldo + "\n\n\n";
                
                pregunta = JOptionPane.showConfirmDialog(null,c + "Desea Imprimir el Ticket? ","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null);
              
                if(JOptionPane.OK_OPTION == pregunta){
                
                    System.out.println(c);
                
                 }else{
                
                    System.out.println("");
                }
                System.out.println("Has retirado " + opcion + " y te quedan: " + saldo);
            }else if (opcion == "Ingresar_otra_cantidad" ){
                
                int cantidad =0;
                cantidad = Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese la cantidad: "));
                
                if(cantidad < saldo){
            
                 saldo = saldo - cantidad;
                 System.out.println("Has retirado " + cantidad + " y te quedan: " + saldo);
                 
                 String c= "               Banco### \n\n\nFecha          Hora          Caja \n"
                + "12/12/12      12:00         22\n\n\n Dirección: ##### \n\n\n"
                + "Se ha retirado: " + cantidad +"\n\n\n"+"Su saldo disponible es: $" + saldo + "\n\n\n";
                
                pregunta = JOptionPane.showConfirmDialog(null,c + "Desea Imprimir el Ticket? ","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null);
              
                if(JOptionPane.OK_OPTION == pregunta){
                
                    System.out.println(c);
                
                 }else{
                
                    System.out.println("");
                }
                 }else{
        
                    System.out.println("No se puede retirar esa cantidad");
                }
                
               }
            }
 
    public static void cambiarClave(){
        boolean cam = true;
        int cambio =0;
        String[] cambiar = {"HOME BANKING", "Clave telefonica" ,"Cajero"};
        
        Object opcion = JOptionPane.showInputDialog(null, "Elija el monto a retirar","retiro", JOptionPane.QUESTION_MESSAGE,null, cambiar, cambiar[2]);
        
        if(opcion == "HOME BANKING"){
            
            cambio = Integer.parseInt(JOptionPane.showInputDialog("Introdusca su nueva contraseña para Home Banking: "));
            
            String c= "               Banco### \n\n\nFecha          Hora          Caja \n"
                    + "12/12/12      12:00         22\n\n\n Dirección: ##### \n\n\n"
                    + "Su nueva contraseña es: " + cambio + "\n\n\n";
                
                    pregunta = JOptionPane.showConfirmDialog(null,c + "Desea Imprimir el Ticket? ","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null);
              
                    if(JOptionPane.OK_OPTION == pregunta){
                
                        System.out.println(c);
                
                    }else{
                
                        System.out.println("");
                    }
                    
        
        }else if(opcion == "Clave telefonica"){
            
            cambio = Integer.parseInt(JOptionPane.showInputDialog("Introdusca su nueva contraseña para la Clave telefonoca: "));
        
            String c= "               Banco### \n\n\nFecha          Hora          Caja \n"
                    + "12/12/12      12:00         22\n\n\n Dirección: ##### \n\n\n"
                    + "Su nueva contraseña es: " + cambio + "\n\n\n";
                
                    pregunta = JOptionPane.showConfirmDialog(null,c + "Desea Imprimir el Ticket? ","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null);
              
                    if(JOptionPane.OK_OPTION == pregunta){
                
                        System.out.println(c);
                
                    }else{
                
                        System.out.println("");
                    }
                    
        }else if(opcion == "Cajero"){
             
            while(cam = true){  
                cambio = Integer.parseInt(JOptionPane.showInputDialog("Introdusca su nueva contraseña para la Clave Cajero: "));
                if(cambio == contraseña){
        
                    JOptionPane.showMessageDialog(null, "No puede introduccir la misma contraseña debe ser diferente a la anterior ");
                    System.out.println("No puede introduccir la misma contraseña debe ser diferente a la anterior");
        
                 }else{
        
                    System.out.println("se ha cambiado correctament su contraseña " + "Su nueva contraseña es " + cambio);
                    
                    String c= "               Banco### \n\n\nFecha          Hora          Caja \n"
                    + "12/12/12      12:00         22\n\n\n Dirección: ##### \n\n\n"
                    + "se ha cambiado su contraseña actual " + contraseña +"\n\n\n"+"Su nueva contraseña es: " + cambio + "\n\n\n";
                
                    pregunta = JOptionPane.showConfirmDialog(null,c + "Desea Imprimir el Ticket? ","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null);
              
                    if(JOptionPane.OK_OPTION == pregunta){
                
                        System.out.println(c);
                
                    }else{
                
                        System.out.println("");
                    }
                    
                    
                    
                    break;
        
                }
            
            
        }
        
        
        
        
        
        
        
            
            
        
        }
    
    }
  
}

