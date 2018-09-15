/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Indexer;

import java.io.FileNotFoundException;
import java.util.List;
import java.io.File;

/**
 *
 * @author Usuario
 */

public abstract class BaseFileType implements serializable{
    String name;
    List vector; //dimensiones por palabra
    String url;
    List<String> words;
    
    abstract List<Double> getVector();
    abstract void insertDimension(Double dimension);//insertar al vector
    abstract String getName();
    abstract List<String> parserWords(File file)throws FileNotFoundException;
    abstract List<String> getwords();
}