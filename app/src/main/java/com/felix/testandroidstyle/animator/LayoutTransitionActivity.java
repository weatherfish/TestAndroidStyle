package com.felix.testandroidstyle.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.felix.testandroidstyle.R;

public class LayoutTransitionActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout parent;
    private int i = 0;
    LayoutTransition layoutTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_transition);
        parent = (LinearLayout) findViewById(R.id.parent);
        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.remove).setOnClickListener(this);

        initTransition();
        setTransition();
    }

    private void setTransition() {
        /**
         * view 出现时 view动画
         */
        final ObjectAnimator animator1 = ObjectAnimator.ofFloat(null, "rotationY", 90, 0).setDuration(layoutTransition.getDuration(LayoutTransition.APPEARING));
        layoutTransition.setAnimator(LayoutTransition.APPEARING, animator1);

        //view消失时,view动画
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(null, "rotationX", 0, 90, 0).setDuration(layoutTransition.getDuration(LayoutTransition.DISAPPEARING));
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, animator2);

        //view改变时,布局中的每个子view动画的时间间隔
        layoutTransition.setStagger(LayoutTransition.CHANGE_APPEARING, 50);
        layoutTransition.setStagger(LayoutTransition.CHANGE_DISAPPEARING, 80);

        //初始化四个动画,改变view的四个值,left,right,top,right, 然后构造view出现时,整个布局改变的动画
        PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofInt("left", 0, 1);
        PropertyValuesHolder pvhRight = PropertyValuesHolder.ofInt("right", 0, 1);
        PropertyValuesHolder pvhTop = PropertyValuesHolder.ofInt("top", 0, 1);
        PropertyValuesHolder pvhBottom = PropertyValuesHolder.ofInt("bottom", 0, 1);
        PropertyValuesHolder holder = PropertyValuesHolder.ofFloat("scaleX", 1f, 2f, 3f);
        ObjectAnimator changeIn = ObjectAnimator.ofPropertyValuesHolder(this, pvhLeft, pvhTop, pvhRight, pvhBottom, holder).setDuration(layoutTransition.getDuration(LayoutTransition.CHANGE_APPEARING));
        changeIn.addListener(new AnimatorListenerAdapter() {
            //监听动画结束的时候,将缩放还原
            @Override
            public void onAnimationEnd(Animator animation) {
                ObjectAnimator objectAnimator = (ObjectAnimator) animation;
                View view = (View) objectAnimator.getTarget();
                view.setScaleX(1.0f);
            }
        });
        layoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, changeIn);

        //view消失,整个布局的动画
        Keyframe keyframe1 = Keyframe.ofFloat(0, 0);
        Keyframe keyframe2 = Keyframe.ofFloat(0.5f, 2.0f);
        Keyframe keyframe3 = Keyframe.ofFloat(1.0f, 0);

        PropertyValuesHolder rotateHolder = PropertyValuesHolder.ofKeyframe("scaleX", keyframe1, keyframe2, keyframe3);
        ObjectAnimator changeOut = ObjectAnimator.ofPropertyValuesHolder(this, pvhLeft, pvhTop, pvhRight, pvhBottom, rotateHolder).setDuration(layoutTransition.getDuration(LayoutTransition.DISAPPEARING));
        changeOut.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                ObjectAnimator objectAnimator = (ObjectAnimator) animation;
                View view = (View) objectAnimator.getTarget();
                view.setScaleX(1.0f);
            }
        });
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, changeOut);
    }

    private void initTransition() {
        layoutTransition = new LayoutTransition();
        parent.setLayoutTransition(layoutTransition);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:
                addView();
                break;

            case R.id.remove:
                removeView();
                break;
        }
    }

    private void removeView() {
        if (i > 0) {
            parent.removeViewAt(0);
        }
    }

    private void addView() {
        i++;
        Button button = new Button(this);
        button.setText("Button" + i);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        parent.addView(button, Math.min(1, parent.getChildCount()), params);
    }

//    private void initAnim(){
//        Animation animation = AnimationUtils.loadAnimation(this,R.anim.left);
//
//        LayoutAnimationController controller = new LayoutAnimationController(animation);
//        controller.setOrder(LayoutAnimationController.ORDER_REVERSE);
//        controller.setDelay(11);
//        listView.setLayoutAnimation(controller);
//    }

}
