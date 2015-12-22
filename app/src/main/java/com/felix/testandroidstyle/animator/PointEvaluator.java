package com.felix.testandroidstyle.animator;

import android.animation.TypeEvaluator;

/**
 * Created by weatherfish on 15/12/21.
 */

public class PointEvaluator implements TypeEvaluator<Point> {

    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        float x = startValue.getX() + fraction * (endValue.getX() - startValue.getX());
        float y = startValue.getY() + fraction * (endValue.getY() - startValue.getY());
        return new Point(x, y);
    }
}
