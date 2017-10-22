package com.example.yash.dictionary.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yash.dictionary.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AntonymsHalf extends Fragment {

    public static final String ARG_IsTrue = "IsTrue";

    private String istrue;

    public AntonymsHalf() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_antonyms_half, container, false);
    }

}
