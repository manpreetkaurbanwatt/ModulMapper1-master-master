package com.example.modulmapper;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragmentinfo extends Fragment {


    @Override
    public View onCreateView( LayoutInflater inflater,ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_information,container,false);
    }
}
