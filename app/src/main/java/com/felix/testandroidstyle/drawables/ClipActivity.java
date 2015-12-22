package com.felix.testandroidstyle.drawables;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.felix.testandroidstyle.R;

public class ClipActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setProgress(8000);
        imageView = (ImageView) findViewById(R.id.clip_drawable);
        final ClipDrawable clipDrawable = (ClipDrawable) imageView.getDrawable();
        clipDrawable.setLevel(8000);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                clipDrawable.setLevel(progress);
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
