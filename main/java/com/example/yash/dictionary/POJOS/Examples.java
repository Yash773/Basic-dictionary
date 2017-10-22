package com.example.yash.dictionary.POJOS;

import java.util.ArrayList;

/**
 * Created by Yash on 06-10-2017.
 */

public class Examples {

    ArrayList<String> registers;
    String text;

    public ArrayList<String> getRegisters() {
        return registers;
    }

    public String getText() {
        return text;
    }

    public Examples(ArrayList<String> registers, String text) {

        this.registers = registers;
        this.text = text;
    }
}
