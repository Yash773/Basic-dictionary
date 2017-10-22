package com.example.yash.dictionary.POJOS.Antonyms;

import java.util.ArrayList;

/**
 * Created by Yash on 09-10-2017.
 */

public class Results {

    ArrayList<LexicalEntries>lexicalEntries;

    public ArrayList<LexicalEntries> getLexicalEntries() {
        return lexicalEntries;
    }

    public Results(ArrayList<LexicalEntries> lexicalEntries) {

        this.lexicalEntries = lexicalEntries;
    }
}
