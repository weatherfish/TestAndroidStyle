package com.felix.testandroidstyle.drawables;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.felix.testandroidstyle.R;

public class AnimatedSelectorActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_selector);
        imageView = (ImageView) findViewById(R.id.image_animated_selector);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setActivated(!imageView.isActivated());
            }
        });
    }
}
