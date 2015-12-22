package com.felix.testandroidstyle.animator;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.felix.testandroidstyle.R;

public class ButtonAnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_animator);
        button = (Button) findViewById(R.id.btnAnimator);
        button.setOnClickListener(this);


    }

    public void performAnimator() {
        ViewWrapper viewWrapper = new ViewWrapper(button);
        ObjectAnimator.ofInt(viewWrapper, "width", 1000).setDuration(1000).start();
    }

    @Override
    public void onClick(View v) {
        performAnimator();
    }

    public static class ViewWrapper {
        private View target;

        public ViewWrapper(View view) {
            this.target = view;
        }

        public int getWidth() {
            return target.getLayoutParams().width;
        }

        public void setWidth(int width) {
            target.getLayoutParams().width = width;
            target.requestLayout();
        }
    }
}
