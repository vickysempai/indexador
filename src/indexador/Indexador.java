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
    
    private FileInstance file= null;
    public void Save(String direction){
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

      } catch (IOException ex) {
      }
    }
    public void Indexar(String direction) throws Exception{
        System.out.println("indexando...");
        String tmpfile = direction;
        File f = new File(tmpfile);
        //if(f.exists() && !f.isDirectory()) { 
        if(f.isDirectory()){
            this.file = new FileInstance(direction);
            file.tfIdfCalculator();
            Save(direction);
            System.out.println("indexado");
            }
        else
            System.out.println("el archivo no existe");
        /*f.tf-idf();

        f.cosine();

        f.

    }}*/}
    
    public String[] Search(String query){
        String[] files = { "", "", "", "", "" };
        if (this.file!=null){
           return this.file.getCosineSimilarity(query);}
        else{
            System.out.println("indexe o cargue un archivo primero");}
        return null;
    } 
    
    public void load(String file) throws FileNotFoundException, IOException, ClassNotFoundException{
        System.out.println("cargando...");
        file=file+".txt";
        File f = new File(file);
        //if(f.exists() && !f.isDirectory()) { 
        if(f.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            this.file =(FileInstance) ois.readObject();
            System.out.println("cargado");
        }
        else
            System.out.println("el archivo no existe");
            
    }
}