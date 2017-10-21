package com.supachai.oramon.myeasyservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.supachai.oramon.myeasyservice.R;

/**
 * Created by oramon on 10/21/2017.
 */

public class MainFragment extends Fragment{

//    การสร้างหน้ากาก เลือก oncreate view กด mouse ขวา กด generate เลือก overide
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // new view from xml fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }
} // Main Class
