package com.example.kevin.aslflashcards.manager;

import android.content.Context;

import com.example.kevin.aslflashcards.R;
import com.example.kevin.aslflashcards.configuration.UnitConfiguration;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

/**
 * Created by kevin on 3/1/18.
 */

public class FlashCardDataManager {
    private UnitConfiguration configuration;
    private Context context;
    private List<String> currentWordList;

    public FlashCardDataManager(Context context) { this.context = context; }

    public void setConfiguration(UnitConfiguration configuration) { this.configuration = configuration; }

    public String fetchWordList() {
        String json = null;
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.word_list);

            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        JsonArray unitOneWords = jsonObject.getAsJsonArray("unit_3");
        currentWordList = Lists.newArrayList();

        for (int i = 0; i < unitOneWords.size(); ++i) {
            currentWordList.add(unitOneWords.get(i).getAsString());
        }

        return json;
    }

    public String getRandomWordFromListAndRemoveFromList() {
        if (currentWordList.isEmpty()) {
            return "No Words Left in The List.";
        }
        Random numberGenerated = new Random();
        int randomNumber = numberGenerated.nextInt(currentWordList.size());

        String selectedWord = currentWordList.get(randomNumber);
        currentWordList.remove(randomNumber);
        return selectedWord;
    }
}
