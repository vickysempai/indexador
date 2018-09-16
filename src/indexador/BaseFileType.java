/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

import java.io.FileNotFoundException;
import java.util.List;
import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Usuario
 */

public abstract class BaseFileType implements Serializable{
    String name;
    String url;
    List<String> words;
    
    abstract String getName();
    abstract List<String> parserWords(File file)throws FileNotFoundException;
    abstract List<String> getwords();
}