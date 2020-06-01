package com.arielmagbanua.activitydemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonDemoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.radio_button_demo_layout, container, false);

        RadioGroup flavorGroup = layout.findViewById(R.id.flavor_group);
        flavorGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.vanilla_radioButton:
                        Toast.makeText(RadioButtonDemoFragment.this.getActivity(), "Vanilla!", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.chocolate_radioButton:
                        Toast.makeText(RadioButtonDemoFragment.this.getActivity(), "Chocolate!", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.strawberry_radioButton:
                        Toast.makeText(RadioButtonDemoFragment.this.getActivity(), "Strawberry!", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.double_dutch_radioButton:
                        Toast.makeText(RadioButtonDemoFragment.this.getActivity(), "Double Dutch!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        return layout;
    }
}
