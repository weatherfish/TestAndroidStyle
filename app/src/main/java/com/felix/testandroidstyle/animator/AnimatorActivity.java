package com.felix.testandroidstyle.animator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.felix.testandroidstyle.R;


public class AnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        findViewById(R.id.btnAnimator).setOnClickListener(this);
        findViewById(R.id.valueAnimator).setOnClickListener(this);
        findViewById(R.id.propertyValuesHolder).setOnClickListener(this);
        findViewById(R.id.evaluatorAnimator).setOnClickListener(this);
        findViewById(R.id.viewPropertyAnimator).setOnClickListener(this);
        findViewById(R.id.keyFrame).setOnClickListener(this);
        findViewById(R.id.layoutTransition).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAnimator:
                startActivity(new Intent(AnimatorActivity.this, ButtonAnimatorActivity.class));
                break;

            case R.id.valueAnimator:
                startActivity(new Intent(AnimatorActivity.this, ValueAnimatorAcitvity.class));
                break;

            case R.id.propertyValuesHolder:
                startActivity(new Intent(AnimatorActivity.this, PropertyValuesHolderActivity.class));
                break;

            case R.id.evaluatorAnimator:
                startActivity(new Intent(AnimatorActivity.this, EvaluatorActivity.class));
                break;

            case R.id.viewPropertyAnimator:
                startActivity(new Intent(AnimatorActivity.this, ViewPropertyAnimatorActivity.class));
                break;

            case R.id.keyFrame:
                startActivity(new Intent(AnimatorActivity.this, KeyFrameActivity.class));
                break;

            case R.id.layoutTransition:
                startActivity(new Intent(AnimatorActivity.this, LayoutTransitionActivity.class));
                break;


        }
    }
}
