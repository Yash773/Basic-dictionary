package com.example.yash.dictionary.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yash.dictionary.MainActivity;
import com.example.yash.dictionary.POJOS.MYMeaningClass;
import com.example.yash.dictionary.R;

public class Meaning_Full extends AppCompatActivity {

    MYMeaningClass myMeaningClass = new MYMeaningClass();
    public static final String TAG= "ACT2";
    RecyclerView rvRecycleMeaningFull;
    TextView tvMeaningFullProvider, tvMeaningFullId, tvMeaningFullLanguage,tvMeaningFullWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaning__full);

        Intent j = getIntent();
        myMeaningClass = (MYMeaningClass) j.getSerializableExtra("class");

        rvRecycleMeaningFull = (RecyclerView) findViewById(R.id.rvRecycleMeaningFull);
/*
        tvMeaningFullProvider = (TextView) findViewById(R.id.tvMeaningFullProvider);
        tvMeaningFullId = (TextView) findViewById(R.id.tvMeaningFullId);
        tvMeaningFullLanguage = (TextView) findViewById(R.id.tvMeaningFullLanguage);

        tvMeaningFullLanguage.setText(myMeaningClass.getLanguage());
        tvMeaningFullId.setText(myMeaningClass.getID());
        tvMeaningFullProvider.setText("Provided by : " + myMeaningClass.getProvider());
*/

        tvMeaningFullWord = (TextView) findViewById(R.id.tvMeaningFullWord);

        tvMeaningFullWord.setText(myMeaningClass.getID());


        rvRecycleMeaningFull.setLayoutManager(new LinearLayoutManager(Meaning_Full.this));
        final RecycleMeaningFullAdapter ra=new RecycleMeaningFullAdapter();
        rvRecycleMeaningFull.setAdapter(ra);

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


    class RecycleMeaningFullAdapter extends RecyclerView.Adapter<RecycleMeaningFullAdapter.viewHolder>{
        @Override
        public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView = li.inflate(R.layout.meaning_full_card,parent,false);

            return new viewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(viewHolder holder, int position) {
/*
            if (myMeaningClass.getLexicalCategories().size()<position && myMeaningClass.getLexicalCategories().get(position).toString()!="NULL")
                holder.tvMeaningFullLexCate.setText(myMeaningClass.getLexicalCategories().get(position).toString());
            else
                holder.tvMeaningFullLexCate.setText("");

            if (myMeaningClass.getPhoneticSpellings().size()<position && myMeaningClass.getPhoneticSpellings().get(position).toString()!="NULL")
                holder.tvMeaningFullPhonSpell.setText(myMeaningClass.getPhoneticSpellings().get(position).toString());
            else
                holder.tvMeaningFullPhonSpell.setText("");



            //tvMeaningFullAudio = (TextView) itemView.findViewById(R.id.tvMeanFullAudio);


            if (myMeaningClass.getEtymologies().size()<position && myMeaningClass.getEtymologies().get(position).toString()!="NULL")
                holder.tvMeaningFullEtymology.setText(myMeaningClass.getEtymologies().get(position).toString());
            else
                holder.tvMeaningFullEtymology.setText("");

            if (myMeaningClass.getGramaticalFeaturesText().size()<position && myMeaningClass.getGramaticalFeaturesText().get(position).toString()!="NULL")
                holder.tvMeaningFullGramText.setText(myMeaningClass.getGramaticalFeaturesText().get(position).toString());
            else
                holder.tvMeaningFullGramText.setText("");

            if(myMeaningClass.getGramaticalFeaturesType().size()<position && myMeaningClass.getGramaticalFeaturesType().get(position).toString()!="NULL")
                holder.tvMeaningFullGramType.setText(myMeaningClass.getGramaticalFeaturesType().get(position).toString());
            else
                holder.tvMeaningFullGramType.setText("");
*/
            if(myMeaningClass.getDomain().get(position).toString().equals("NULL"))
                holder.tvMeaningFullDomain.setText("Generally : ");
            else
                holder.tvMeaningFullDomain.setText("in " + myMeaningClass.getDomain().get(position).toString() + " :");

            if (!myMeaningClass.getDefinitions().get(position).toString().equals("NULL"))
                holder.tvMeaningFullDef.setText(myMeaningClass.getDefinitions().get(position).toString());

        }

        @Override
        public int getItemCount() {
            return myMeaningClass.getDefinitions().size();
        }

        class viewHolder extends RecyclerView.ViewHolder{

            TextView tvMeaningFullLexCate,tvMeaningFullPhonSpell,tvMeaningFullAudio,tvMeaningFullEtymology,
                    tvMeaningFullGramText,tvMeaningFullGramType,tvMeaningFullDomain,tvMeaningFullDef;

            public viewHolder(View itemView) {
                super(itemView);

                //tvMeaningFullLexCate = (TextView) itemView.findViewById(R.id.tvMeanFullLexCate);
               // tvMeaningFullPhonSpell = (TextView) itemView.findViewById(R.id.tvMeanFullPhonSpell);
                //tvMeaningFullAudio = (TextView) itemView.findViewById(R.id.tvMeanFullAudio);
                //tvMeaningFullEtymology = (TextView) itemView.findViewById(R.id.tvMeanFullEtymology);
                //tvMeaningFullGramText = (TextView) itemView.findViewById(R.id.tvMeanFullGramText);
                //tvMeaningFullGramType = (TextView) itemView.findViewById(R.id.tvMeanFullGramType);
                tvMeaningFullDomain = (TextView) itemView.findViewById(R.id.tvMeanFullDomain);
                tvMeaningFullDef = (TextView) itemView.findViewById(R.id.tvMeanFullDef);
            }
        }

    }



}
