package com.example.android.animasippab;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ObjectAnimator birdAnimator;
    ImageView bird;
    Button btnJump;
    Float birdY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bird = findViewById(R.id.img_bird);
        btnJump = findViewById(R.id.btn_jump);
        birdY = bird.getY();

        birdAnimator = ObjectAnimator.ofFloat(bird, "translationX", 0f, 1500f);
        birdAnimator.setDuration(3000);
        birdAnimator.setRepeatCount(ValueAnimator.INFINITE);
        birdAnimator.start();

        btnJump.setOnClickListener(view -> {
            ObjectAnimator jumpAnimator = ObjectAnimator.ofFloat(bird, "translationY", birdY, birdY - 500f);
            jumpAnimator.setDuration(100);
            jumpAnimator.setRepeatCount(1);
            jumpAnimator.setRepeatMode(ValueAnimator.REVERSE);
            jumpAnimator.start();
        });
    }
}