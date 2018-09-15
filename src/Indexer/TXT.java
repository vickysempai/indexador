/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Indexer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TXT extends BaseFileType{
    
    public TXT(File file) throws FileNotFoundException{
    this.name =file.getName();
    this.url=file.getAbsolutePath();
    this.words = parserWords(file);
    this.vector = new ArrayList<>();
    }
    
    @Override
    List<String> parserWords(File file) throws FileNotFoundException{
        
        List<String> words = new ArrayList<>();
        String cadena;
        BufferedReader bf = new BufferedReader(new FileReader(file.getAbsolutePath()));

        try {
                while((cadena = bf.readLine())!=null) {
                    StringTokenizer st = new StringTokenizer (cadena);

                    // bucle por todas las palabras
                    while (st.hasMoreTokens())
                    {
                        String s2 = st.nextToken();
                        words.add(s2);
                    }
                }   } 
            catch (IOException ex) {
                Logger.getLogger(TXT.class.getName()).log(Level.SEVERE, null, ex);
            }
        return words;
    }
    
    
    @Override
    void insertDimension(Double dimension) {
        this.vector.add(dimension);
    }

    @Override
    List<Double> getVector() {
        return this.vector;
    }

    @Override
    String getName() {
        return this.name;
    }

    @Override
    public List<String> getwords() {
        return this.words;
    }
    
}
