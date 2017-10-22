package com.example.yash.dictionary.POJOS;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Yash on 09-10-2017.
 */

public class MYMeaningClass implements Serializable{

    String ispopulated;

    public void setIspopulated(String ispopulated) {
        this.ispopulated = ispopulated;
    }

    public String getIspopulated() {

        return ispopulated;
    }

    public MYMeaningClass(String ispopulated) {

        this.ispopulated = ispopulated;
    }

    String Provider;
    String ID;
    String Language;

    ArrayList<String> LexicalCategories;
    ArrayList<String> AudioFiles;
    ArrayList<String> PhoneticSpellings;
    ArrayList<String> PhoneticNotation;

    ArrayList<String> Etymologies;
    ArrayList<String> GramaticalFeaturesText;
    ArrayList<String> GramaticalFeaturesType;
    ArrayList<String> Definitions;
    ArrayList<String> Domain;

    public MYMeaningClass() {
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getLanguage() {

        return Language;
    }

    public MYMeaningClass(String provider, String language, String ID, ArrayList<String> lexicalCategories, ArrayList<String> audioFiles, ArrayList<String> phoneticSpellings, ArrayList<String> phoneticNotation, ArrayList<String> etymologies, ArrayList<String> gramaticalFeaturesText, ArrayList<String> gramaticalFeaturesType, ArrayList<String> definitions, ArrayList<String> domain) {
        Provider = provider;
        Language=language;

        this.ID = ID;
        LexicalCategories = lexicalCategories;
        AudioFiles = audioFiles;
        PhoneticSpellings = phoneticSpellings;
        PhoneticNotation = phoneticNotation;
        Etymologies = etymologies;
        GramaticalFeaturesText = gramaticalFeaturesText;
        GramaticalFeaturesType = gramaticalFeaturesType;
        Definitions = definitions;
        Domain = domain;
    }

    public String getProvider() {
        return Provider;
    }

    public String getID() {
        return ID;
    }

    public ArrayList<String> getLexicalCategories() {
        return LexicalCategories;
    }

    public ArrayList<String> getAudioFiles() {
        return AudioFiles;
    }

    public ArrayList<String> getPhoneticSpellings() {
        return PhoneticSpellings;
    }

    public ArrayList<String> getPhoneticNotation() {
        return PhoneticNotation;
    }

    public ArrayList<String> getEtymologies() {
        return Etymologies;
    }

    public ArrayList<String> getGramaticalFeaturesText() {
        return GramaticalFeaturesText;
    }

    public ArrayList<String> getGramaticalFeaturesType() {
        return GramaticalFeaturesType;
    }

    public ArrayList<String> getDefinitions() {
        return Definitions;
    }

    public ArrayList<String> getDomain() {
        return Domain;
    }

    public void setProvider(String provider) {
        Provider = provider;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setLexicalCategories(ArrayList<String> lexicalCategories) {
        LexicalCategories = lexicalCategories;
    }

    public void setAudioFiles(ArrayList<String> audioFiles) {
        AudioFiles = audioFiles;
    }

    public void setPhoneticSpellings(ArrayList<String> phoneticSpellings) {
        PhoneticSpellings = phoneticSpellings;
    }

    public void setPhoneticNotation(ArrayList<String> phoneticNotation) {
        PhoneticNotation = phoneticNotation;
    }

    public void setEtymologies(ArrayList<String> etymologies) {
        Etymologies = etymologies;
    }

    public void setGramaticalFeaturesText(ArrayList<String> gramaticalFeaturesText) {
        GramaticalFeaturesText = gramaticalFeaturesText;
    }

    public void setGramaticalFeaturesType(ArrayList<String> gramaticalFeaturesType) {
        GramaticalFeaturesType = gramaticalFeaturesType;
    }

    public void setDefinitions(ArrayList<String> definitions) {
        Definitions = definitions;
    }

    public void setDomain(ArrayList<String> domain) {
        Domain = domain;
    }
}
