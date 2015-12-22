package com.felix.testandroidstyle.drawables;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.felix.testandroidstyle.R;

public class AnimationListActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_list);
        imageView = (ImageView) findViewById(R.id.image_animation_list);
        final AnimationDrawable drawable = (AnimationDrawable) imageView.getDrawable();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                drawable.start();
            }
        }, 1000);
    }
}
