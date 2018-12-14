package com.circletech.androidanimation90;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView=findViewById(R.id.animation_listview);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pAdapterView, View pView, int pI, long pL) {
                //Toast.makeText(MainActivity.this, ""+pI, Toast.LENGTH_SHORT).show();
                switch (pI){
                    case 0:startActivity(new Intent(MainActivity.this,DrawableAnimation.class));
                    break;
                    case 1:startActivity(new Intent(MainActivity.this,CrossFadeActivity.class));
                    break;
                    default:
                        Toast.makeText(MainActivity.this, "Wrong key", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
