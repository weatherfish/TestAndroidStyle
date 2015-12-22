package com.felix.testandroidstyle.drawables;

import android.graphics.drawable.RotateDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.felix.testandroidstyle.R;

public class RotateActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        imageView = (ImageView) findViewById(R.id.image_rotate);

        final RotateDrawable drawable = (RotateDrawable) imageView.getDrawable();
        drawable.setLevel(1000);
        seekBar.setProgress(1000);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                drawable.setLevel(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
