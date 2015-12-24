package com.felix.testandroidstyle.drawables;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.felix.testandroidstyle.R;

public class DrawablesActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawables);

        findViewById(R.id.bitmap).setOnClickListener(this);
        findViewById(R.id.tintBitmap).setOnClickListener(this);
        findViewById(R.id.ninePatch).setOnClickListener(this);
        findViewById(R.id.insertDrawable).setOnClickListener(this);
        findViewById(R.id.clipDrawable).setOnClickListener(this);
        findViewById(R.id.scaleDrawable).setOnClickListener(this);
        findViewById(R.id.rotateDrawable).setOnClickListener(this);
        findViewById(R.id.animationListDrawable).setOnClickListener(this);
        findViewById(R.id.layerListDrawable).setOnClickListener(this);
        findViewById(R.id.levelListDrawable).setOnClickListener(this);
        findViewById(R.id.animatedRotateDrawable).setOnClickListener(this);
        findViewById(R.id.animatedSelectorDrawable).setOnClickListener(this);
        findViewById(R.id.vectorDrawable).setOnClickListener(this);
        findViewById(R.id.starVectorDrawable).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bitmap:
                startActivity(new Intent(DrawablesActivity.this, BitmapDrawableActivity.class));
                break;
            case R.id.tintBitmap:
                startActivity(new Intent(DrawablesActivity.this, TintActivity.class));
                break;
            case R.id.ninePatch:
                startActivity(new Intent(DrawablesActivity.this, NinePatchActivity.class));
                break;
            case R.id.insertDrawable:
                startActivity(new Intent(DrawablesActivity.this, InsertActivity.class));
                break;
            case R.id.clipDrawable:
                startActivity(new Intent(DrawablesActivity.this, ClipActivity.class));
                break;
            case R.id.scaleDrawable:
                startActivity(new Intent(DrawablesActivity.this, ScaleActivity.class));
                break;
            case R.id.rotateDrawable:
                startActivity(new Intent(DrawablesActivity.this, RotateActivity.class));
                break;
            case R.id.animationListDrawable:
                startActivity(new Intent(DrawablesActivity.this, AnimationListActivity.class));
                break;
            case R.id.layerListDrawable:
                startActivity(new Intent(DrawablesActivity.this, LayerListActivity.class));
                break;
            case R.id.levelListDrawable:
                startActivity(new Intent(DrawablesActivity.this, LevelListActivity.class));
                break;
            case R.id.animatedRotateDrawable:
                startActivity(new Intent(DrawablesActivity.this, AnimatedRoteteActivity.class));
                break;
            case R.id.animatedSelectorDrawable:
                startActivity(new Intent(DrawablesActivity.this, AnimatedSelectorActivity.class));
                break;
            case R.id.vectorDrawable:
                startActivity(new Intent(DrawablesActivity.this, VectorDrawableActivity.class));
                break;
            case R.id.starVectorDrawable:
                startActivity(new Intent(DrawablesActivity.this, StarVectorDrawableActivity.class));
                break;
        }
    }
}
