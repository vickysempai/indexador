package indexador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV extends BaseFileType{

    public CSV(File file) throws FileNotFoundException{
    this.name =file.getName();
    this.url = file.getAbsolutePath();
    this.words = parserWords(file);
    this.vector = new ArrayList<>();
    }    
    
    
    public static final String delimiter = ",";

    @Override
    List<String> parserWords(File file) throws FileNotFoundException{
        List<String> words = new ArrayList<String>();
        BufferedReader bf = new BufferedReader(new FileReader(file.getAbsolutePath()));

        try {

            String line = "";

            String[] tempArr;
            while ((line = bf.readLine()) != null) {
                tempArr = line.split(delimiter);
            for (String tempStr : tempArr) {
                words.add(tempStr);
            }
        }
            bf.close();

            } catch (IOException ex) {
                ex.printStackTrace();
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
    List<String> getwords() {
        return this.words;
    }

}