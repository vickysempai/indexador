/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class FileInstance implements Serializable, tfIdfCalculator,getCosineSimilarity{
    
    private List<double[]> tfidfDocsVector = new ArrayList<double[]>();
    private List<BaseFileType> documents = new ArrayList<BaseFileType>();
    private List<List<String>> docs = new ArrayList<>();
    
    private String folderDir;
    
    private static FileInstance instance;
    private ArrayList<String> allWords;
    
    
    private FileInstance(){}
    
    FileInstance(String direction) throws Exception{
    this.folderDir=direction;
    this.documents = FileReader.getFiles(direction, documents);
    this.allWords = getAllwords();
    
        
    }
    public static FileInstance getFileInstance(String direction) throws Exception{
        if (instance==null){
            instance=new FileInstance(direction);}
        return instance;
    }

    Long getTime(String direction) {
        File file = new File(direction);
	return file.lastModified();}
    
    String getdir(){
        return folderDir;
    }
    private ArrayList getAllwords(){
        ArrayList<String> allWords = new ArrayList<>();
        for (BaseFileType file : this.documents) {
            this.docs.add(file.words);
                for(String word: file.words)
                    if(!allWords.contains(word))
                	{
                            allWords.add(word);
                            allWords.add(word);
                	}
            }
            return allWords;
        }
    @Override
    public void tfIdfCalculator() 
    {
        double tf; //term frequency
        double idf; //inverse document frequency
        double tfidf; //term frequency inverse document frequency  
        for (List<String> docTermsArray : docs) 
        {
            double[] tfidfvectors = new double[allWords.size()];
            int count = 0;
            for (String terms : allWords) 
            {
                tf = new TfIdfIndex().tfCalculator(docTermsArray, terms);
                idf = new TfIdfIndex().idfCalculator(docs, terms);
                tfidf = tf * idf;
                tfidfvectors[count] = tfidf;
                count++;
            }
            tfidfDocsVector.add(tfidfvectors);  //storing document vectors;            
        }
    }
    private List<String> ParseQuery(String query){
    List<String> words = new ArrayList<>();
     StringTokenizer st = new StringTokenizer (query);

                    // bucle por todas las palabras
                    while (st.hasMoreTokens())
                    {
                        String s2 = st.nextToken();
                        words.add(s2);
                    }
                    return words;
    }
    
    private double[] tfIdfQuery(String query) 
    {
        List<String> search = ParseQuery(query);
        double[] vectorQuery = new double[allWords.size()];
        double tf; //term frequency
        double idf; //inverse document frequency
        double tfidf; //term frequency inverse document frequency
            
        int count = 0;
        for (String terms : allWords) 
        {
            tf = new TfIdfIndex().tfCalculator(search, terms);
            idf = new TfIdfIndex().idfCalculator(docs, terms);
            tfidf = tf * idf;
            vectorQuery[count] = tfidf;
            count++;
        }
        return vectorQuery;
    }
    private Integer getMinor(Double[] array){
        int number = 0;
        for(int i=0 ; i<5 ;i++){
            if(array[i]==null)
                return i;
            if(array[number] > array[i]) {
                number=i;
            }
	}
        return number;
    }
    
    @Override
    public String[] getCosineSimilarity(String query) {
        double[] vectorQuery=tfIdfQuery(query);
        Double[] cosines= new Double[5];
        Double cosine;
        String[] top5 = { "", "", "", "", "" };
        
        int minor=0;
        
        for (int i = 0; i < tfidfDocsVector.size(); i++) {
            cosine = new CosineSimilarity().cosineSimilarity(vectorQuery, tfidfDocsVector.get(i));
            minor=getMinor(cosines);
            //System.out.println(cosine);
            if((cosines[minor]==null || cosines[minor]<cosine)&&cosine!=0.0){
                cosines[minor]=cosine;
                top5[minor]= documents.get(i).url;
                }
            }
        return top5;
    }
}