/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TXT extends BaseFileType{
    
    public TXT(File file){
    this.file= file;
    this.words = new ArrayList<String>();
    }
    
    @Override
    Float getFloat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void setFloat(Float vector) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    void leer(){for(String str : words)
{
    System.out.println(str);
}
    
}
    @Override
    public void convertFile() throws FileNotFoundException {
        String cadena;
        File arch = this.file;
        BufferedReader bf = new BufferedReader(new FileReader(arch.getAbsolutePath()));
        try {
            while((cadena = bf.readLine())!=null) {
                StringTokenizer st = new StringTokenizer (cadena);
                
                // bucle por todas las palabras
                while (st.hasMoreTokens())
                {
                    String s2 = st.nextToken();
                    this.words.add(s2);
                    System.out.println ("    Palabra "  + " es: " + s2);
                }
            }   } 
        catch (IOException ex) {
            Logger.getLogger(TXT.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
