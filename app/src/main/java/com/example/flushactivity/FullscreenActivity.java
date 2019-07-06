package com.example.flushactivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */



public class FullscreenActivity extends AppCompatActivity {
    Handler handler=new Handler();
    private boolean isFirstuse;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        final SharedPreferences preferences=getSharedPreferences("loginStatus1",MODE_PRIVATE);
        isFirstuse=preferences.getBoolean("isFirstUse",true);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences loginStatus=getSharedPreferences("loginStatus1",MODE_PRIVATE);
                SharedPreferences.Editor editor=loginStatus.edit();
                Intent intent=new Intent();
                if(isFirstuse){
                    intent.setClass(FullscreenActivity.this,GuideActivity.class);
                    editor.putBoolean("isFirstUse",false);
                }else{
                    intent.setClass(FullscreenActivity.this,LoginActivity.class);
                }
                //intent.setClass(FullscreenActivity.this,GuideActivity.class);
                startActivity(intent);
                finish();
                editor.commit();
            }
        }, 3000);
    }
}