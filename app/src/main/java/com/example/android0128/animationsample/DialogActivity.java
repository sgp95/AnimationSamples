package com.example.android0128.animationsample;


import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.RelativeLayout;

public class DialogActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        RelativeLayout relative_layout = (RelativeLayout) findViewById(R.id.relative_layout);
        CardView card_view = (CardView) findViewById(R.id.card_view);

        int screenWidth = getResources().getDisplayMetrics().widthPixels;

        relative_layout.getLayoutParams().width = screenWidth/3;
        relative_layout.getLayoutParams().height = screenWidth/3;
        relative_layout.requestLayout();

        ((View)findViewById(R.id.card_view).getParent()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                }
            }
        });

        findViewById(R.id.card_view).setOnClickListener(null);


    }
}
