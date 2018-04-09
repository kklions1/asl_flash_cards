package com.example.kevin.aslflashcards.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.kevin.aslflashcards.R;
import com.example.kevin.aslflashcards.configuration.UnitConfiguration;
import com.example.kevin.aslflashcards.manager.DataManagerAccessor;
import com.example.kevin.aslflashcards.manager.FlashCardDataManager;

/**
 * Created by kevin on 2/8/18.
 */

public class OptionsFragment extends Fragment {
    private View view;
    private FlashCardDataManager dataManager;

    private RadioButton unitOneRadio;
    private RadioButton unitTwoRadio;
    private RadioButton unitThreeRadio;

    public static OptionsFragment newInstance() {
        return new OptionsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.options_layout, container, false);
        unitOneRadio = view.findViewById(R.id.unit_one_radio);
        unitTwoRadio = view.findViewById(R.id.unit_two_radio);
        unitThreeRadio = view.findViewById(R.id.unit_three_radio);
        return view;
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
        Button startButton = view.findViewById(R.id.start_button);

        startButton.setOnClickListener((view) -> {
            UnitConfiguration.Builder builder = new UnitConfiguration.Builder();
            if (unitOneRadio.isChecked()) {
                builder.unitOne();
            }
            if (unitTwoRadio.isChecked()) {
                builder.unitTwo();
            }

            if (unitThreeRadio.isChecked()) {
                builder.unitThree();
            }

            dataManager.setConfiguration(builder.build());
            dataManager.fetchWordList();

            try {
                ((NavigateToCardScreenListener) getContext()).NavigateToCardScreen();
            } catch (ClassCastException e) {
                e.printStackTrace();
                throw new IllegalStateException("The Activity does not implement the correct interface");
            }
        });

    }

    public interface NavigateToCardScreenListener {
        void NavigateToCardScreen();
    }
}
