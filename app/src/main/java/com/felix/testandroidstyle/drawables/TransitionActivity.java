package com.felix.testandroidstyle.drawables;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.felix.testandroidstyle.R;

public class TransitionActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        imageView = (ImageView) findViewById(R.id.image_transition);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TransitionDrawable drawable = (TransitionDrawable) imageView.getDrawable();
                drawable.startTransition(2000);
            }
        }, 1000);
    }
}
