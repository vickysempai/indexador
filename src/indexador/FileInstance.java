/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

import java.util.ArrayList;
import java.util.List;

class FileInstance {
    String folderDir;
    List<BaseFileType> documents= new ArrayList<BaseFileType>();
    
    public void load(String direction) throws Exception{
    this.folderDir=direction;
    this.documents = FileRead.getFiles(direction, documents);
    }
    public void load(Integer direction) throws Exception{
    }
}
