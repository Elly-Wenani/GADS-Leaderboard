package com.example.gads;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.os.Handler;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    //Variables
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_splash);

        //Animations
        Animation topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);

        //Hooks
        image = findViewById(R.id.img_load);

        image.setAnimation(topAnim);

        int SPLASH_SCREEN = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(SplashScreen.this, LeaderBoardActivity.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(image, "logo_image");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this);
                    startActivity(home, options.toBundle());
                    SplashScreen.this.finish();
                }
            }
        }, SPLASH_SCREEN);

    }

    @Override
    public void onBackPressed() {
        //Nothing happens when back button is pressed
    }
}