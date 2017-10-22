package com.example.yash.dictionary.POJOS.Antonyms;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Yash on 09-10-2017.
 */

public class MainAntonymsClass implements Serializable{

    String ispopulated;
    ArrayList<String> Category;

    public void setIspopulated(String ispopulated) {
        this.ispopulated = ispopulated;
    }

    ArrayList<String> Word;

    public String getIspopulated() {
        return ispopulated;
    }

    public MainAntonymsClass(String ispopulated) {

        this.ispopulated = ispopulated;
    }

    public MainAntonymsClass() {
    }

    public ArrayList<String> getCategory() {
        return Category;
    }

    public ArrayList<String> getWord() {
        return Word;
    }

    public MainAntonymsClass(ArrayList<String> category, ArrayList<String> word) {

        Category = category;
        Word = word;
    }
}
