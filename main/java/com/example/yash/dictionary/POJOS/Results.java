package com.example.yash.dictionary.POJOS;

import java.util.ArrayList;

/**
 * Created by Yash on 02-10-2017.
 */

public class Results {
    String id;
    String language;
    ArrayList<LexicalEntries> lexicalEntries = new ArrayList<>();

    public String getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public ArrayList<LexicalEntries> getLexicalEntries() {
        return lexicalEntries;
    }

    public Results(String id, String language, ArrayList<LexicalEntries> lexicalEntries) {

        this.id = id;
        this.language = language;
        this.lexicalEntries = lexicalEntries;
    }
}
