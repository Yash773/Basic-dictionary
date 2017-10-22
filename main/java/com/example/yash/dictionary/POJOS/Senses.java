package com.example.yash.dictionary.POJOS;

import java.util.ArrayList;

/**
 * Created by Yash on 02-10-2017.
 */

public class Senses {

    ArrayList<String> definitions = new ArrayList<>();
    ArrayList<String> domains = new ArrayList<>();
    ArrayList<Examples> examples = new ArrayList<>();

    public ArrayList<String> getDefinitions() {
        return definitions;
    }

    public ArrayList<String> getDomains() {
        return domains;
    }

    public ArrayList<Examples> getExamples() {
        return examples;
    }

    public Senses(ArrayList<String> definitions, ArrayList<String> domains, ArrayList<Examples> examples) {

        this.definitions = definitions;
        this.domains = domains;
        this.examples = examples;
    }
}
