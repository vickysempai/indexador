/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import indexador.TfIdfIndex;
import java.io.Serializable;

class FileInstance implements IgetDistance, Serializable{
    
    private List<double[]> tfidfDocsVector = new ArrayList<double[]>();
    //vectors of all documents
    
    private List<BaseFileType> documents = new ArrayList<BaseFileType>();
    //Every document
    
    private List<List<String>> docs = new ArrayList<>();
    //all words of each file of all files
    
    private Long time;
    private String folderDir;
    
    private static FileInstance instance;
    private ArrayList<String> allWords;
    
    
    private FileInstance(){}
    
    private FileInstance(String direction) throws Exception{
    this.folderDir=direction;
    this.documents = FileReader.getFiles(direction, documents);
    this.time = getTime(direction);
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
    //Indexar(){
    
    //}
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
    /*
    Double getSizeAllDocuments(){
        Integer cont=0;
        for (BaseFileType file : documents) {
            for(String word: file.words)
                cont++;
            System.out.print(cont);
        }
        
        return cont;
    }*/
    
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
    
    @Override
    public void getDistance(String query) {
        double[] vectorQuery=tfIdfQuery(query);
        for (int i = 0; i < tfidfDocsVector.size(); i++) {
                    System.out.println("between " + i + " and " + "  =  " + new CosineSimilarity().cosineSimilarity(vectorQuery, tfidfDocsVector.get(i)));
                }

            }
        }