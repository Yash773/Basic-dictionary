package com.example.yash.dictionary.POJOS;

import java.util.ArrayList;

/**
 * Created by Yash on 02-10-2017.
 */

public class Pronunciations {
    String audioFile;
    String phoneticSpelling;
    String phoneticNotation;

    public String getAudioFile() {
        return audioFile;
    }

    public String getPhoneticSpelling() {
        return phoneticSpelling;
    }

    public String getPhoneticNotation() {
        return phoneticNotation;
    }

    public Pronunciations(String audioFile, String phoneticSpelling, String phoneticNotation) {

        this.audioFile = audioFile;
        this.phoneticSpelling = phoneticSpelling;
        this.phoneticNotation = phoneticNotation;
    }
}
