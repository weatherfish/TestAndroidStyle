package com.felix.testandroidstyle.transition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.felix.testandroidstyle.R;

public class TransitionManagerActivity extends AppCompatActivity implements View.OnClickListener {

    private TransitionManager transitionManager;

    Scene scene1, scene2, scene3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_manager);

        findViewById(R.id.btnScene1).setOnClickListener(this);
        findViewById(R.id.btnScene2).setOnClickListener(this);
        findViewById(R.id.btnScene3).setOnClickListener(this);

        ViewGroup root = (ViewGroup) findViewById(R.id.root);
        TransitionInflater inflater = TransitionInflater.from(this);
        transitionManager = inflater.inflateTransitionManager(R.transition.transition_manager, root);

        scene1 = Scene.getSceneForLayout(root, R.layout.scene1, this);
        scene2 = Scene.getSceneForLayout(root, R.layout.scene2, this);
        scene3 = Scene.getSceneForLayout(root, R.layout.scene3, this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnScene1:
                transitionManager.transitionTo(scene1);
                break;

            case R.id.btnScene2:
                gotoScene(scene2);
                break;

            case R.id.btnScene3:
                transitionManager.transitionTo(scene3);
                break;
        }
    }

    private void gotoScene(Scene scene) {
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(1000);
        changeBounds.setInterpolator(new AccelerateDecelerateInterpolator());

        Fade fadeOut = new Fade(Fade.OUT);
        fadeOut.setDuration(800);

        Fade fadeIn = new Fade(Fade.IN);
        fadeOut.setDuration(800);

        TransitionSet set = new TransitionSet();
        set.setOrdering(TransitionSet.ORDERING_SEQUENTIAL);
        set.addTransition(fadeOut).addTransition(changeBounds).addTransition(fadeIn);
        transitionManager.go(scene, set);
    }
}
