/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

import java.io.FileNotFoundException;
import java.util.List;
import java.io.File;

/**
 *
 * @author Usuario
 */

public abstract class BaseFileType {
    String name;
    Float vector;
    String url;
    List<String> words;
    File file;
    
    abstract Float getFloat();
    abstract void setFloat(Float vector);
    abstract String getName();
}