package com.example.yash.dictionary.POJOS.Antonyms;

import com.example.yash.dictionary.POJOS.Metadata;

import java.util.ArrayList;

/**
 * Created by Yash on 09-10-2017.
 */

public class MyAntonyms {

    Metadata metadata;
    ArrayList<Results>results;

    public Metadata getMetadata() {
        return metadata;
    }

    public ArrayList<Results> getResults() {
        return results;
    }

    public MyAntonyms(Metadata metadata, ArrayList<Results> results) {

        this.metadata = metadata;
        this.results = results;
    }
}
