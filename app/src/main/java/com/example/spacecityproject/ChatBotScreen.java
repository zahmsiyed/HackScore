package com.example.spacecityproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ChatBotScreen extends AppCompatActivity {
    private Button buttonBack;
    private Button buttonHome;
    private EditText inputChat;
    private Button buttonAsk;
    private TextView labelResponse;
    private ChatGPTClient chatGPTClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot_screen);

        buttonBack = findViewById(R.id.button_back_chat);
        buttonHome = findViewById(R.id.button_home_chat);
        inputChat = findViewById(R.id.input_chat);
        buttonAsk = findViewById(R.id.button_ask);
        labelResponse = findViewById(R.id.label_response);

        if (QuestionsScreen.sumScoresList.size()<25) {
            buttonBack.setVisibility(View.GONE);
        } else {
            buttonBack.setVisibility(View.VISIBLE);
        }

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatBotScreen.this, ScoreScreen.class);
                startActivity(intent);
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatBotScreen.this, MainActivity.class);
                startActivity(intent);
                QuestionsScreen.score = 0;
                QuestionsScreen.index = 0;
                QuestionsScreen.sumScoresList.clear();
            }
        });

        chatGPTClient = new ChatGPTClient();

        buttonAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = inputChat.getText().toString();
                if (!userInput.isEmpty()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                final String response = chatGPTClient.sendMessage(userInput);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        labelResponse.setText(response);
                                    }
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            }
        });
    }
}