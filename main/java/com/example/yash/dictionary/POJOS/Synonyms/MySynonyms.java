package com.example.yash.dictionary.POJOS.Synonyms;

import com.example.yash.dictionary.POJOS.Metadata;

import java.util.ArrayList;

/**
 * Created by Yash on 09-10-2017.
 */

public class MySynonyms {

    Metadata metadata;
    ArrayList<Results>results;

    public Metadata getMetadata() {
        return metadata;
    }

    public ArrayList<Results> getResults() {
        return results;
    }

    public MySynonyms(Metadata metadata, ArrayList<Results> results) {

        this.metadata = metadata;
        this.results = results;
    }
}
