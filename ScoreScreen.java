package com.example.hackscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreScreen extends AppCompatActivity {
    public TextView labelScore;
    public Button buttonBack;
    public Button buttonHome;
    public Button buttonChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);

        labelScore = findViewById(R.id.label_Score);
        buttonBack = findViewById(R.id.button_back_score);
        buttonHome = findViewById(R.id.button_home_score);
        buttonChat = findViewById(R.id.button_chat_score);

        double sum = 0;
        for(int i=0; i<QuestionsScreen.limit+1; i++){
            sum += QuestionsScreen.sumScoresList.get(i);
        }

        labelScore.setText("Your HackScore:"+"\n"+(int)sum+"/850");

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(QuestionsScreen.index>0){
                    QuestionsScreen.sumScoresList.remove(QuestionsScreen.sumScoresList.size()-1);
                    QuestionsScreen.index--;
                    QuestionsScreen.refresh();
                    Intent intent = new Intent(ScoreScreen.this, QuestionsScreen.class);
                    startActivity(intent);
                }
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreScreen.this, MainActivity.class);
                startActivity(intent);
                QuestionsScreen.score = 0;
                QuestionsScreen.index = 0;
                QuestionsScreen.sumScoresList.clear();
            }
        });
        buttonChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreScreen.this, ChatBotScreen.class);
                startActivity(intent);
            }
        });

    }
}