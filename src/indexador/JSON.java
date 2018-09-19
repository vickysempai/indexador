package indexador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class JSON extends BaseFileType{
    
    public JSON(File file) throws FileNotFoundException{
    this.name =file.getName();
    this.url=file.getAbsolutePath();
    this.words = parserWords(file);
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
    
    private static void parseRecursive(List<String> allWords, Element element) {
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                parseRecursive(allWords, (Element) node);
            }
            else if (node.getNodeType() == Node.TEXT_NODE){
                
                String nodeText = node.getTextContent();
                nodeText = nodeText.replaceAll("[-+.^:,;(){}\\[\\]/\\\\]", " ");
                allWords.addAll(getW(nodeText));
                
            }
        }
    }
    
    @Override
    List<String> parserWords(File file) throws FileNotFoundException {
        
        List<String> words = new ArrayList<String>();
        
        try {
        
            String content = FileUtils.readFileToString(file, "utf-8");
            JSONObject obj = new JSONObject(content);
            String xml = XML.toString(obj);

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            InputSource is = new InputSource(new StringReader(xml));
            Document document = documentBuilder.parse(is);
            document.getDocumentElement().normalize();
            
            parseRecursive (words, document.getDocumentElement());

        }
        catch (Exception e ){

        }
        return words;
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
