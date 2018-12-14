package com.circletech.androidanimation90;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.Toast;

public class MoveCurvedActivity extends AppCompatActivity {

    boolean mRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_curved);
        final View vView = findViewById(R.id.ball);

        mRunning = false;
        findViewById(R.id.m1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                MoveX(vView);
            }
        });
        findViewById(R.id.m2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                MoveY(vView);
            }
        });
        findViewById(R.id.diagonal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                Diagonal(vView);
            }
        });

        findViewById(R.id.curve).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                curveMove(vView);
            }
        });
    }

    public void MoveX(final View vView) {
        if(!mRunning) {
            Toast.makeText(this, "XXX", Toast.LENGTH_SHORT).show();
            ObjectAnimator vObjectAnimator = null;
            vObjectAnimator = ObjectAnimator.ofFloat(vView, "translationX",0f, 500f);
            vObjectAnimator.setDuration(500);
            vObjectAnimator.start();
            mRunning=true;
            vObjectAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mRunning = false;
                    vView.setPivotX(0f);
                    vView.setPivotY(0f);
                }
            });
        }
    }

    public void MoveY(View vView) {

        if (!mRunning) {
            Toast.makeText(this, "YYy", Toast.LENGTH_SHORT).show();
            ObjectAnimator vObjectAnimator = null;
            vObjectAnimator = ObjectAnimator.ofFloat(vView, "translationY",0f, 600f);
            vObjectAnimator.setDuration(500);
            vObjectAnimator.start();
            mRunning=true;
            vObjectAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mRunning = false;
                }
            });


        }
    }

    public void Diagonal(View v) {
        if (!mRunning) {
            Toast.makeText(this, "DDDD", Toast.LENGTH_SHORT).show();
            ObjectAnimator mX = ObjectAnimator.ofFloat(v, "translationX", 0f,600f);
            mX.setDuration(500);
            ObjectAnimator mY = ObjectAnimator.ofFloat(v, "translationY", 0f,600f);
            mY.setDuration(500);
            AnimatorSet vSet = new AnimatorSet();
            vSet.playTogether(mX, mY);
            vSet.setInterpolator(new AccelerateDecelerateInterpolator());
            vSet.start();
            mRunning=true;
            vSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mRunning = false;
                }
            });

        }
    }
    public  void curveMove(View v){
        if(!mRunning){
            // arcTo() and PathInterpolator only available on API 21+
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Path path = new Path();
                path.arcTo(100f, 100f, 500f, 500f, 270f, 180f, true);
                PathInterpolator pathInterpolator = new PathInterpolator(path);
                ObjectAnimator animation = ObjectAnimator.ofFloat(v, "translationX", 0f,100f);
                animation.setInterpolator(pathInterpolator);
                animation.start();
                mRunning=true;
                animation.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        mRunning=false;
                    }
                });
            }

        }
    }
}
