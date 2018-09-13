/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class FileInstance {
    
    private Long time;
    private String folderDir;
    private List<BaseFileType> documents= new ArrayList<BaseFileType>();
    private static FileInstance instance;
    
    private FileInstance(String direction) throws Exception{
    this.folderDir=direction;
    this.documents = FileRead.getFiles(direction, documents);
    this.time = getTime(direction);
    
        
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
}
