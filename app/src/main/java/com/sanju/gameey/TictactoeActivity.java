package com.sanju.gameey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TictactoeActivity extends AppCompatActivity {

    //    variables for image view
    ImageView button1,button2,button3,button4,button5,button6,button7,button8,button9;

    private String startGame = "X";

    int b1 = 5,b2 = 5,b3 = 5,b4 = 5,b5 = 5,b6 = 5,b7 = 5,b8 = 5,b9 = 5;

    //    variable to score current score
    int xCount = 0, oCount = 0;

    int i = 0;
    //    variable to assigning xml id to java id
    private TextView scorex,scoreo;

    //    variable to reset button
    private Button Reset;
    RelativeLayout mainLayout;
    LinearLayout templateLayout;
    CardView template1, template2, template3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        button1 = findViewById(R.id.imageView);
        button2 = findViewById(R.id.imageView1);
        button3 = findViewById(R.id.imageView2);
        button4 = findViewById(R.id.imageView3);
        button5 = findViewById(R.id.imageView4);
        button6 = findViewById(R.id.imageView5);
        button7 = findViewById(R.id.imageView6);
        button8 = findViewById(R.id.imageView7);
        button9 = findViewById(R.id.imageView8);

        scorex = findViewById(R.id.ScoreX);
        scoreo = findViewById(R.id.ScoreY);

        Reset = findViewById(R.id.Reset);

        mainLayout = findViewById(R.id.mainLayout);
        templateLayout = findViewById(R.id.templateLayout);
        mainLayout.setVisibility(View.GONE);

        template1 = findViewById(R.id.template1);
        template2 = findViewById(R.id.template2);
        template3 = findViewById(R.id.template3);

        template1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utlis.TEMPLATE = 1;
                templateLayout.setVisibility(View.GONE);
                mainLayout.setVisibility(View.VISIBLE);
            }
        });

        template2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utlis.TEMPLATE = 2;
                templateLayout.setVisibility(View.GONE);
                mainLayout.setVisibility(View.VISIBLE);
            }
        });

        template3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utlis.TEMPLATE = 3;
                templateLayout.setVisibility(View.GONE);
                mainLayout.setVisibility(View.VISIBLE);
            }
        });

        //reset button
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setImageDrawable(null);
                button2.setImageDrawable(null);
                button3.setImageDrawable(null);
                button4.setImageDrawable(null);
                button5.setImageDrawable(null);
                button6.setImageDrawable(null);
                button7.setImageDrawable(null);
                button8.setImageDrawable(null);
                button9.setImageDrawable(null);

                //resetValue function
                resetValues();

                xCount = 0;
                oCount = 0;
                scorex.setText("Score X :- " + String.valueOf(xCount));
                scoreo.setText("Score Y :- " + String.valueOf(oCount));
            }
        });

        //button 1 first row first button
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(startGame.equals("X")){
                    if (Utlis.TEMPLATE == 1){
                        button1.setImageResource(R.drawable.green_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button1.setImageResource(R.drawable.ic_yollow_pikachu);
                    }
                    else {
                        button1.setImageResource(R.drawable.ic_cross);
                    }

                    b1 = 1;
                    i++;
                }else{
                    if (Utlis.TEMPLATE == 1){
                        button1.setImageResource(R.drawable.black_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button1.setImageResource(R.drawable.ic_black_pikachu);
                    }
                    else {
                        button1.setImageResource(R.drawable.ic_circle);
                    }

                    b1 = 0;
                    i++;
                }

                choosePlayer();

                winningGame();
                button1.setClickable(false);
            }
        });


        //button 2 first row middle button
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(startGame.equals("X")){
                    if (Utlis.TEMPLATE == 1){
                        button2.setImageResource(R.drawable.green_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button2.setImageResource(R.drawable.ic_yollow_pikachu);
                    }
                    else {
                        button2.setImageResource(R.drawable.ic_cross);
                    }
                    b2 = 1;
                    i++;
                }else{
                    if (Utlis.TEMPLATE == 1){
                        button2.setImageResource(R.drawable.black_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button2.setImageResource(R.drawable.ic_black_pikachu);
                    }
                    else {
                        button2.setImageResource(R.drawable.ic_circle);
                    }
                    b2 = 0;
                    i++;
                }

                choosePlayer();

                winningGame();
                button2.setClickable(false);
            }
        });

        //button 3 first row last button
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(startGame.equals("X")){
                    if (Utlis.TEMPLATE == 1){
                        button3.setImageResource(R.drawable.green_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button3.setImageResource(R.drawable.ic_yollow_pikachu);
                    }
                    else {
                        button3.setImageResource(R.drawable.ic_cross);
                    }
                    b3 = 1;
                    i++;
                }else{
                    if (Utlis.TEMPLATE == 1){
                        button3.setImageResource(R.drawable.black_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button3.setImageResource(R.drawable.ic_black_pikachu);
                    }
                    else {
                        button3.setImageResource(R.drawable.ic_circle);
                    }
                    b3 = 0;
                    i++;
                }

                choosePlayer();

                winningGame();
                button3.setClickable(false);
            }
        });

        //button 4 second row first button
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(startGame.equals("X")){
                    if (Utlis.TEMPLATE == 1){
                        button4.setImageResource(R.drawable.green_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button4.setImageResource(R.drawable.ic_yollow_pikachu);
                    }
                    else {
                        button4.setImageResource(R.drawable.ic_cross);
                    }
                    b4 = 1;
                    i++;
                }else{
                    if (Utlis.TEMPLATE == 1){
                        button4.setImageResource(R.drawable.black_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button4.setImageResource(R.drawable.ic_black_pikachu);
                    }
                    else {
                        button4.setImageResource(R.drawable.ic_circle);
                    }
                    b4 = 0;
                    i++;
                }

                choosePlayer();

                winningGame();
                button4.setClickable(false);
            }
        });

        //button 5 second row middle button
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(startGame.equals("X")){
                    if (Utlis.TEMPLATE == 1){
                        button5.setImageResource(R.drawable.green_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button5.setImageResource(R.drawable.ic_yollow_pikachu);
                    }
                    else {
                        button5.setImageResource(R.drawable.ic_cross);
                    }
                    b5 = 1;
                    i++;
                }else{
                    if (Utlis.TEMPLATE == 1){
                        button5.setImageResource(R.drawable.black_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button5.setImageResource(R.drawable.ic_black_pikachu);
                    }
                    else {
                        button5.setImageResource(R.drawable.ic_circle);
                    }
                    b5 = 0;
                    i++;
                }

                choosePlayer();

                winningGame();
                button5.setClickable(false);
            }
        });

        //button 6 second row last button
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(startGame.equals("X")){
                    if (Utlis.TEMPLATE == 1){
                        button6.setImageResource(R.drawable.green_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button6.setImageResource(R.drawable.ic_yollow_pikachu);
                    }
                    else {
                        button6.setImageResource(R.drawable.ic_cross);
                    }
                    b6 = 1;
                    i++;
                }else{
                    if (Utlis.TEMPLATE == 1){
                        button6.setImageResource(R.drawable.black_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button6.setImageResource(R.drawable.ic_black_pikachu);
                    }
                    else {
                        button6.setImageResource(R.drawable.ic_circle);
                    }
                    b6 = 0;
                    i++;
                }

                choosePlayer();

                winningGame();
                button6.setClickable(false);
            }
        });

        //button 7 third row first button
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(startGame.equals("X")){
                    if (Utlis.TEMPLATE == 1){
                        button7.setImageResource(R.drawable.green_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button7.setImageResource(R.drawable.ic_yollow_pikachu);
                    }
                    else {
                        button7.setImageResource(R.drawable.ic_cross);
                    }
                    b7 = 1;
                    i++;
                }else{
                    if (Utlis.TEMPLATE == 1){
                        button7.setImageResource(R.drawable.black_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button7.setImageResource(R.drawable.ic_black_pikachu);
                    }
                    else {
                        button7.setImageResource(R.drawable.ic_circle);
                    }
                    b7 = 0;
                    i++;
                }

                choosePlayer();

                winningGame();
                button7.setClickable(false);
            }
        });

        //button 8 third row middle button
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(startGame.equals("X")){
                    if (Utlis.TEMPLATE == 1){
                        button8.setImageResource(R.drawable.green_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button8.setImageResource(R.drawable.ic_yollow_pikachu);
                    }
                    else {
                        button8.setImageResource(R.drawable.ic_cross);
                    }
                    b8 = 1;
                    i++;
                }else{
                    if (Utlis.TEMPLATE == 1){
                        button8.setImageResource(R.drawable.black_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button8.setImageResource(R.drawable.ic_black_pikachu);
                    }
                    else {
                        button8.setImageResource(R.drawable.ic_circle);
                    }
                    b8 = 0;
                    i++;
                }

                choosePlayer();

                winningGame();
                button8.setClickable(false);
            }
        });


        //button 9 third row last button
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(startGame.equals("X")){
                    if (Utlis.TEMPLATE == 1){
                        button9.setImageResource(R.drawable.green_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button9.setImageResource(R.drawable.ic_yollow_pikachu);
                    }
                    else {
                        button9.setImageResource(R.drawable.ic_cross);
                    }
                    b9 = 1;
                    i++;
                }
                else{
                    if (Utlis.TEMPLATE == 1){
                        button9.setImageResource(R.drawable.black_casino);
                    }
                    else if (Utlis.TEMPLATE == 3){
                        button9.setImageResource(R.drawable.ic_black_pikachu);
                    }
                    else {
                        button9.setImageResource(R.drawable.ic_circle);
                    }
                    b9 = 0;
                    i++;
                }

                choosePlayer();

                winningGame();
                button9.setClickable(false);
            }
        });
    }

    //winningGame function
    private void winningGame()
    {

        //first way to win x player
        if((b1 == 1) && (b2 == 1) && (b3 == 1))
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player X Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);

                    //resetValue function
                    resetValues();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scorex.setText("Score X :- " + String.valueOf(xCount));
        }


        // Second way to win x player
        else if((b4 == 1) && (b5 == 1) && (b6 == 1))
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player X Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);

                    //resetValue function
                    resetValues();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scorex.setText("Score X :- " + String.valueOf(xCount));
        }

        // Third way to win x player
        else if((b7 == 1) && (b8 == 1) && (b9 == 1))
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player X Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);

                    //resetValue function
                    resetValues();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scorex.setText("Score X :- " + String.valueOf(xCount));
        }

        // Fourth way to win x player
        else if((b1 == 1) && (b4 == 1) && (b7 == 1))
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player X Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);

                    //resetValue function
                    resetValues();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scorex.setText("Score X :- " + String.valueOf(xCount));
        }

        // Fifth way to win x player
        else if((b2 == 1) && (b5 == 1) && (b8 == 1))
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player X Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);

                    //resetValue function
                    resetValues();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scorex.setText("Score X :- " + String.valueOf(xCount));
        }

        // Sixth way to win x player
        else if((b3 == 1) && (b6 == 1) && (b9 == 1))
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player X Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);

                    //resetValue function
                    resetValues();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scorex.setText("Score X :- " + String.valueOf(xCount));
        }

        // Seventh way to win x player
        else if((b1 == 1) && (b5 == 1) && (b9 == 1))
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player X Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);

                    //resetValue function
                    resetValues();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scorex.setText("Score X :- " + String.valueOf(xCount));
        }

        // Eighth way to win x player
        else if((b3 == 1) && (b5 == 1) && (b7 == 1))
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player X Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);

                    //resetValue function
                    resetValues();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            scorex.setText("Score X :- " + String.valueOf(xCount));
        }



        // First way to win o player
        else if((b1 == 0) && (b2 == 0) && (b3 == 0))
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Y Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);

                    //resetValue function
                    resetValues();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreo.setText("Score Y :- " + String.valueOf(oCount));
        }

        // Second way to win o player
        else if((b4 == 0) && (b5 == 0) && (b6 == 0))
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Y Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);

                    //resetValue function
                    resetValues();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreo.setText("Score Y :- " + String.valueOf(oCount));
        }

        // Third way to win o player
        else if((b7 == 0) && (b8 == 0) && (b9 == 0))
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Y Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);

                    //resetValue function
                    resetValues();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreo.setText("Score Y :- " + String.valueOf(oCount));
        }

        // Fourth way to win o player
        else if((b1 == 0) && (b4 == 0) && (b7 == 0))
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Y Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);

                    //resetValue function
                    resetValues();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreo.setText("Score Y :- " + String.valueOf(oCount));
        }

        // Fifth way to win o player
        else if((b2 == 0) && (b5 == 0) && (b8 == 0))
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Y Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);

                    //resetValue function
                    resetValues();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreo.setText("Score Y :- " + String.valueOf(oCount));
        }

        // Sixth way to win o player
        else if((b3 == 0) && (b6 == 0) && (b9 == 0))
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Y Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);

                    //resetValue function
                    resetValues();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreo.setText("Score Y :- " + String.valueOf(oCount));
        }

        // Seventh way to win o player
        else if((b1 == 0) && (b5 == 0) && (b9 == 0))
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Y Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);

                    //resetValue function
                    resetValues();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreo.setText("Score Y :- " + String.valueOf(oCount));
        }

        // Eighth way to win o player
        else if((b3 == 0) && (b5 == 0) && (b7 == 0))
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Y Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    button1.setImageDrawable(null);
                    button2.setImageDrawable(null);
                    button3.setImageDrawable(null);
                    button4.setImageDrawable(null);
                    button5.setImageDrawable(null);
                    button6.setImageDrawable(null);
                    button7.setImageDrawable(null);
                    button8.setImageDrawable(null);
                    button9.setImageDrawable(null);

                    //resetValue function
                    resetValues();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            scoreo.setText("Score Y :- " + String.valueOf(oCount));
        }

        //when no one win
        else
        {
            if(i == 9){

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("No One Wins").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        button1.setImageDrawable(null);
                        button2.setImageDrawable(null);
                        button3.setImageDrawable(null);
                        button4.setImageDrawable(null);
                        button5.setImageDrawable(null);
                        button6.setImageDrawable(null);
                        button7.setImageDrawable(null);
                        button8.setImageDrawable(null);
                        button9.setImageDrawable(null);

                        //resetValue function
                        resetValues();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        }

    }

    //choosePlayer function
    private void choosePlayer(){
        if(startGame.equals("X")){
            startGame = "0";
        }
        else
        {
            startGame = "X";
        }
    }

    //resetValue function
    private void resetValues() {
        b1 = 5;
        b2 = 5;
        b3 = 5;
        b4 = 5;
        b5 = 5;
        b6 = 5;
        b7 = 5;
        b8 = 5;
        b9 = 5;
        i = 0;

        button1.setClickable(true);
        button2.setClickable(true);
        button3.setClickable(true);
        button4.setClickable(true);
        button5.setClickable(true);
        button6.setClickable(true);
        button7.setClickable(true);
        button8.setClickable(true);
        button9.setClickable(true);

    }

}