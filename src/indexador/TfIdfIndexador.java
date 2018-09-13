/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

import java.util.List;
        
public class TfIdfIndexador implements IIndexar{
    
    public double tf(List<String> doc, String term) {

        double result = 0;

        for (String word : doc) {

            if (term.equalsIgnoreCase(word))

                result++;

        }

        return result / doc.size();

    }    

    public double idf(List<List<String>> docs, String term) {

        double n = 0;

        for (List<String> doc : docs) {

            for (String word : doc) {

                if (term.equalsIgnoreCase(word)) {

                    n++;

                    break;

                }

            }

        }

        return Math.log(docs.size() / n);

    }
    @Override
    public double IIndexar(List<String> doc, List<List<String>> docs, String term) {
        return tf(doc, term) * idf(docs, term);
    }

}