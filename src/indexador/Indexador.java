/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Usuario
 */
public class Indexador {

    /**
     * @param direction
     * @throws java.lang.Exception
     */
    
    public static void Indexar(String direction) throws Exception{
        
        //aqui se hace la llamadas para hacer la busqueda
        //se crea una instancia de file type(por parametro la direccion)
        
        
        //sino esta indexado, indexa la carpeta
        FileInstance f = FileInstance.getFileInstance(direction);
        f.tfIdfCalculator();
      try {
         // create a new file with an ObjectOutputStream
         FileOutputStream out = new FileOutputStream("test.txt");
         ObjectOutputStream oout = new ObjectOutputStream(out);

         // write something in the file
         oout.writeObject(f);

         // close the stream
         oout.close();

         // create an ObjectInputStream for the file we created before
         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"));
         FileInstance x =(FileInstance) ois.readObject();
         x.getDistance("Apache");
      } catch (Exception ex) {
         ex.printStackTrace();
      }
        f.getDistance("Apache");
        /*f.tf-idf();
        f.cosine();
        f.*/
    }
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        //Indexar("C:/Users/maria/Desktop");
        Indexar("C:\\Users\\Usuario\\Documents");
    }
}
