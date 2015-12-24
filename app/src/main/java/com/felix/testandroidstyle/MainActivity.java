package com.felix.testandroidstyle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.felix.testandroidstyle.animator.AnimatorActivity;
import com.felix.testandroidstyle.transition.TransitionActivity;
import com.felix.testandroidstyle.drawables.DrawablesActivity;
import com.felix.testandroidstyle.shape.ShapeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.shape).setOnClickListener(this);
        findViewById(R.id.drawable).setOnClickListener(this);
        findViewById(R.id.animator).setOnClickListener(this);
        findViewById(R.id.transition).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shape:
                startActivity(new Intent(MainActivity.this, ShapeActivity.class));
                break;

            case R.id.drawable:
                startActivity(new Intent(MainActivity.this, DrawablesActivity.class));
                break;
            case R.id.animator:
                startActivity(new Intent(MainActivity.this, AnimatorActivity.class));
                break;

            case R.id.transition:
                startActivity(new Intent(MainActivity.this, TransitionActivity.class));
                break;
        }
    }
}
