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
    
    public static void Indexar() throws Exception{
        
        //aqui se hace la llamadas para hacer la busqueda
        //se crea una instancia de file type(por parametro la direccion)
        //se aplica el algoritmotf-idf aqui???
        //
        FileInstance f = new FileInstance();
        f.load("C:\\Users\\Usuario\\Documents\\cita");
        /*f.tf-idf();
        f.cosine();
        f.*/
    }
    
}
