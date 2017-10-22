package com.example.yash.dictionary.POJOS;

import java.util.ArrayList;

/**
 * Created by Yash on 02-10-2017.
 */

public class Entries {

    ArrayList<String> etymologies = new ArrayList<>();
    ArrayList<GrammaticalFeatures> grammaticalFeatures = new ArrayList<>();
    ArrayList<Senses> senses =new ArrayList<>();

    public ArrayList<String> getEtymologie() {
        return etymologies;
    }

    public ArrayList<GrammaticalFeatures> getGrammaticalFeatures() {
        return grammaticalFeatures;
    }

    public ArrayList<Senses> getSenses() {
        return senses;
    }

    public Entries(ArrayList<String> etymologie, ArrayList<GrammaticalFeatures> grammaticalFeatures, ArrayList<Senses> senses) {

        this.etymologies = etymologie;
        this.grammaticalFeatures = grammaticalFeatures;
        this.senses = senses;
    }
}
