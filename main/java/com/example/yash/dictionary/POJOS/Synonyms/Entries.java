package com.example.yash.dictionary.POJOS.Synonyms;

import java.util.ArrayList;

/**
 * Created by Yash on 09-10-2017.
 */

public class Entries {
    ArrayList<Senses> senses;

    public ArrayList<Senses> getSenses() {
        return senses;
    }

    public Entries(ArrayList<Senses> senses) {

        this.senses = senses;
    }
}
