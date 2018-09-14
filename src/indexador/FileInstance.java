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

class FileInstance {
    
    private Long time;
    private String folderDir;
    private List<BaseFileType> documents= new ArrayList<BaseFileType>();
    private static FileInstance instance;
    private List indexedDocuments;
    private ArrayList<String> allWords;
    private List<List<String>> docs;
    
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
    ArrayList getAllwords(){
        ArrayList<String> allWords = new ArrayList<>();
        for (BaseFileType file : this.documents) {
            this.docs.add(file.words);
                for(String word: file.words)
                    allWords.add(word);
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
    
    public void Index(){
        for (BaseFileType doc : documents) {
            ArrayList<Double> tfidfvectors = new ArrayList<Double>();
            int count = 0;
            for (String term : allWords) {
                TfIdfIndex x = new TfIdfIndex();
                tfidfvectors.add(x.Index(doc.words,this.docs,term));
                count++;
            }
            indexedDocuments.add(tfidfvectors);  //storing document vectors;            
        }
    }

    
}
