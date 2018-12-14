package com.circletech.androidanimation90;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;

public class CircleRevealAnimationActivity extends AppCompatActivity {

    View myView;
    boolean mVisibleView=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_reveal_animation);
        myView = findViewById(R.id.image_circle);
        mVisibleView=true;
        myView.setVisibility(View.VISIBLE);
        findViewById(R.id.hidebtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                showMyView();
            }
        });

    }

    private void showMyView() {
        // Check if the runtime version is at least Lollipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // get the center for the clipping circle
            int cx = myView.getWidth() / 2;
            int cy = myView.getHeight() / 2;

            // get the final radius for the clipping circle
            float Radius = (float) Math.hypot(cx, cy);
            Animator anim=null;
            // create the animator for this view (the start radius is zero)
            if(mVisibleView){
                anim=ViewAnimationUtils.createCircularReveal(myView,cx,cy,Radius,0f);
                myView.setVisibility(View.INVISIBLE);
                mVisibleView=false;
            }
            else {
                anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0f, Radius);
                myView.setVisibility(View.VISIBLE);
                mVisibleView = true;

            }
            anim.start();
        } else {
            // set the view to visible without a circular reveal animation below Lollipop
            if(mVisibleView){
                mVisibleView=false;
                myView.setVisibility(View.INVISIBLE);
            }
            else{
                mVisibleView=true;
            myView.setVisibility(View.VISIBLE);
            }
        }
    }
}
