package com.sanju.gameey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 0 = black, 1 = red
    int activePlayer = 0;

    boolean gameIsActive = true;
    // 2 means unplayed
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPosition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropIn(View view){
        ImageView counter = (ImageView) view;
//        System.out.println(counter.getTag().toString());
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if(gameState[tappedCounter] == 2 && gameIsActive){
            gameState[tappedCounter] = activePlayer;
            counter.setTranslationY(-1000f);

            if(activePlayer == 0){
                counter.setImageResource(R.drawable.black);
                activePlayer = 1;
            } else{
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);
            for(int[] winningPosition : winningPosition){
                if(gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2){
//                    System.out.println(gameState[winningPosition[0]]);

                    gameIsActive = false;

                    String winner = "Red";
                    if(gameState[winningPosition[0]] ==0){
                        winner = "Black";
                    }

                    // if someone own
                    TextView winningText = (TextView)findViewById(R.id.winningText);
                    winningText.setText(winner + "has won!");
                    LinearLayout linear = (LinearLayout)findViewById(R.id.linear);
                    linear.setVisibility(View.VISIBLE);
                } else {
                    boolean gameIsOver = true;
                    for (int counterState : gameState){
                        if(counterState ==2) gameIsOver = false;
                    }
                    if(gameIsOver){
                        // if someone own
                        TextView winningText = (TextView)findViewById(R.id.winningText);
                        winningText.setText("It's a Draw");
                        LinearLayout linear = (LinearLayout)findViewById(R.id.linear);
                        linear.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }
    public void playAgain(View view){
        LinearLayout linear = (LinearLayout)findViewById(R.id.linear);
        linear.setVisibility(View.INVISIBLE);

        activePlayer = 0;

        for(int i=0; i<gameState.length; i++){
            gameState[i] = 2;
        }
        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);
        for(int i=0; i<gridLayout.getChildCount(); i++){
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}