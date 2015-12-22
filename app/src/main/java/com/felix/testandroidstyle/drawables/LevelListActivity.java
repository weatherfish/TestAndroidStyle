package com.felix.testandroidstyle.drawables;

import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.felix.testandroidstyle.R;

public class LevelListActivity extends AppCompatActivity {

    ImageView imageView;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_list);
        imageView = (ImageView) findViewById(R.id.image_level_list);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LevelListDrawable drawable = (LevelListDrawable) imageView.getDrawable();
                drawable.setLevel((drawable.getLevel()+1) % 4);
            }
        });
    }
}
