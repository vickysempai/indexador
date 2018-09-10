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

/**
 *
 * @author Usuario
 */
public class FileReader {
    public static void iterate(String direction) throws Exception {
    File root = new File(direction);
    
    String[] extensions = { "xml", "java", "dat" };
    boolean recursive = true;

    Collection files = FileUtils.listFiles(root, extensions, recursive);

    for (Iterator iterator = files.iterator(); iterator.hasNext();) {
      File file = (File) iterator.next();
      // aqui va el factory
      System.out.println("File = " + file.getAbsolutePath());
    }
  }
}
