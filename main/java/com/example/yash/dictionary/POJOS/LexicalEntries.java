package com.example.yash.dictionary.POJOS;

import com.example.yash.dictionary.POJOS.Pronunciations;

import java.util.ArrayList;

/**
 * Created by Yash on 02-10-2017.
 */

public class LexicalEntries {

    String lexicalCategory;
    ArrayList<Pronunciations> pronunciations = new ArrayList<>();
    ArrayList<Entries> entries = new ArrayList<>();

    public String getLexicalCategory() {
        return lexicalCategory;
    }

    public ArrayList<Pronunciations> getPronunciations() {
        return pronunciations;
    }

    public ArrayList<Entries> getEntries() {
        return entries;
    }

    public LexicalEntries(String lexicalCategory, ArrayList<Pronunciations> pronunciations, ArrayList<Entries> entries) {

        this.lexicalCategory = lexicalCategory;
        this.pronunciations = pronunciations;
        this.entries = entries;
    }
}
