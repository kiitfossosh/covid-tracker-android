package com.technocrators.covidtrackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.omega.animatedtext.AnimatedTextView;

public class MainActivity extends AppCompatActivity {

    private Handler handler;
    private AnimatedTextView reminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reminder = findViewById(R.id.reminderTextView);
        reminder.createStrokeAnimator(0.05f).start();
        reminder.createItalicAnimator(0.4f)
                .setDuration(1000)
                .start();
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, OverViewActivity.class));
                finish();
            }
        }, 5000);
    }
}