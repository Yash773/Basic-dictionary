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

import com.example.yash.dictionary.POJOS.Antonyms.MainAntonymsClass;
import com.example.yash.dictionary.POJOS.Synonyms.MainSynonymsClass;
import com.example.yash.dictionary.R;

public class Antonyms_Full extends AppCompatActivity {


    MainAntonymsClass mClass = new MainAntonymsClass();

    RecyclerView rvRecycleAntonymsFull;

    public static final String TAG= "ACT4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antonyms__full);
        Intent j = getIntent();
        mClass = (MainAntonymsClass) j.getSerializableExtra("class");

        rvRecycleAntonymsFull = (RecyclerView) findViewById(R.id.rvRecycleAntonymsFull);

        rvRecycleAntonymsFull.setLayoutManager(new LinearLayoutManager(Antonyms_Full.this));
        final RecycleAntonymsAdapter ra=new RecycleAntonymsAdapter();
        rvRecycleAntonymsFull.setAdapter(ra);
    }




    class RecycleAntonymsAdapter extends RecyclerView.Adapter<RecycleAntonymsAdapter.viewHolder>
    {
        @Override
        public RecycleAntonymsAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView = li.inflate(R.layout.antonyms_full_card,parent,false);

            return new viewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(RecycleAntonymsAdapter.viewHolder holder, int position) {


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

                Word = (TextView) itemView.findViewById(R.id.tvAntonymsFullWord);
                Category = (TextView) itemView.findViewById(R.id.tvAntonymsFullCategory);

            }
        }

    }

}
