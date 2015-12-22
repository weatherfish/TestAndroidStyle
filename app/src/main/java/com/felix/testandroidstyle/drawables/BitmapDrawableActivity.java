package com.felix.testandroidstyle.drawables;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.felix.testandroidstyle.R;

public class BitmapDrawableActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_drawable);
        imageView = (ImageView) findViewById(R.id.bitmap);
        imageView.setOnClickListener(this);
        txt = (TextView) findViewById(R.id.txt);
        txt.setText("mirror");
    }

    private Drawable initBitmapDrawable() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.cat);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        bitmapDrawable.setAntiAlias(true);
        bitmapDrawable.setDither(true);
        return bitmapDrawable;
    }

    private Drawable initAlphaBitmapDrawable() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.cat);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        bitmapDrawable.setAntiAlias(true);
        bitmapDrawable.setDither(true);
        bitmapDrawable.setAlpha(100);
        return bitmapDrawable;
    }

    int i = 0;
    int MOD = 5;

    @Override
    public void onClick(View v) {
        if (i % MOD == 0) {
            imageView.setBackground(initBitmapDrawable());
            txt.setText("Repeat");
        } else if (i % MOD == 1) {
            imageView.setBackground(getDrawable(R.drawable.drawable_bitmap_tint));
            txt.setText("TINT ADD");
        } else if (i % MOD == 2) {
            imageView.setBackground(initAlphaBitmapDrawable());
            txt.setText("REPEAT ALPHA");
        }else if (i % MOD == 3) {
            imageView.setBackground(getDrawable(R.drawable.drawable_bitmap_mirror));
            txt.setText("MIRROR");
        }else if (i % MOD == 4) {
            imageView.setBackground(getDrawable(R.drawable.drawable_bitmap_clamp));
            txt.setText("CLAMP");
        }
        i++;
    }
}
