package com.example.yash.dictionary.POJOS;

import java.util.ArrayList;

/**
 * Created by Yash on 30-09-2017.
 */

public class Meaning {
    Metadata metadata;
    ArrayList<Results> results = new ArrayList<>();

    public Metadata getMetadata() {
        return metadata;
    }

    public ArrayList<Results> getResults() {
        return results;
    }

    public Meaning(Metadata metadata, ArrayList<Results> results) {

        this.metadata = metadata;
        this.results = results;
    }
}
