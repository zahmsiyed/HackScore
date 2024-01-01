package com.example.hackscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionsScreen extends AppCompatActivity {
    public static TextView labelQuestions;
    public static TextView labelQuestionsTracker;
    public static Button buttonOption1;
    public static Button buttonOption2;
    public static Button buttonOption3;
    public static Button buttonOption4;
    public static Button buttonBack;
    public Button buttonRestart;
    static int index = 0;
    static double score = 0;
    public static final int limit = 25-1;
    public static ArrayList<Double> sumScoresList = new ArrayList<>();

    public static void refresh(){

        if (sumScoresList.isEmpty()) {
            buttonBack.setVisibility(View.GONE);
        } else{
            buttonBack.setVisibility(View.VISIBLE);
        }

        labelQuestionsTracker.setText("Question "+(index+1)+" of "+(limit+1));
        labelQuestions.setText(BackEnd.getQuestion(index));
        buttonOption1.setText(BackEnd.getOption1(index));
        buttonOption2.setText(BackEnd.getOption2(index));
        buttonOption3.setText(BackEnd.getOption3(index));
        buttonOption4.setText(BackEnd.getOption4(index));

        System.out.println(sumScoresList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_screen);

        labelQuestions = findViewById(R.id.label_questions);
        labelQuestionsTracker = findViewById(R.id.label_questions_tracker);
        buttonOption1 = findViewById(R.id.button_option1);
        buttonOption2 = findViewById(R.id.button_option2);
        buttonOption3 = findViewById(R.id.button_option3);
        buttonOption4 = findViewById(R.id.button_option4);
        buttonBack = findViewById(R.id.button_back_questions);
        buttonRestart = findViewById(R.id.button_restart);

        refresh();

        buttonOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumScoresList.add(8.5);
                index++;

                if(index>limit){
                    Intent intent = new Intent(QuestionsScreen.this, ScoreScreen.class);
                    startActivity(intent);
                }else {
                    refresh();
                }//end of else
            }
        });

        buttonOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumScoresList.add(17.0);
                index++;

                if(index>limit){
                    Intent intent = new Intent(QuestionsScreen.this, ScoreScreen.class);
                    startActivity(intent);
                }else {
                    refresh();
                }//end of else
            }
        });

        buttonOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumScoresList.add(25.5);
                index++;

                if(index>limit){
                    Intent intent = new Intent(QuestionsScreen.this, ScoreScreen.class);
                    startActivity(intent);
                }else {
                    refresh();
                }//end of else
            }
        });

        buttonOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumScoresList.add(34.0);
                index++;

                if(index>limit){
                    Intent intent = new Intent(QuestionsScreen.this, ScoreScreen.class);
                    startActivity(intent);
                }else {
                    refresh();
                }//end of else
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index>0){
                    sumScoresList.remove(sumScoresList.size()-1);
                    index--;
                    refresh();
                }
            }
        });

        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionsScreen.this, MainActivity.class);
                startActivity(intent);
                score = 0;
                index = 0;
                sumScoresList.clear();
            }
        });
    }//end of void
}//end of class