package com.sanju.gameey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
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