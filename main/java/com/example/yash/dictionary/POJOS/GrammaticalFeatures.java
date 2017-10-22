package com.example.yash.dictionary.POJOS;

/**
 * Created by Yash on 02-10-2017.
 */

public class GrammaticalFeatures {
    String text;
    String type;

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public GrammaticalFeatures(String text, String type) {

        this.text = text;
        this.type = type;
    }
}
