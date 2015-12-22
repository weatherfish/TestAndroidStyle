package com.felix.testandroidstyle.animator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.felix.testandroidstyle.R;

public class ValueAnimatorAcitvity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Animator animator = createColorChange();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator_acitvity);

        textView = (TextView) findViewById(R.id.text_animator);

        findViewById(R.id.valueChange).setOnClickListener(this);
        findViewById(R.id.valueColorChange).setOnClickListener(this);
        findViewById(R.id.start).setOnClickListener(this);
        findViewById(R.id.startDelay).setOnClickListener(this);
        findViewById(R.id.pause).setOnClickListener(this);
        findViewById(R.id.resume).setOnClickListener(this);
        findViewById(R.id.end).setOnClickListener(this);
        findViewById(R.id.cancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.valueChange:
                valueAnimatorChange();
                break;
            case R.id.valueColorChange:
                valueAnimatorColorChange();
                break;
            case R.id.start:
                animator.start();
                break;

            case R.id.startDelay:
                if (!animator.isStarted()) {
                    animator.setStartDelay(10000);
                    animator.start();
                }
                break;

            case R.id.pause:
                if (animator.isRunning())
                    animator.pause();
                break;

            case R.id.resume:
                if (animator.isPaused())
                    animator.resume();
                break;
            case R.id.end:
                if (animator.isRunning())
                    animator.end();
                break;

            case R.id.cancel:
                if (animator.isRunning())
                    animator.cancel();
                break;
        }
    }

    private void valueAnimatorChange() {
        ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f);
        animator.setDuration(1000);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                float current = (float) animation.getAnimatedValue();
                textView.setTextSize(10 * current);
                Log.d("onAnimationUpdate", current + "");
            }
        });
        animator.start();
    }

    private Animator createColorChange() {
        ValueAnimator animator = ValueAnimator.ofArgb(0xFFFF0000, 0xFF0000FF);
        animator.setDuration(10000);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int current = (int) animation.getAnimatedValue();
                textView.setTextColor(current);
                Log.d("onAnimationUpdate", current + "");
            }
        });

        animator.addPauseListener(new Animator.AnimatorPauseListener() {
            @Override
            public void onAnimationPause(Animator animation) {
                Log.e("ValueAnimatorActivity", "onAnimationPause");
            }

            @Override
            public void onAnimationResume(Animator animation) {
                Log.e("ValueAnimatorActivity", "onAnimationResume");
            }
        });

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.e("ValueAnimatorActivity", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.e("ValueAnimatorActivity", "onAnimationEnd");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.e("ValueAnimatorActivity", "onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.e("ValueAnimatorActivity", "onAnimationRepeat");
            }
        });
        return animator;
    }

    private void valueAnimatorColorChange() {
        createColorChange().start();
    }
}
