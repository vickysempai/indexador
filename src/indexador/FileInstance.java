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
    Long time;
    String folderDir;
    List<BaseFileType> documents= new ArrayList<BaseFileType>();
    
    public void load(String direction) throws Exception{
    this.folderDir=direction;
    this.documents = FileRead.getFiles(direction, documents);
    this.time = getTime(direction);
    
    }

    Long getTime(String direction) {
        File file = new File(direction);
	return file.lastModified();
    }
    
}
