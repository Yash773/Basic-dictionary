package com.example.yash.dictionary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.yash.dictionary.Activities.Antonyms_Full;
import com.example.yash.dictionary.Activities.Meaning_Full;
import com.example.yash.dictionary.Activities.Synonyms_Full;
import com.example.yash.dictionary.Fragments.Meaning_Half;
import com.example.yash.dictionary.POJOS.Antonyms.Antonyms;
import com.example.yash.dictionary.POJOS.Antonyms.MainAntonymsClass;
import com.example.yash.dictionary.POJOS.Antonyms.MyAntonyms;
import com.example.yash.dictionary.POJOS.Entries;
import com.example.yash.dictionary.POJOS.Examples;
import com.example.yash.dictionary.POJOS.GrammaticalFeatures;
import com.example.yash.dictionary.POJOS.LexicalEntries;
import com.example.yash.dictionary.POJOS.MYMeaningClass;
import com.example.yash.dictionary.POJOS.Meaning;
import com.example.yash.dictionary.POJOS.Metadata;
import com.example.yash.dictionary.POJOS.Pronunciations;
import com.example.yash.dictionary.POJOS.Results;
import com.example.yash.dictionary.POJOS.Senses;
import com.example.yash.dictionary.POJOS.Synonyms.MainSynonymsClass;
import com.example.yash.dictionary.POJOS.Synonyms.MySynonyms;
import com.example.yash.dictionary.POJOS.Synonyms.Synonyms;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String DEFAULTETWORD = "Enter Word Here";

    MYMeaningClass mClass = new MYMeaningClass("false");
    MainSynonymsClass mSClass = new MainSynonymsClass("false");
    MainAntonymsClass mAClass = new MainAntonymsClass("false");

    public static final String TAG = " tag ";

    ImageButton ibSearch;
    EditText etWord;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etWord = (EditText) findViewById(R.id.etWord);
        etWord.setHint(DEFAULTETWORD);


        View fragMeaningHalf = findViewById(R.id.fragMeaningHalf);
        View fragSynonymsHalf = findViewById(R.id.fragSynonymsHalf);
        View fragAntonymsHalf = findViewById(R.id.fragAntonymsHalf);


        fragMeaningHalf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mClass.getIspopulated().equals("true")){
                    Intent i = new Intent(MainActivity.this, Meaning_Full.class);
                    i.putExtra("class", mClass);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this," NO Meaning Found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fragSynonymsHalf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSClass.getIspopulated().equals("true")){
                    Intent i = new Intent(MainActivity.this, Synonyms_Full.class);
                    i.putExtra("class", mSClass);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this," NO Synonyms Found", Toast.LENGTH_SHORT).show();
                }

            }
        });

        fragAntonymsHalf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mAClass.getIspopulated().equals("true")){
                    Intent i = new Intent(MainActivity.this, Antonyms_Full.class);
                    i.putExtra("class", mAClass);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this," NO Antonyms Found", Toast.LENGTH_SHORT).show();
                }
            }
        });



        fragmentManager = getSupportFragmentManager();


        ibSearch = (ImageButton) findViewById(R.id.ibSearch);

        ibSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String word = etWord.getText().toString().toLowerCase(Locale.getDefault());

                if(word.equals(""))
                    Toast.makeText(MainActivity.this, "Please Enter a Word", Toast.LENGTH_SHORT).show();


                APIService.getApi().getMeaning(word).enqueue(new Callback<Meaning>() {
                    @Override
                    public void onResponse(Call<Meaning> call, Response<Meaning> response) {


                        if(response.code()==404) {
                            Toast.makeText(MainActivity.this, "Meaning Not Found", Toast.LENGTH_SHORT).show();
                            mClass.setIspopulated("false");
                        }
                        else
                        {

                            Meaning meaning = response.body();
                            Metadata metadata = meaning.getMetadata();
                            ArrayList<Results> results = meaning.getResults();


                            MYMeaningClass myMeaningClass;

                            String Provider;
                            String ID;
                            String Language;

                            ArrayList<String> LexicalCategories = new ArrayList<String>();
                            ArrayList<String> AudioFiles= new ArrayList<String>();
                            ArrayList<String> PhoneticSpellings= new ArrayList<String>();
                            ArrayList<String> PhoneticNotation= new ArrayList<String>();

                            ArrayList<String> Etymologies= new ArrayList<String>();
                            ArrayList<String> GramaticalFeaturesText= new ArrayList<String>();
                            ArrayList<String> GramaticalFeaturesType= new ArrayList<String>();
                            ArrayList<String> Definitions= new ArrayList<String>();
                            ArrayList<String> Domain= new ArrayList<String>();



                            if(meaning.getMetadata().getProvider()!=null)
                                Provider=metadata.getProvider();
                            else
                                Provider="NULL";


                            if(results.get(0).getId()!=null)
                               ID=results.get(0).getId();
                            else
                                ID="NULL";


                            if(results.get(0).getLanguage()!=null)
                                Language=results.get(0).getLanguage();
                            else
                                Language="NULL";


                            ArrayList<LexicalEntries> lexicalEntries = results.get(0).getLexicalEntries();
                            for(int i=0;i<lexicalEntries.size();i++){

                                if(lexicalEntries.get(i).getLexicalCategory()!=null)
                                    LexicalCategories.add(lexicalEntries.get(i).getLexicalCategory());
                                else
                                    LexicalCategories.add("NULL");


                                ArrayList<Pronunciations> pronunciations = lexicalEntries.get(i).getPronunciations();
                                if(pronunciations!=null) {
                                    for (int j = 0; j < pronunciations.size(); j++) {

                                        if(pronunciations.get(j).getAudioFile()!=null)
                                            AudioFiles.add(pronunciations.get(j).getAudioFile());
                                        else
                                            AudioFiles.add("NULL");


                                        if(pronunciations.get(j).getPhoneticSpelling()!=null)
                                            PhoneticSpellings.add(pronunciations.get(j).getPhoneticSpelling());
                                        else
                                            PhoneticSpellings.add("NULL");

                                        if(pronunciations.get(j).getPhoneticNotation()!=null)
                                            PhoneticNotation.add(pronunciations.get(j).getPhoneticNotation());
                                        else
                                            PhoneticNotation.add("NULL");
                                    }
                                }

                                ArrayList<Entries> entries = lexicalEntries.get(i).getEntries();
                                if(entries!=null)
                                for(int k=0;k<entries.size();k++) {

                                    if(entries.get(k).getEtymologie()!=null)
                                        Etymologies.add(entries.get(k).getEtymologie().get(0));
                                    else
                                        Etymologies.add("NULL");


                                    ArrayList<GrammaticalFeatures> grammaticalFeatures = entries.get(k).getGrammaticalFeatures();
                                    if(grammaticalFeatures!=null) {
                                        for (int x = 0; x < grammaticalFeatures.size(); x++) {

                                            if(grammaticalFeatures.get(x).getType()!=null)
                                                GramaticalFeaturesType.add(grammaticalFeatures.get(x).getType());
                                            else
                                                GramaticalFeaturesType.add("NULL");


                                            if(grammaticalFeatures.get(x).getText()!=null)
                                                GramaticalFeaturesText.add(grammaticalFeatures.get(x).getText());
                                            else
                                                GramaticalFeaturesText.add("NULL");
                                        }
                                    }

                                    ArrayList<Senses> senses= entries.get(k).getSenses();

                                    if(senses!=null) {
                                        for (int y = 0; y < senses.size(); y++) {

                                            if(senses.get(y).getDefinitions()!=null)
                                                Definitions.add(senses.get(y).getDefinitions().get(0));
                                            else
                                                Definitions.add("NULL");
                                            if (senses.get(y).getDomains() != null)
                                                Domain.add(senses.get(y).getDomains().get(0));
                                            else
                                                Domain.add("NULL");


                                        }
                                    }
                                }
                            }

                            myMeaningClass = new MYMeaningClass(Provider,Language,ID,
                                    LexicalCategories,AudioFiles,PhoneticSpellings,PhoneticNotation,Etymologies,
                                    GramaticalFeaturesText,GramaticalFeaturesType,Definitions,Domain);

                            mClass = myMeaningClass;
                            mClass.setIspopulated("true");


                            //GetGlobal(mClass);
                            //GetGlobal(myMeaningClass);


                            String sense="",def="",pro="",set="";

                            sense=myMeaningClass.getDomain().get(0);
                            if(sense=="NULL")
                                sense=word.toUpperCase(Locale.getDefault());

                            if(myMeaningClass.getDefinitions()!=null)
                                def=myMeaningClass.getDefinitions().get(0);

                            if(myMeaningClass.getPhoneticSpellings()!=null)
                                pro=myMeaningClass.getPhoneticSpellings().get(0);

                            if(myMeaningClass.getDefinitions().size()>1)
                                set = "Press for More";


                            Log.d(TAG, "size for press" + myMeaningClass.getDefinitions().size());


                            fragmentManager.beginTransaction().replace(R.id.fragMeaningHalf,Meaning_Half.newInstance(sense,pro,def,set))
                                    .commit();


                        }
                    }

                    @Override
                    public void onFailure(Call<Meaning> call, Throwable t) {
                    }
                });


                APIService.getApi().getSynonyms(word).enqueue(new Callback<MySynonyms>() {
                    @Override
                    public void onResponse(Call<MySynonyms> call, Response<MySynonyms> response) {


                        if(response.code()==404) {
                            Toast.makeText(MainActivity.this, "Synonyms Not Found", Toast.LENGTH_SHORT).show();
                            mSClass.setIspopulated("false");
                        }
                        else {


                            ArrayList<String> Category = new ArrayList<String>();
                            ArrayList<String> Word = new ArrayList<String>();

                            MySynonyms mySynonyms = response.body();

                            Log.d(TAG, "Provider " + mySynonyms.getMetadata().getProvider());

                            ArrayList<com.example.yash.dictionary.POJOS.Synonyms.Results> results= mySynonyms.getResults();

                            ArrayList<com.example.yash.dictionary.POJOS.Synonyms.LexicalEntries>
                                    lexicalEntries = results.get(0).getLexicalEntries();

                            for (int i = 0; i < lexicalEntries.size(); i++) {

                                Log.d(TAG, "Category " + lexicalEntries.get(i).getLexicalCategory());

                                ArrayList<com.example.yash.dictionary.POJOS.Synonyms.Entries> entries
                                        = lexicalEntries.get(i).getEntries();


                                for (int j = 0; j < entries.size(); j++) {
                                    ArrayList<com.example.yash.dictionary.POJOS.Synonyms.Senses> senses = entries.get(j).getSenses();

                                    for (int k = 0; k < senses.size(); k++) {
                                        ArrayList<Synonyms> synonyms = senses.get(k).getSynonyms();
                                        for (int l = 0; l < synonyms.size(); l++) {

                                            if(lexicalEntries.get(i).getLexicalCategory()!=null)
                                                Category.add(lexicalEntries.get(i).getLexicalCategory());
                                            else
                                                Category.add("");


                                            if(synonyms.get(l).getText()!=null)
                                                Word.add(synonyms.get(l).getText());
                                            else
                                                Word.add("");

                                        }
                                    }
                                }

                                MainSynonymsClass mainSynonymsClass = new MainSynonymsClass(Category,Word);


                                mSClass = mainSynonymsClass;
                                mSClass.setIspopulated("true");

                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<MySynonyms> call, Throwable t) {

                    }
                });


                APIService.getApi().getAntonyms(word).enqueue(new Callback<MyAntonyms>() {
                    @Override
                    public void onResponse(Call<MyAntonyms> call, Response<MyAntonyms> response) {


                        if(response.code()==404) {
                            Toast.makeText(MainActivity.this, "Antonyms Not Found", Toast.LENGTH_SHORT).show();
                            mAClass.setIspopulated("false");
                        }
                        else {


                            ArrayList<String> Category = new ArrayList<String>();
                            ArrayList<String> Word = new ArrayList<String>();

                            MyAntonyms myAntonyms = response.body();

                            Log.d(TAG, "Provider " + myAntonyms.getMetadata().getProvider());

                            ArrayList<com.example.yash.dictionary.POJOS.Antonyms.Results> results= myAntonyms.getResults();

                            ArrayList<com.example.yash.dictionary.POJOS.Antonyms.LexicalEntries>
                                    lexicalEntries = results.get(0).getLexicalEntries();

                            for (int i = 0; i < lexicalEntries.size(); i++) {

                                Log.d(TAG, "Category " + lexicalEntries.get(i).getLexicalCategory());

                                ArrayList<com.example.yash.dictionary.POJOS.Antonyms.Entries> entries
                                        = lexicalEntries.get(i).getEntries();


                                for (int j = 0; j < entries.size(); j++) {
                                    ArrayList<com.example.yash.dictionary.POJOS.Antonyms.Senses> senses = entries.get(j).getSenses();

                                    for (int k = 0; k < senses.size(); k++) {
                                        ArrayList<Antonyms> antonyms = senses.get(k).getAntonyms();
                                        for (int l = 0; l < antonyms.size(); l++) {

                                            if(lexicalEntries.get(i).getLexicalCategory()!=null)
                                                Category.add(lexicalEntries.get(i).getLexicalCategory());
                                            else
                                                Category.add("");


                                            if(antonyms.get(l).getText()!=null)
                                                Word.add(antonyms.get(l).getText());
                                            else
                                                Word.add("");

                                        }
                                    }
                                }

                                MainAntonymsClass mainAntonymsClass = new MainAntonymsClass(Category,Word);


                                mAClass = mainAntonymsClass;
                                mAClass.setIspopulated("true");

                            }

                        }

                    }

                    @Override
                    public void onFailure(Call<MyAntonyms> call, Throwable t) {

                    }
                });

            }
        });

    }

    static void GetGlobal(MYMeaningClass myMeaningClass)
    {
        Log.d(TAG, "Provider: " + myMeaningClass.getProvider());
        Log.d(TAG, "ID: " + myMeaningClass.getID());
        Log.d(TAG, "Language: " + myMeaningClass.getLanguage());
        Log.d(TAG, "LexicalCategory: " + myMeaningClass.getLexicalCategories());
        Log.d(TAG, "AudioFile: " + myMeaningClass.getAudioFiles());
        Log.d(TAG, "Spelling: " + myMeaningClass.getPhoneticSpellings());
        Log.d(TAG, "Notation: " + myMeaningClass.getPhoneticNotation());
        Log.d(TAG, "Etymology: " + myMeaningClass.getEtymologies());
        Log.d(TAG, "Text: " + myMeaningClass.getGramaticalFeaturesText());
        Log.d(TAG, "Type: " + myMeaningClass.getGramaticalFeaturesType());
        Log.d(TAG, "Definition: " + myMeaningClass.getDefinitions());
        Log.d(TAG, "Domain: " + myMeaningClass.getDomain());

    }

}