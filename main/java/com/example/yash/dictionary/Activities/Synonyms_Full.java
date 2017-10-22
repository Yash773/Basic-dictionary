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

import com.example.yash.dictionary.POJOS.MYMeaningClass;
import com.example.yash.dictionary.POJOS.Synonyms.MainSynonymsClass;
import com.example.yash.dictionary.POJOS.Synonyms.MySynonyms;
import com.example.yash.dictionary.R;

public class Synonyms_Full extends AppCompatActivity {


    MainSynonymsClass mClass = new MainSynonymsClass();

    public static final String TAG= "ACT3";

    RecyclerView rvRecycleSynonymsFull;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synonyms__full);

        Intent j = getIntent();
        mClass = (MainSynonymsClass) j.getSerializableExtra("class");



        rvRecycleSynonymsFull = (RecyclerView) findViewById(R.id.rvRecycleSynonymsFull);

        rvRecycleSynonymsFull.setLayoutManager(new LinearLayoutManager(Synonyms_Full.this));
        final RecycleSynonymsAdapter ra=new RecycleSynonymsAdapter();
        rvRecycleSynonymsFull.setAdapter(ra);

    }


    class RecycleSynonymsAdapter extends RecyclerView.Adapter<RecycleSynonymsAdapter.viewHolder>
    {
        @Override
        public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView = li.inflate(R.layout.synonym_full_card,parent,false);

            return new viewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(viewHolder holder, int position) {


            holder.Word.setText(mClass.getWord().get(position).toString());
            holder.Category.setText(mClass.getCategory().get(position).toString());

        }

        @Override
        public int getItemCount() {
            return mClass.getCategory().size();
        }

        class viewHolder extends RecyclerView.ViewHolder{

            TextView Word,Category;

            public viewHolder(View itemView) {
                super(itemView);

                Word = (TextView) itemView.findViewById(R.id.tvSynonymsFullWord);
                Category = (TextView) itemView.findViewById(R.id.tvSynonymsFullCategory);

            }
        }

    }


}
