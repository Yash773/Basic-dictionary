package com.example.yash.dictionary.POJOS.Synonyms;

import java.util.ArrayList;

/**
 * Created by Yash on 09-10-2017.
 */

public class LexicalEntries {

    ArrayList<Entries> entries;
    String lexicalCategory;

    public ArrayList<Entries> getEntries() {
        return entries;
    }

    public String getLexicalCategory() {
        return lexicalCategory;
    }

    public LexicalEntries(ArrayList<Entries> entries, String lexicalCategory) {

        this.entries = entries;
        this.lexicalCategory = lexicalCategory;
    }
}
