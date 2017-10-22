package com.supachai.oramon.myeasyservice.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.supachai.oramon.myeasyservice.R;

import java.util.zip.Inflater;

/**
 * Created by oramon on 10/22/2017.
 */

public class SecondFragment extends Fragment{

    private ImageView imageView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Back Controller
        backController();

        //Image Controller
        imageController();

    } // Main Method

    // Retrieve data back from activity base on request code (1)
    // เเลือก รูปภาพ แล้วมีการเลือก จริงเปล่า จะเป็น result OK
    //
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == getActivity().RESULT_OK) {

            try {
                Uri uri = data.getData();
                Bitmap bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(uri));
                imageView.setImageBitmap(bitmap);

            } catch(Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(getActivity(),"Not Choose Image",Toast.LENGTH_SHORT).show();
        }
    }

    private void imageController() {
        imageView = getView().findViewById(R.id.invIronman);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent.createChooser(intent,"Please Choose APP"),1);
            }
        });
    }

    private void backController() {
        Button button = getView().findViewById(R.id.btnBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seconnd, container, false);
        return view;
    }
}
