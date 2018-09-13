package indexador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader extends BaseFileType{

    public CSVReader(File file) throws FileNotFoundException{
    this.name =file.getName();
    this.url=file.getAbsolutePath();
    this.words = parserWords(file);
    }    
    
    
    public static final String delimiter = ",";

@Override
    List<String> parserWords(File file) throws FileNotFoundException{
    List<String> words = new ArrayList<String>();
    String cadena;
    BufferedReader bf = new BufferedReader(new FileReader(file.getAbsolutePath()));
        
    try {
	//File file = new File(csvFile);
	FileReader fr = new FileReader(file);
	BufferedReader br = new BufferedReader(fr);

	String line = "";

	String[] tempArr;
	while ((line = br.readLine()) != null) {
            tempArr = line.split(delimiter);
	for (String tempStr : tempArr) {
            words.add(tempStr);
            //System.out.print(tempStr + " ");
	}
        System.out.println();
    }
	br.close();

	} catch (IOException ex) {
            ex.printStackTrace();
    }
    return words;
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
    List<String> getwords() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



public static void main(String[] args) {
// csv file to read
		String csvFile = "C:/Users/maria/Desktop/FL_insurance_sample.csv";
		//CSVReader.read(csvFile);
	}

}   

