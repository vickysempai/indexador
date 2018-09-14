/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IIndex {
    void IIndex(List<String> doc, List<List<String>> docs, String query);
}
