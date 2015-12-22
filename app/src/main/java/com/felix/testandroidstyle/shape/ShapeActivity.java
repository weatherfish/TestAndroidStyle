package com.felix.testandroidstyle.shape;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.felix.testandroidstyle.R;

public class ShapeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);
        findViewById(R.id.rectangle).setOnClickListener(this);
        findViewById(R.id.line).setOnClickListener(this);
        findViewById(R.id.oval).setOnClickListener(this);
        findViewById(R.id.ring).setOnClickListener(this);
        findViewById(R.id.selector).setOnClickListener(this);
        findViewById(R.id.layerlist).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rectangle:
                startActivity(new Intent(ShapeActivity.this, RectangleActivity.class));
                break;

            case R.id.line:
                startActivity(new Intent(ShapeActivity.this, LineActivity.class));
                break;

            case R.id.oval:
                startActivity(new Intent(ShapeActivity.this, OvalActivity.class));
                break;

            case R.id.ring:
                startActivity(new Intent(ShapeActivity.this, RingActivity.class));
                break;

            case R.id.selector:
                startActivity(new Intent(ShapeActivity.this, SelectorActivity.class));
                break;
            case R.id.layerlist:
                startActivity(new Intent(ShapeActivity.this, LayerListActivity.class));
                break;
        }
    }
}
