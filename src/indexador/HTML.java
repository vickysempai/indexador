package indexador;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class HTML extends BaseFileType{

    /*public static void main(String[] args) {


        File fileHTML = new File("C://words.html");
        List<String> wordsHTML = parserWordsHTML(fileHTML);

        for(int j = 0; j < wordsHTML.size(); j++){
            System.out.println("hey HTML " + wordsHTML.get(j));
        }
    }*/
    
    public HTML(File file) throws FileNotFoundException{
    this.name =file.getName();
    this.url = file.getAbsolutePath();
    this.words = parserWords(file);
    }    

    @Override
    List<String> parserWords(File file) throws FileNotFoundException {

        List<String> words = new ArrayList<String>();

        try{
            Document document = Jsoup.parse(file, null);

            String text = document.text();
            words.addAll(getW(text));
        }
        catch (Exception e ){

        }
        return words;
    }

    private static List<String> getW(String cadena) {
        List<String> theWords = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer (cadena);

        // bucle por todas las palabras
        while (st.hasMoreTokens())
        {
            String s2 = st.nextToken();
            theWords.add(s2);
            //      System.out.println ("    Palabra "  + " es: " + s2);
        }
        return theWords;
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