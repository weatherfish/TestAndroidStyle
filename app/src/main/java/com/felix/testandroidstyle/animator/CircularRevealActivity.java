package com.felix.testandroidstyle.animator;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.felix.testandroidstyle.R;

public class CircularRevealActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
int i = 0;
    final int COUNT = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_reveal);

        imageView = (ImageView) findViewById(R.id.image_circular);
        button = (Button) findViewById(R.id.btn_circular);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator animator;
                switch (i%COUNT){
                    case 0:
                        animator = ViewAnimationUtils.createCircularReveal(imageView, imageView.getWidth() / 2, imageView.getHeight() / 2, imageView.getWidth(), 0);
                        animator.setInterpolator(new AccelerateInterpolator());
                        animator.setDuration(800);
                        animator.start();
                        break;

                    case 1:
                        animator = ViewAnimationUtils.createCircularReveal(imageView, 0,0,0, (float) Math.hypot(imageView.getWidth(), imageView.getHeight()));
                        animator.setInterpolator(new AccelerateInterpolator());
                        animator.setDuration(800);
                        animator.start();
                        break;
                }
                i++;
            }
        });

    }
}
