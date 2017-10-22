package com.example.yash.dictionary.POJOS.Synonyms;

import java.util.ArrayList;

/**
 * Created by Yash on 09-10-2017.
 */

public class Senses {
    ArrayList<Synonyms> synonyms;

    public ArrayList<Synonyms> getSynonyms() {
        return synonyms;
    }

    public Senses(ArrayList<Synonyms> synonyms) {

        this.synonyms = synonyms;
    }
}
