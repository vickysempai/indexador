/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

import java.util.List;
import indexador.BaseFileType;
/**
 *
 * @author Usuario
 */
public class FileInstance {
    List<BaseFileType> documents;
    
    public void addList(BaseFileType document){
    documents.add(document);
    //
    }
}