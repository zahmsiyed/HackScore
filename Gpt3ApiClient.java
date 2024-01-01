package com.example.hackscore;

import android.util.Log;
import okhttp3.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Gpt3ApiClient {

    private static final String GPT3_ENDPOINT = "https://api.openai.com/v1/completions";

    public static String getGpt3Response(String prompt) {
        OkHttpClient client = new OkHttpClient();

        JSONObject requestBodyJson = new JSONObject();
        try {
            requestBodyJson.put("model", "davinci");//Change GPT3 Model
            requestBodyJson.put("prompt", prompt);
            requestBodyJson.put("temperature", 0.5);//Change randomness 0.0-1.0
            requestBodyJson.put("max_tokens", 200);//Change length
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("GPT3 Error", "Failed to create request JSON");
            return null;
        }

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), requestBodyJson.toString());

        Request request = new Request.Builder()
                .url(GPT3_ENDPOINT)
                .post(requestBody)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + ApiKeyClass.apiKey)
                .build();

        Log.d("GPT3 Request URL", request.url().toString());

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                Log.d("GPT3 Response Body", responseBody);
                return responseBody;
            } else {
                Log.e("GPT3 Error", "Unsuccessful response. Code: " + response.code());
                Log.e("GPT3 Error Body", response.body().string());
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("GPT3 Error", "Exception: " + e.getMessage());
            return null;
        }
    }
}
