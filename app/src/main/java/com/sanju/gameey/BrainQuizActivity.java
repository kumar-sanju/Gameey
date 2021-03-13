package com.sanju.gameey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class BrainQuizActivity extends AppCompatActivity {

    Button startBtn,button0,button1,button2,button3,playAgainBtn;
    TextView sumTextView,resultTextView,pointTextView,timerTextView;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int localCorrectAnswer;
    int score = 0;
    int numberOfIncreament = 0;
    RelativeLayout relative1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_quiz);

        startBtn = findViewById(R.id.startBtn);
        sumTextView = findViewById(R.id.sumTextView);
        resultTextView = findViewById(R.id.resultTextView);
        pointTextView = findViewById(R.id.pointTextView);
        timerTextView = findViewById(R.id.timerTextView);
        playAgainBtn = findViewById(R.id.playAgainBtn);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        relative1 = findViewById(R.id.relative1);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBtn.setVisibility(View.INVISIBLE);
                relative1.setVisibility(View.VISIBLE);

                playAgain(findViewById(R.id.playAgainBtn));
            }
        });

    }

    private void generateAQuestion() {
        Random random = new Random();

        int a = random.nextInt(21);
        int b = random.nextInt(21);

        sumTextView.setText(Integer.toString(a) + "+" +Integer.toString(b));

        localCorrectAnswer = random.nextInt(4);
        answers.clear();

        int incorrectAnswer;

        for (int i = 0; i<4; i++){
            if (i == localCorrectAnswer){
                answers.add(a + b);
            } else {
                incorrectAnswer = random.nextInt(41);

                while (incorrectAnswer == a + b){
                    incorrectAnswer = random.nextInt(41);
                }
                answers.add(incorrectAnswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    public void start(View view) {
        startBtn.setVisibility(View.INVISIBLE);
    }

    public void chooseAnswer(View view) {
        if (view.getTag().toString().equals(Integer.toString(localCorrectAnswer))){
            score++;
            resultTextView.setText("Correct!");
//            Log.i("correct", "Correct");
        } else {
            resultTextView.setText("Wrong!");
        }

        numberOfIncreament++;
        pointTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfIncreament));
        generateAQuestion();
//        Log.i("Tag", (String) view.getTag());
    }

    public void playAgain(View view) {
        button0.setClickable(true);
        button1.setClickable(true);
        button2.setClickable(true);
        button3.setClickable(true);
        score = 0;
        numberOfIncreament = 0;

        timerTextView.setText("30s");
        pointTextView.setText("0/0");
        resultTextView.setText("");
        playAgainBtn.setVisibility(View.INVISIBLE);

        generateAQuestion();

        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                playAgainBtn.setVisibility(View.VISIBLE);
                timerTextView.setText("0s");
                resultTextView.setText("Your Score: " + Integer.toString(score) + "/" + Integer.toString(numberOfIncreament));
                button0.setClickable(false);
                button1.setClickable(false);
                button2.setClickable(false);
                button3.setClickable(false);
            }
        }.start();

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent(this,StartActivity.class);
        startActivity(intent);
        finish();
    }
}