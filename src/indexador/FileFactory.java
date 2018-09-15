/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

import java.io.File;
import indexador.TXT;
import java.io.FileNotFoundException;

/**
 *
 * @author Usuario
 */
public class FileFactory {
    
    /*public BaseFileType getInstance(){
        return this.dicc.ge
    }*/
    public static BaseFileType getFile(File file,String extension) throws FileNotFoundException{
        if("txt".equals(extension)){
            return new TXT(file);
        }
        if("csv".equals(extension)){
            return new CSV(file);
        }
        if("xml".equals(extension)){
            return new XML(file);
        }
        if("html".equals(extension)){
            return new HTML(file);
        }
        return null;
    }
}