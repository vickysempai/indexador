/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;
import indexador.FileInstance;
/**
 *
 * @author Usuario
 */
public class Indexador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        FileInstance f = new FileInstance();
        f.load("C:\\Users\\Usuario\\Documents\\cita");
        /*FileRead f = new FileRead();
        f.iterate("C:\\Users\\Usuario\\Documents\\cita");
        f.parser();*/
        
    }
    
}
