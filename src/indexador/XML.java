package indexador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XML extends BaseFileType{
    
    /*public static void main(String[] args) {
        File fileXML = new File("C://simple.xml");
        List<String> words = parseXML(fileXML);

        for(int j = 0; j < words.size(); j++){
            System.out.println("hey XML " + words.get(j));
        }
    }*/
    
    public XML(File file) throws FileNotFoundException{
    this.name =file.getName();
    this.url=file.getAbsolutePath();
    this.words = parserWords(file);
    this.vector = new ArrayList<>();
    }

    private static List<String> getW(String cadena) {
        List<String> theWords = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer (cadena);

        // bucle por todas las palabras
        while (st.hasMoreTokens())
        {
            String s2 = st.nextToken();
            theWords.add(s2);
        }
        return theWords;
    }


    @Override
    List<String> parserWords(File file) throws FileNotFoundException {

        List<String> words = new ArrayList<String>();

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();

            parseRecursive (words, document.getDocumentElement());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return words;
    }

    private static void parseRecursive(List<String> allWords, Element element) {
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                allWords.addAll(getW(node.getTextContent()));
                parseRecursive(allWords, (Element) node);
            }
        }
    }

    @Override
    List<Double> getVector() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void insertDimension(Double dimension) {
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
}