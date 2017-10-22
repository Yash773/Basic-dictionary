package com.example.yash.dictionary.POJOS.Synonyms;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Yash on 09-10-2017.
 */

public class MainSynonymsClass implements Serializable{



    String ispopulated;

    public void setIspopulated(String ispopulated) {
        this.ispopulated = ispopulated;
    }

    public String getIspopulated() {

        return ispopulated;
    }

    public MainSynonymsClass(String ispopulated) {

        this.ispopulated = ispopulated;
    }

    ArrayList<String> Category;
    ArrayList<String> Word;

    public MainSynonymsClass() {
    }

    public ArrayList<String> getCategory() {
        return Category;
    }

    public ArrayList<String> getWord() {
        return Word;
    }

    public MainSynonymsClass(ArrayList<String> category, ArrayList<String> word) {

        Category = category;
        Word = word;
    }
}
