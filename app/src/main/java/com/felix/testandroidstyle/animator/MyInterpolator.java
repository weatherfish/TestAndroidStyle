package com.felix.testandroidstyle.animator;

import android.animation.TimeInterpolator;

import java.util.Random;

/**
 * Created by weatherfish on 15/12/21.
 */

public class MyInterpolator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        return new Random().nextFloat() * input;
    }
}
