package com.felix.testandroidstyle.transition;

import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.felix.testandroidstyle.R;

public class LayoutTransitionActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout root;

    LinearLayout main;
    Button add, remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_transition2);
        root = (LinearLayout) findViewById(R.id.root);

        main = (LinearLayout) findViewById(R.id.main);

        add = (Button) findViewById(R.id.add);
        remove = (Button) findViewById(R.id.remove);

        add.setOnClickListener(this);
        remove.setOnClickListener(this);

        ObjectAnimator inAnimator = ObjectAnimator.ofFloat(null, "scaleX", 0, 1);
        ObjectAnimator outAnimator1 = ObjectAnimator.ofFloat(null, "scaleX", 1, 0);
        ObjectAnimator outAnimator2 = ObjectAnimator.ofFloat(null, "scaleY", 1, 0);
        AnimatorSet outSet = new AnimatorSet();
        outSet.play(outAnimator1).with(outAnimator2);

        LayoutTransition transition = new LayoutTransition();
        transition.setAnimator(LayoutTransition.APPEARING, inAnimator);
        transition.setAnimator(LayoutTransition.DISAPPEARING, outSet);
        main.setLayoutTransition(transition);
    }

    int count = 0;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                main.addView(new Button(this), params);
                count++;
                break;

            case R.id.remove:
                if (count > 0) {
                    main.removeViewAt(0);
                    count--;
                }
                break;
        }
    }
}
