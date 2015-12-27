package com.felix.testandroidstyle.transition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

import com.felix.testandroidstyle.R;

public class LayoutAnimationControllerActivity extends AppCompatActivity {

    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_tran_manager);
        root = (LinearLayout) findViewById(R.id.root);

        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1);
        scaleAnimation.setDuration(3000);

        LayoutAnimationController lac = new LayoutAnimationController(scaleAnimation, .5f);
        lac.setOrder(LayoutAnimationController.ORDER_REVERSE);
        root.setLayoutAnimation(lac);
    }
}
