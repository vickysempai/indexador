/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

import java.util.List;
        
public class TfIdfIndex
{

    // Calculates the tf of term termToCheck

    // totalterms : Array of all the words under processing document

    // termToCheck : term of which tf is to be calculated.

    // returns tf(term frequency) of term termToCheck

    

    public double tfCalculator(List<String> totalterms, String termToCheck) 

    {

        double count = 0;  //to count the overall occurrence of the term termToCheck

        for (String s : totalterms) 

        {

            if (s.equalsIgnoreCase(termToCheck)) 

            {

                count++;

            }

        }

        return count / totalterms.size();

    }



    // Calculates idf of term termToCheck

    // allTerms : all the terms of all the documents

    // returns idf(inverse document frequency) score

    

    public double idfCalculator(List<List<String>> allTerms, String termToCheck) 

    {

        double count = 0;

        for (List<String> ss : allTerms) 

        {

            for (String s : ss) 

            {

                if (s.equalsIgnoreCase(termToCheck)) 

                {

                    count++;

                    break;

                }

            }

        }

        return 1 + Math.log(allTerms.size() / count);

    }

}