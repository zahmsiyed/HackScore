package com.example.hackscore;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatBotScreen extends AppCompatActivity {
    public static Button buttonBack;
    public Button buttonHome;
    public EditText inputChat;
    public Button buttonAsk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot_screen);

        buttonBack = findViewById(R.id.button_back_chat);
        buttonHome = findViewById(R.id.button_home_chat);
        inputChat = findViewById(R.id.input_chat);
        buttonAsk = findViewById(R.id.button_ask);

        if (QuestionsScreen.sumScoresList.size()<25) {
            buttonBack.setVisibility(View.GONE);
        } else {
            buttonBack.setVisibility(View.VISIBLE);
        }

        buttonAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prompt = String.valueOf(inputChat.getText());
                new Gpt3Task().execute("Answer with 5 sentences: "+prompt);
            }
        });

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

    }

    private class Gpt3Task extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String prompt = params[0];
            return Gpt3ApiClient.getGpt3Response(prompt);
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            if (response != null) {
                Log.d("GPT3 Response", response);

                // Extract GPT response text
                String gptResponse = extractGptResponse(response);

                // Set the extracted response in the TextView
                TextView textViewResponse = findViewById(R.id.label_response);
                textViewResponse.setText(gptResponse);
            } else {
                Log.e("GPT3 Error", "Response is null or empty");
            }
        }
    }

    // Method to extract GPT response from API response JSON
    private String extractGptResponse(String apiResponse) {
        try {
            JSONObject jsonResponse = new JSONObject(apiResponse);
            JSONArray choicesArray = jsonResponse.getJSONArray("choices");

            if (choicesArray.length() > 0) {
                JSONObject firstChoice = choicesArray.getJSONObject(0);
                return firstChoice.getString("text");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ""; // Return empty string if extraction fails
    }
}
