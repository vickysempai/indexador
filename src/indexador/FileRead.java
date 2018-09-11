/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Usuario
 */
public class FileRead {
    List<BaseFileType> documents;
    /*private static final Map<String, Runnable> myMap = createMap();
    private static Map<String, Runnable> createMap()
    {
        Map<String,FileInstance> myMap = new HashMap<String,Runnable>();
        myMap.put("txt",(FileInstance file) -> TXT.class.);
        return myMap;
    }
    
    
        
        Iterator<String> it = myMap.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            System.out.println("Clave: " + key + " -> Valor: " + myMap.get(key));
    */

    FileRead() {
        this.documents = new ArrayList<BaseFileType>();
    }
    void parser(){
    documents.forEach(s -> {
        try {
            s.parserFile();
            s.leer();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    }
    void iterate(String direction) throws Exception {

        
    File root = new File(direction);
    
    String[] extensions = { "xml", "html", "txt", "json" , "csv"};
    boolean recursive = true;

    Collection files = FileUtils.listFiles(root, extensions, recursive);

    for (Iterator iterator = files.iterator(); iterator.hasNext();) {
      File file = (File) iterator.next();
      
      String extension = FilenameUtils.getExtension(file.getAbsolutePath());
      
      BaseFileType newFile = FileFactory.getFile(file,extension);
      documents.add(newFile);
      System.out.println("FileInstance = " + file.getAbsolutePath());
    }
  }
}