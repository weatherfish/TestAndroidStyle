package com.felix.testandroidstyle.drawables;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.felix.testandroidstyle.R;

public class VectorDrawableActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_drawable);

        imageView = (ImageView) findViewById(R.id.animator_vector);
        AnimatedVectorDrawable drawable = (AnimatedVectorDrawable) imageView.getDrawable();
        drawable.start();
    }
}
