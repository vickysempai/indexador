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
     * @throws java.lang.Exception
     */
    
    public static void Indexar(String direction) throws Exception{
        
        //aqui se hace la llamadas para hacer la busqueda
        //se crea una instancia de file type(por parametro la direccion)
        //
        FileInstance f = FileInstance.getFileInstance(direction);
        /*f.tf-idf();
        f.cosine();
        f.*/
    }
    /*public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Indexar("C:\\Users\\Usuario\\Documents\\cita");
    }*/
}
