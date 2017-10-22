package com.example.yash.dictionary.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yash.dictionary.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Meaning_Half extends Fragment {

    private static final String Args_Sense = "sense";
    private static final String Args_Pro = "pro";
    private static final String Args_Def = "def";
    private static final String Args_Set = "set";

    String sense,pro,def,set;


    public Meaning_Half() {
        // Required empty public constructor
    }

    public static Meaning_Half newInstance(String sense,String pro,String def,String set) {
        Meaning_Half fragment = new Meaning_Half();
        Bundle args = new Bundle();
        args.putString(Args_Sense,sense);
        args.putString(Args_Pro,pro);
        args.putString(Args_Def,def);
        args.putString(Args_Set,set);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.sense = getArguments().getString(Args_Sense);
            this.pro = getArguments().getString(Args_Pro);
            this.def = getArguments().getString(Args_Def);
            this.set = getArguments().getString(Args_Set);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment

        View itemView = inflater.inflate(R.layout.fragment_meaning__half, container, false);

        TextView tvMeaningHalfDefination,tvMeaningHalfSense,tvMeaningHalfPronunciation,tvMeaningHalfPressForMore;


        tvMeaningHalfSense = (TextView) itemView.findViewById(R.id.tvMeaningHalfSense);
        tvMeaningHalfDefination = (TextView) itemView.findViewById(R.id.tvMeaningHalfDefination);
        tvMeaningHalfPronunciation = (TextView) itemView.findViewById(R.id.tvMeaningHalfPronunciation);
        tvMeaningHalfPressForMore = (TextView) itemView.findViewById(R.id.tvMeaningHalfPressForMore);

        if(sense!=null||sense!="NULL")
            tvMeaningHalfSense.setText(sense);
        else
            tvMeaningHalfSense.setText("");


        if(pro!=null||pro!="NULL")
            tvMeaningHalfPronunciation.setText(pro);
        else
            tvMeaningHalfPronunciation.setText("");

        if(def!=null||def!="NULL")
            tvMeaningHalfDefination.setText(def);
        else
            tvMeaningHalfDefination.setText("");

        if(set!=null||set!="NULL")
            tvMeaningHalfPressForMore.setText(set);
        else
            tvMeaningHalfPressForMore.setText("");


        return itemView;
    }

}
