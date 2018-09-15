/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Indexer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Usuario
 */
public class Indexer {

    /**
     * @throws java.lang.Exception
     */
    FileInstance f= new FileInstance();
    public void Index(String direction) throws Exception{
        
        //aqui se hace la llamadas para hacer la busqueda
        //se crea una instancia de file type(por parametro la direccion)
        
        //sino esta indexado, indexa la carpeta
        System.out.println("Leyendo archivos...");
        FileInstance f = new FileInstance(direction);
        System.out.println("Indexando...");
        f.tfIdfCalculator();
        try {
            System.out.println("Grabando en Disco...");
         // create a new file with an ObjectOutputStream
         FileOutputStream out = new FileOutputStream("nana.txt");
         ObjectOutputStream oout = new ObjectOutputStream(out);
         
         // write something in the file
         oout.writeObject(this.f);
         // close the stream

         oout.close();
         
         // create an ObjectInputStream for the file we created before
         /*ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"));
         FileInstance x =(FileInstance) ois.readObject();*/
         
      } catch (Exception ex) {
         ex.printStackTrace();
      }
    }
    
    public void Load(String direction) throws FileNotFoundException, IOException, ClassNotFoundException{
        File file = new java.io.File(direction);
        //file.mkdirs(); // wrong! 
        file.getParentFile().mkdirs(); // correct!
        if (!file.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(direction));
            FileInstance x =(FileInstance) ois.readObject();
            this.f=x;
        }
        
         
    }
    public void Search(String query){
        if (f.getFileInstance()!=null){
            System.out.println("buscando... ");
            f.getCosineSimilarity(query);}
        else
            //avisarle añ usuario que la carpeta no esta indexada
            System.out.println("no hay ninguna carpeta indexada");
    }
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Indexer x = new Indexer();
        x.Index("C:\\Users\\Usuario\\Documents\\pruebitas");
        x.Search("banana");
        //Indexar("C:/Users/maria/Desktop");
    }
}
