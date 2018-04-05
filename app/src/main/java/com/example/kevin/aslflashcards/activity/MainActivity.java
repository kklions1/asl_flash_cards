package com.example.kevin.aslflashcards.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.kevin.aslflashcards.R;
import com.example.kevin.aslflashcards.fragment.CardFragment;
import com.example.kevin.aslflashcards.fragment.OptionsFragment;
import com.example.kevin.aslflashcards.manager.DataManagerAccessor;
import com.example.kevin.aslflashcards.manager.FlashCardDataManager;

public class MainActivity extends Activity implements DataManagerAccessor, OptionsFragment.NavigateToCardScreenListener {

    private FlashCardDataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        FragmentManager manager = getFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_layout_holder, OptionsFragment.newInstance());
        transaction.commit();

        dataManager = new FlashCardDataManager(this);
    }

    @Override
    public FlashCardDataManager getDataManager() { return this.dataManager; }

    @Override
    public void NavigateToCardScreen() {
        FragmentManager manager = getFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_layout_holder, CardFragment.newInstance());
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
