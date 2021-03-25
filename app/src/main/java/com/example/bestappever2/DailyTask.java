package com.example.bestappever2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class DailyTask extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_task);

        imageView = findViewById(R.id.pot2);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               imageView.setImageResource(R.drawable.base);
            }
        }, 1000 );

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(R.drawable.tree_2);
            }
        }, 2000 );

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(R.drawable.tree_3);
            }
        }, 3000 );

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(R.drawable.tree_4);
            }
        }, 4000 );

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(R.drawable.tree_4);
            }
        }, 4000 );

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(R.drawable.tree_5);
            }
        }, 5000 );

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(R.drawable.tree_6);
            }
        }, 6000 );
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(R.drawable.tree_7);
            }
        }, 7000 );
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(R.drawable.tree_8);
            }
        }, 8000 );
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(R.drawable.tree_9);
            }
        }, 9000 );

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setImageResource(R.drawable.tree_10);
            }
        }, 10000 );

        //}


        // int id = getResources().getIdentifier(R.drawable.tree_1, null, null);
    }

}