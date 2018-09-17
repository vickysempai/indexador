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
import java.util.List;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Usuario
 */
public class FileReader {
    public static List<BaseFileType> getFiles(String direction,List documents) throws Exception{
    iterate(direction,documents);
    return documents;
    }
    
    public static void iterate(String direction,List documents) throws Exception {
        if (direction == null) {
            throw new NullPointerException("directory must not be null");
        }
        
        
    File root = new File(direction);
    if (!root.exists())
        System.out.println("El fichero " + root + "no existe");
    else{

    String[] extensions = { "txt", "csv", "xml", "html"};
    boolean recursive = true;

    Collection files = FileUtils.listFiles(root, extensions, recursive);

    for (Iterator iterator = files.iterator(); iterator.hasNext();) {
      File file = (File) iterator.next();
      
      String extension = FilenameUtils.getExtension(file.getAbsolutePath());
      
      BaseFileType newFile = FileFactory.getFile(file,extension);
      documents.add(newFile);
    }
    }
  }
}