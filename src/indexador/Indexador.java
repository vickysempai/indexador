/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

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
public class Indexador {

    /**
     * @throws java.lang.Exception
     */
    FileInstance file= null;
    public void Indexar(String direction) throws Exception{
        this.file = new FileInstance(direction);
        file.tfIdfCalculator();
      try {
         // create a new file with an ObjectOutputStream
         FileOutputStream out = new FileOutputStream(direction+".txt");
         ObjectOutputStream oout = new ObjectOutputStream(out);
         // write something in the file
         oout.writeObject(file);
         // close the stream
         oout.close();
         // create an ObjectInputStream for the file we created before
         /*ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"));

         FileInstance x =(FileInstance) ois.readObject();
         f.getDistance("Apache");*/

      } catch (Exception ex) {

         ex.printStackTrace();

      }

        /*f.tf-idf();

        f.cosine();

        f.

    }}*/}
    public void Search(String query){
        if (this.file!=null){
            this.file.getCosineSimilarity(query);}
        else{
            System.out.println("indexe o cargue un archivo primero");}
        /*f.tf-idf();
        f.cosine();
        f.*/
    } 
    public void load(String file) throws FileNotFoundException, IOException, ClassNotFoundException{
        File f = new File(file);
        //if(f.exists() && !f.isDirectory()) { 
        if(f.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file+".txt"));
            this.file =(FileInstance) ois.readObject();
        }
        else
            System.out.println("el archivo no existe");
    } 
    public static void main(String[] args) throws Exception {
        Indexador x = new Indexador();
        // TODO code application logic here
        //Indexar("C:/Users/maria/Desktop");
        x.Indexar("C:\\Users\\Usuario\\Documents\\pruebitas");
        x.Search("mama");
        x.load("C:\\Users\\Usuario\\Documents\\pruebitas");
    }
}
