package com.example.kevin.aslflashcards.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.kevin.aslflashcards.R;
import com.example.kevin.aslflashcards.manager.DataManagerAccessor;
import com.example.kevin.aslflashcards.manager.FlashCardDataManager;

/**
 * Created by kevin on 2/8/18.
 */

public class CardFragment extends Fragment {

    private View view;
    private FlashCardDataManager dataManager;

    public static CardFragment newInstance() {
        return new CardFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.card_layout, container, false);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        try {
            this.dataManager = ((DataManagerAccessor) getContext()).getDataManager();
        } catch (ClassCastException e) {
            e.printStackTrace();
            throw new IllegalStateException("The Activity does not implement the correct accessor");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Button generateButton = view.findViewById(R.id.generate_button);
        generateButton.setOnClickListener((view) -> {
            String newWord = dataManager.getRandomWordFromListAndRemoveFromList();
            TextView wordDisplay = this.view.findViewById(R.id.display_word);
            wordDisplay.setText(newWord);
        });
    }
}
