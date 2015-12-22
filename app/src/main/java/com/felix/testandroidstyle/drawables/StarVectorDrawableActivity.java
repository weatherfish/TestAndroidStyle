package com.felix.testandroidstyle.drawables;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.felix.testandroidstyle.R;

public class StarVectorDrawableActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_vector_drawable);
        imageView = (ImageView) findViewById(R.id.star);
        AnimatedVectorDrawable drawable = (AnimatedVectorDrawable) imageView.getDrawable();
        drawable.start();
    }
}
