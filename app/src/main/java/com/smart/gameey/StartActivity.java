package com.smart.gameey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.smart.gameey.sankeGame.SnakeActivity;
import com.smart.gameey.spaceShooter.Start;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        AdView adView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void spaceShooter(View view) {
        Intent intent = new Intent(StartActivity.this, Start.class);
        startActivity(intent);
//        finish();
    }

    public void snake(View view) {
        Intent intent = new Intent(StartActivity.this, SnakeActivity.class);
        startActivity(intent);
//        finish();
    }

    public void tictacPlay(View view) {
        Intent intent = new Intent(StartActivity.this, TictactoeActivity.class);
        startActivity(intent);
//        finish();
    }

    public void brainQuizplay(View view) {
        Intent intent = new Intent(StartActivity.this, BrainQuizActivity.class);
        startActivity(intent);
//        finish();
    }

    public void roulette(View view) {
        Intent intent = new Intent(StartActivity.this, RouletteActivity.class);
        startActivity(intent);
//        finish();
    }
}