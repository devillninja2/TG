package com.example.leonardo.blindao;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static com.example.leonardo.blindao.R.id.gif;

public class GifActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);

        ImageView obj = (ImageView)findViewById(R.id.gif);
        Glide.with(getBaseContext())
                .load("@drawable/costaebiceps")
                .into(obj);
    }
}
