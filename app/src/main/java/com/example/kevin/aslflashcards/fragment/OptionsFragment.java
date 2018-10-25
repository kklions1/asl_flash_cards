package com.example.kevin.aslflashcards.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.kevin.aslflashcards.R;
import com.example.kevin.aslflashcards.configuration.UnitConfiguration;
import com.example.kevin.aslflashcards.manager.DataManagerAccessor;
import com.example.kevin.aslflashcards.manager.FlashCardDataManager;

/**
 * Created by kevin on 2/8/18.
 * Unit 5 & 6 added by Devinn 10/11/18.
 * Unit 7 & 8 added by Devinn 10/13/18
 */

public class OptionsFragment extends Fragment {
    private View view;
    private FlashCardDataManager dataManager;

    private CheckBox unitOneCheckBox;
    private CheckBox unitTwoCheckBox;
    private CheckBox unitThreeCheckBox;
    private CheckBox unitFourCheckBox;
    private CheckBox unitFiveCheckBox;
    private CheckBox unitSixCheckBox;
    private CheckBox unitSevenCheckBox;

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
        unitOneCheckBox = view.findViewById(R.id.unit_one_radio);
        unitTwoCheckBox = view.findViewById(R.id.unit_two_radio);
        unitThreeCheckBox = view.findViewById(R.id.unit_three_radio);
        unitFourCheckBox = view.findViewById(R.id.unit_four_radio);
        unitFiveCheckBox = view.findViewById(R.id.unit_five_radio);
        unitSixCheckBox = view.findViewById(R.id.unit_six_radio);
        unitSevenCheckBox = view.findViewById(R.id.unit_seven_radio);
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
            if (unitOneCheckBox.isChecked()) {
                builder.unitOne();
            }
            if (unitTwoCheckBox.isChecked()) {
                builder.unitTwo();
            }

            if (unitThreeCheckBox.isChecked()) {
                builder.unitThree();
            }

            if (unitFourCheckBox.isChecked()) {
                builder.unitFour();
            }

            if (unitFiveCheckBox.isChecked()) {
                builder.unitFive();
            }

            if (unitSixCheckBox.isChecked()) {
                builder.unitSix();
            }

            if (unitSevenCheckBox.isChecked()) {
                builder.unitSeven();
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
