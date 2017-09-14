package com.example.android0128.animationsample;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView image_button,button_go,main_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifeCycle","onCreate");

        image_button = (ImageView) findViewById(R.id.image_button);
        button_go = (ImageView) findViewById(R.id.button_go);
        main_image = (ImageView) findViewById(R.id.main_image);

        final Animation anim = AnimationUtils.loadAnimation(getApplication(), R.anim.animation_button);

        image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image_button.setEnabled(false);
                image_button.startAnimation(anim);

                anim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        image_button.setEnabled(true);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        button_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_go.setEnabled(false);

                Intent intent = new Intent(MainActivity.this,DialogActivity.class);

                ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(
                                MainActivity.this
                                ,main_image
                                , ViewCompat.getTransitionName(main_image));

                startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    protected void onStart() {
        Log.d("lifeCycle","onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifeCycle","onResume");
        button_go.setEnabled(true);
    }

    @Override
    protected void onPause() {
        Log.d("lifeCycle","onPause");
        super.onPause();
    }



    @Override
    protected void onDestroy() {
        Log.d("lifeCycle","onDestroy");
        super.onDestroy();
    }
}
