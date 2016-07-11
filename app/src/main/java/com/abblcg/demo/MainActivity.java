package com.abblcg.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

import com.abblcg.common.ui.ShadeTextView;

public class MainActivity extends AppCompatActivity {
    private ShadeTextView shadeTextView;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shadeTextView = (ShadeTextView) findViewById(R.id.shadeTextView);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setMax(200);
        seekBar.setProgress(100);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                shadeTextView.setShadePosition((progress - 100) / 100f);
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
