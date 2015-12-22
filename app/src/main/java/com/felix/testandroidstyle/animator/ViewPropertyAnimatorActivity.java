package com.felix.testandroidstyle.animator;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.felix.testandroidstyle.R;

public class ViewPropertyAnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_property_animator);
        imageView  = (ImageView) findViewById(R.id.image_view);
        button = (Button) findViewById(R.id.btn_view);

        button.setOnClickListener(this);
    }

    int COUNT = 3;
    int value = 0;
    @Override
    public void onClick(View v) {
        switch (value % COUNT){
            case 0:
                imageView.animate().alpha(0.3f).setDuration(1000).start();
                break;
            case 1:
                imageView.animate().rotationX(300).rotationY(200).alpha(0.8f).rotationX(-100).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(2000);
                break;
            case 2:
                imageView.animate().scaleX(3).scaleY(5).setUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Log.d("ViewPropertyAnimator", animation.getAnimatedValue()+"--");
                    }
                }).setInterpolator(new BounceInterpolator()).setDuration(2000);
        }
        value++;
    }
}
