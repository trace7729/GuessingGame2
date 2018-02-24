package com.example.hole1.guessinggame2;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import android.content.Intent;

public class GameActivity extends AppCompatActivity {
    Button b_answer1, b_answer2,b_answer3,b_answer4;
    ImageView birdImageView;
    List<BirdItem> list;
    int turn=1;
    int totalQuestions=10;
    int correctAnswers;
    double score=0.00;
    Random r;
    //private int gamesoundchecked=SettingsActivity.soundchecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        r=new Random();
        birdImageView=(ImageView) findViewById(R.id.birdImageView);
        b_answer1=(Button) findViewById(R.id.b_answer1);
        b_answer2=(Button) findViewById(R.id.b_answer2);
        b_answer3=(Button) findViewById(R.id.b_answer3);
        b_answer4=(Button) findViewById(R.id.b_answer4);
        final MediaPlayer mp=MediaPlayer.create(this,R.raw.willow);
        final Animation bounce= AnimationUtils.loadAnimation(this,R.anim.correct_bounce);
        final Intent u=new Intent(GameActivity.this,MainActivity.class);

        final SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(this);
        final Boolean switchPref = sharedPref.getBoolean
                (SettingsActivity.KEY_SOUND_SWITCH, false);


        list=new ArrayList<>();
        //add all flags and names to the list
        for(int i=0; i<new Database().answers.length;i++){
            list.add(new BirdItem(new Database().answers[i], new Database().birds[i]));
        }

        //shuffle the list
        Collections.shuffle(list);
        newQuestion(turn);


        b_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            //check if this answer is correct
            public void onClick(View v) {
                if(b_answer1.getText().toString().equals(list.get(turn-1).getName())){
                    b_answer1.startAnimation(bounce);
                    b_answer1.postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            ++correctAnswers;
                            if(turn<totalQuestions){
                                turn++;
                                newQuestion(turn);
                            }else{
                                score=((double)correctAnswers/(double)totalQuestions)*100;

                                AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
                                alertDialog.setTitle("Your score");
                                alertDialog.setMessage("Your score is "+String.valueOf(score)+"%");
                                alertDialog.setButton("OK",new DialogInterface.OnClickListener(){
                                    @Override
                                    public void onClick(DialogInterface dialog, int i) {
                                        dialog.cancel();
                                        GameActivity.this.startActivity(u);
                                    }
                                });
                                alertDialog.show();

                            }

                        }
                    },2000);

                }else{
                    Toast.makeText(GameActivity.this,"Wrong",Toast.LENGTH_SHORT).show();
                    if(switchPref==true)
                        mp.start();

                    b_answer1.setVisibility(View.INVISIBLE);
                    b_answer1.postDelayed(new Runnable(){
                        @Override
                        public void run() {

                            if(turn<totalQuestions){
                                //b_answer1.setVisibility(View.VISIBLE);
                                b_answer1.setVisibility(View.VISIBLE);
                                turn++;
                                newQuestion(turn);

                            }else{
                                score=((double)correctAnswers/(double)totalQuestions)*100;

                                AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
                                alertDialog.setTitle("Your score");
                                alertDialog.setMessage("Your score is "+String.valueOf(score)+"%");
                                alertDialog.setButton("OK",new DialogInterface.OnClickListener(){
                                    @Override
                                    public void onClick(DialogInterface dialog, int i) {
                                        dialog.cancel();
                                        GameActivity.this.startActivity(u);
                                    }
                                });
                                alertDialog.show();

                            }
                        }
                    },2000);


                }
            }
        });
        b_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b_answer2.getText().toString().equals(list.get(turn-1).getName())){
                    b_answer2.startAnimation(bounce);
                    b_answer2.postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            ++correctAnswers;
                            if(turn<totalQuestions){
                                turn++;
                                newQuestion(turn);
                            }else{
                                score=((double)correctAnswers/(double)totalQuestions)*100;

                                AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
                                alertDialog.setTitle("Your score");
                                alertDialog.setMessage("Your score is "+String.valueOf(score)+"%");
                                alertDialog.setButton("OK",new DialogInterface.OnClickListener(){
                                    @Override
                                    public void onClick(DialogInterface dialog, int i) {
                                        dialog.cancel();
                                        GameActivity.this.startActivity(u);
                                    }
                                });
                                alertDialog.show();

                            }

                        }
                    },2000);
                }else{
                    Toast.makeText(GameActivity.this,"Wrong",Toast.LENGTH_SHORT).show();
                    if(switchPref==true)
                        mp.start();

                    b_answer2.setVisibility(View.INVISIBLE);
                    b_answer2.postDelayed(new Runnable(){
                        @Override
                        public void run() { if(turn<totalQuestions){
                            //b_answer1.setVisibility(View.VISIBLE);
                            b_answer2.setVisibility(View.VISIBLE);
                            turn++;
                            newQuestion(turn);

                        }else{
                            score=((double)correctAnswers/(double)totalQuestions)*100;

                            AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
                            alertDialog.setTitle("Your score");
                            alertDialog.setMessage("Your score is "+String.valueOf(score)+"%");
                            alertDialog.setButton("OK",new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                    dialog.cancel();
                                    GameActivity.this.startActivity(u);
                                }
                            });
                            alertDialog.show();

                        }
                        }
                    },2000);


                }
            }
        });
        b_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b_answer3.getText().toString().equals(list.get(turn-1).getName())){
                    b_answer3.startAnimation(bounce);
                    b_answer3.postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            ++correctAnswers;
                            if(turn<totalQuestions){
                                turn++;
                                newQuestion(turn);
                            }else{
                                score=((double)correctAnswers/(double)totalQuestions)*100;

                                AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
                                alertDialog.setTitle("Your score");
                                alertDialog.setMessage("Your score is "+String.valueOf(score)+"%");
                                alertDialog.setButton("OK",new DialogInterface.OnClickListener(){
                                    @Override
                                    public void onClick(DialogInterface dialog, int i) {
                                        dialog.cancel();
                                        GameActivity.this.startActivity(u);
                                    }
                                });
                                alertDialog.show();
                            }

                        }
                    },2000);
                }else{
                    Toast.makeText(GameActivity.this,"Wrong",Toast.LENGTH_SHORT).show();
                    if(switchPref==true)
                        mp.start();

                    b_answer3.setVisibility(View.INVISIBLE);
                    b_answer3.postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            if(turn<totalQuestions){
                                //b_answer1.setVisibility(View.VISIBLE);
                                b_answer3.setVisibility(View.VISIBLE);
                                turn++;
                                newQuestion(turn);

                            }else{
                                score=((double)correctAnswers/(double)totalQuestions)*100;

                                AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
                                alertDialog.setTitle("Your score");
                                alertDialog.setMessage("Your score is "+String.valueOf(score)+"%");
                                alertDialog.setButton("OK",new DialogInterface.OnClickListener(){
                                    @Override
                                    public void onClick(DialogInterface dialog, int i) {
                                        dialog.cancel();
                                        GameActivity.this.startActivity(u);
                                    }
                                });
                                alertDialog.show();
                            }
                        }
                    },2000);

                }
            }
        });
        b_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b_answer4.getText().toString().equals(list.get(turn-1).getName())){
                    b_answer4.startAnimation(bounce);
                    b_answer4.postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            ++correctAnswers;
                            if(turn<totalQuestions){
                                turn++;
                                newQuestion(turn);
                            }else{
                                score=((double)correctAnswers/(double)totalQuestions)*100;

                                AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
                                alertDialog.setTitle("Your score");
                                alertDialog.setMessage("Your score is "+String.valueOf(score)+"%");
                                alertDialog.setButton("OK",new DialogInterface.OnClickListener(){
                                    @Override
                                    public void onClick(DialogInterface dialog, int i) {
                                        dialog.cancel();
                                        GameActivity.this.startActivity(u);
                                    }
                                });
                                alertDialog.show();

                            }

                        }
                    },2000);
                }else{
                    Toast.makeText(GameActivity.this,"Wrong",Toast.LENGTH_SHORT).show();
                    if(switchPref==true)
                        mp.start();

                    b_answer4.setVisibility(View.INVISIBLE);
                    b_answer4.postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            if(turn<totalQuestions){
                                //b_answer1.setVisibility(View.VISIBLE);
                                b_answer4.setVisibility(View.VISIBLE);
                                turn++;
                                newQuestion(turn);

                            }else{
                                score=((double)correctAnswers/(double)totalQuestions)*100;

                                AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
                                alertDialog.setTitle("Your score");
                                alertDialog.setMessage("Your score is "+String.valueOf(score)+"%");
                                alertDialog.setButton("OK",new DialogInterface.OnClickListener(){
                                    @Override
                                    public void onClick(DialogInterface dialog, int i) {
                                        dialog.cancel();
                                        GameActivity.this.startActivity(u);
                                    }
                                });
                                alertDialog.show();
                            }
                        }
                    },2000);
                }
            }
        });
    }


    private void newQuestion(int number){
        //set bird image
        birdImageView.setImageResource(list.get(number-1).getImage());
        int correct_answer=r.nextInt(4)+1;
        int firstButton=number-1;
        int secondButton;
        int thirdButton;
        int forthButton;

        switch (correct_answer){
            case 1:
                b_answer1.setText(list.get(firstButton).getName());
                do{
                    secondButton=r.nextInt(list.size());
                }while (secondButton==firstButton);
                do{
                    thirdButton=r.nextInt(list.size());
                }while(secondButton==firstButton||thirdButton==secondButton);
                do{
                    forthButton=r.nextInt(list.size());
                }while(forthButton==firstButton||forthButton==secondButton||forthButton==thirdButton);
                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(forthButton).getName());
                break;
            case 2:
                b_answer2.setText(list.get(firstButton).getName());
                do{
                    secondButton=r.nextInt(list.size());
                }while (secondButton==firstButton);
                do{
                    thirdButton=r.nextInt(list.size());
                }while(secondButton==firstButton||thirdButton==secondButton);
                do{
                    forthButton=r.nextInt(list.size());
                }while(forthButton==firstButton||forthButton==secondButton||forthButton==thirdButton);
                b_answer1.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(forthButton).getName());
                break;
            case 3:
                b_answer3.setText(list.get(firstButton).getName());
                do{
                    secondButton=r.nextInt(list.size());
                }while (secondButton==firstButton);
                do{
                    thirdButton=r.nextInt(list.size());
                }while(secondButton==firstButton||thirdButton==secondButton);
                do{
                    forthButton=r.nextInt(list.size());
                }while(forthButton==firstButton||forthButton==secondButton||forthButton==thirdButton);
                b_answer2.setText(list.get(secondButton).getName());
                b_answer1.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(forthButton).getName());
                break;
            case 4:
                b_answer4.setText(list.get(firstButton).getName());
                do{
                    secondButton=r.nextInt(list.size());
                }while (secondButton==firstButton);
                do{
                    thirdButton=r.nextInt(list.size());
                }while(secondButton==firstButton||thirdButton==secondButton);
                do{
                    forthButton=r.nextInt(list.size());
                }while(forthButton==firstButton||forthButton==secondButton||forthButton==thirdButton);
                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer1.setText(list.get(forthButton).getName());
                break;
        }

    }
}
