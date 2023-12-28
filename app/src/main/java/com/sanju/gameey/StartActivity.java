package com.sanju.gameey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sanju.gameey.sankeGame.SnakeActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void spaceShooter(View view) {
        Intent intent = new Intent(StartActivity.this, com.sanju.gameey.spaceShooter.Start.class);
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