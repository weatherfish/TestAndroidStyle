package com.felix.testandroidstyle.animator;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.felix.testandroidstyle.R;

public class KeyFrameActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_frame);

        imageView = (ImageView) findViewById(R.id.keyFrameImage);
        button = (Button) findViewById(R.id.keyFrameBtn);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Keyframe keyframe1 = Keyframe.ofFloat(0,0);
        Keyframe keyframe2 = Keyframe.ofFloat(.8f, 100);
        Keyframe keyframe3 = Keyframe.ofFloat(.9f, 200);
        Keyframe keyframe4 = Keyframe.ofFloat(1f, 300);
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofKeyframe("translationY", keyframe1, keyframe2, keyframe3, keyframe4);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(imageView, propertyValuesHolder);
        animator.setDuration(20000);
        animator.start();


    }
}
