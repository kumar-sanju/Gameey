package com.sanju.gameey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class BrainQuizActivity extends AppCompatActivity {

    Button startBtn,button0,button1,button2,button3;
    TextView sumTextView,resultTextView;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int localCorrectAnswer;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_quiz);

        startBtn = findViewById(R.id.startBtn);
        sumTextView = findViewById(R.id.sumTextView);
        resultTextView = findViewById(R.id.resultTextView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        Random random = new Random();

        int a = random.nextInt(21);
        int b = random.nextInt(21);

        sumTextView.setText(Integer.toString(a) + "+" +Integer.toString(b));

        localCorrectAnswer = random.nextInt(4);

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
//        Log.i("Tag", (String) view.getTag());
    }
}