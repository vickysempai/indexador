/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;
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
        
        
        //sino esta indexado, indexa la carpeta
        FileInstance f = FileInstance.getFileInstance(direction);
        f.tfIdfCalculator();
        f.getCosineSimilarity("Apache");
        /*f.tf-idf();
        f.cosine();
        f.*/
    }
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Indexar("C:/Users/maria/Desktop");
        //Indexar("C:\\Users\\Usuario\\Documents");
    }
}
