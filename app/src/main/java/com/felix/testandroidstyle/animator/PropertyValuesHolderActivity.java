package com.felix.testandroidstyle.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.felix.testandroidstyle.R;

public class PropertyValuesHolderActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    Button normal, pvh, set1, set2, set3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_values_holder);
        imageView = (ImageView) findViewById(R.id.image_pvh);
        pvh = (Button) findViewById(R.id.pvh);
        normal = (Button) findViewById(R.id.normal);
        set1 = (Button) findViewById(R.id.set1);
        set2 = (Button) findViewById(R.id.set2);
        set3 = (Button) findViewById(R.id.set3);

        pvh.setOnClickListener(this);
        normal.setOnClickListener(this);
        set1.setOnClickListener(this);
        set2.setOnClickListener(this);
        set3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.normal:
                ObjectAnimator.ofFloat(imageView, "translationX", 0, 360).setDuration(1000).start();
                ObjectAnimator.ofFloat(imageView, "translationY", 0, 360).setDuration(1000).start();
                ObjectAnimator.ofFloat(imageView, "rotation", 0, 360).setDuration(1000).start();
                break;

            case R.id.pvh:
                PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("translationX", 0, 360);
                PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationY", 0, 360);
                PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("rotation", 0, 360);
                ObjectAnimator.ofPropertyValuesHolder(imageView, p1, p2, p3).setDuration(1000).start();
                break;

            case R.id.set1:
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "translationX", 0, 360);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "translationY", 0, 360);
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "rotation", 0, 360);
                AnimatorSet animatorSet1 = new AnimatorSet();
                animatorSet1.playSequentially(animator1, animator2, animator3);
                animatorSet1.setDuration(1000);
                animatorSet1.start();
                break;

            case R.id.set2:
                ObjectAnimator animator21 = ObjectAnimator.ofFloat(imageView, "translationX", 0, 360);
                ObjectAnimator animator22 = ObjectAnimator.ofFloat(imageView, "translationY", 0, 360);
                ObjectAnimator animator23 = ObjectAnimator.ofFloat(imageView, "rotation", 0, 360);
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(animator21, animator22, animator23);
                animatorSet2.setDuration(1000);
                animatorSet2.start();
                break;

            case R.id.set3:
                ObjectAnimator animator31 = ObjectAnimator.ofFloat(imageView, "translationX", 0, 360);
                ObjectAnimator animator32 = ObjectAnimator.ofFloat(imageView, "translationY", 0, 360);
                ObjectAnimator animator33 = ObjectAnimator.ofFloat(imageView, "rotation", 0, 360);
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.play(animator31).after(animator32).before(animator33);
                animatorSet3.setDuration(1000);
                animatorSet3.start();
                break;
        }
    }
}
