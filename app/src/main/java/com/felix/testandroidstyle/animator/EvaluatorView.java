package com.felix.testandroidstyle.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by weatherfish on 15/12/21.
 */

public class EvaluatorView extends View {

    public static final float RADIUS = 50;
    private Point currentPoint;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);;
    private int color = Color.BLUE;

    public void setColor(int color) {
        this.color = color;
        mPaint.setColor(color);
        invalidate();
    }

    public int getColor() {
        return color;
    }

    public EvaluatorView(Context context) {
        this(context, null);
    }

    public EvaluatorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EvaluatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint.setColor(color);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (currentPoint == null) {
            currentPoint = new Point(RADIUS, RADIUS);
            drawCircle(canvas);
            startAnimator2();
        } else {
            drawCircle(canvas);
        }
    }

    private void startAnimator() {
        Point start = new Point(RADIUS, RADIUS);
        Point end = new Point(getWidth() - RADIUS, getHeight() - RADIUS);
        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(), start, end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });

        ObjectAnimator animator2 = ObjectAnimator.ofArgb(this,"color",0xFF0000FF,0xFFFF0000);
        AnimatorSet set = new AnimatorSet();
        set.play(animator).with(animator2);
        set.setDuration(3000);
        set.start();
    }

    private void startAnimator2() {
        Point start = new Point(getWidth()/2, RADIUS);
        Point end = new Point(getWidth()/2, getHeight() - RADIUS);
        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(), start, end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });

        ObjectAnimator animator2 = ObjectAnimator.ofArgb(this,"color",0xFF0000FF,0xFFFF0000);
        AnimatorSet set = new AnimatorSet();
        set.play(animator).with(animator2);
        set.setInterpolator(new MyInterpolator());
        set.setDuration(3000);
        set.start();
    }

    private void drawCircle(Canvas canvas) {
        canvas.drawCircle(currentPoint.getX(), currentPoint.getY(), RADIUS, mPaint);
    }
}
