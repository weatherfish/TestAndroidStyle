package com.felix.testandroidstyle.transition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.felix.testandroidstyle.R;

public class TransitionActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewGroup root;
    private View imageView;
    private View textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        imageView = (ImageView) findViewById(R.id.image);
        textView = (TextView) findViewById(R.id.textView);
        root = (ViewGroup) findViewById(R.id.root);

        imageView.setOnClickListener(this);
        findViewById(R.id.transitionDemo).setOnClickListener(this);
        findViewById(R.id.transitionExplode).setOnClickListener(this);
        findViewById(R.id.transitionFade).setOnClickListener(this);
        findViewById(R.id.transitionSlide).setOnClickListener(this);
        findViewById(R.id.transitionManager).setOnClickListener(this);
        findViewById(R.id.transitionShared).setOnClickListener(this);
        findViewById(R.id.layoutTransition).setOnClickListener(this);
        findViewById(R.id.layoutAnimationController).setOnClickListener(this);
        findViewById(R.id.listLayoutTransition).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.transitionDemo:
                TransitionManager.beginDelayedTransition(root);
                ViewGroup.LayoutParams params = imageView.getLayoutParams();
                params.height = 800;
                params.width = 800;
                imageView.setLayoutParams(params);
                break;

            case R.id.transitionExplode:
                Explode explode = new Explode();
                explode.setDuration(1500);
                explode.setInterpolator(new AccelerateDecelerateInterpolator());
                getWindow().setEnterTransition(explode);
                getWindow().setExitTransition(explode);
                startActivity(new Intent(this, TransitionTargetActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.transitionFade:
                Fade fade = new Fade(Fade.IN);
                fade.setDuration(1500);
                fade.setInterpolator(new DecelerateInterpolator());
                getWindow().setEnterTransition(fade);
                getWindow().setExitTransition(fade);
                startActivity(new Intent(this, TransitionTargetActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;

            case R.id.transitionSlide:
                getWindow().setEnterTransition(new Slide(Gravity.LEFT));
                getWindow().setExitTransition(new Slide(Gravity.RIGHT));
                startActivity(new Intent(this, TransitionTargetActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;

            case R.id.transitionManager:
                startActivity(new Intent(this, TransitionManagerActivity.class));
                break;

            case R.id.image:
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(this,
                        Pair.create(imageView, "imageView"),
                        Pair.create(textView, "textView"));
                startActivity(new Intent(this, TransitionSharedActivity.class), activityOptions.toBundle());
                break;

            case R.id.layoutTransition:
                startActivity(new Intent(this, LayoutTransitionActivity.class));
                break;

            case R.id.layoutAnimationController:
                startActivity(new Intent(this, LayoutAnimationControllerActivity.class));
                break;

            case R.id.listLayoutTransition:
                startActivity(new Intent(this, ListLayoutTransitionActivity.class));
                break;
        }
    }
}
