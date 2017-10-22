package com.supachai.oramon.myeasyservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.supachai.oramon.myeasyservice.R;

import java.util.zip.Inflater;

/**
 * Created by oramon on 10/22/2017.
 */

public class SecondFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seconnd, container, false);
        return view;
    }
}
