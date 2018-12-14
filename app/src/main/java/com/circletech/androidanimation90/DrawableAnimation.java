package com.circletech.androidanimation90;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DrawableAnimation extends AppCompatActivity {
    AnimationDrawable rocketAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_animation);
        AnimatedVectorDrawable v=null;
        ImageView vImageView=findViewById(R.id.image);
        vImageView.setBackgroundResource(R.drawable.animated_vector_drawable);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            v=(AnimatedVectorDrawable) vImageView.getBackground();
        }
        final AnimatedVectorDrawable finalV = v;
        vImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if(finalV instanceof  AnimatedVectorDrawable)
                        finalV.start();
                }
            }
        });
        ImageView rocketImage = (ImageView) findViewById(R.id.rocket_image);
        rocketImage.setBackgroundResource(R.drawable.rocket_animation);
        rocketAnimation = (AnimationDrawable) rocketImage.getBackground();

        rocketImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rocketAnimation.start();
            }
        });

    }
    }
