package com.arielmagbanua.androiddemos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxDemoFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

    private CheckBox vanillaCheckbox = null;
    private CheckBox chocolateCheckBox = null;
    private CheckBox strawberryCheckBox = null;
    private CheckBox doubleDutchCheckBox = null;
    private boolean vanillaCheckBoxValue = false;
    private boolean chocolateCheckBoxValue = false;
    private boolean strawberryCheckBoxValue = false;
    private boolean doubleDutchCheckBoxValue = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.checkbox_demo_layout, container, false);

        vanillaCheckbox = layout.findViewById(R.id.vanilla_checkBox);
        chocolateCheckBox = layout.findViewById(R.id.chocolate_checkBox);
        strawberryCheckBox = layout.findViewById(R.id.strawberry_checkBox);
        doubleDutchCheckBox = layout.findViewById(R.id.double_dutch_checkBox);

        vanillaCheckbox.setOnCheckedChangeListener(this);
        chocolateCheckBox.setOnCheckedChangeListener(this);
        strawberryCheckBox.setOnCheckedChangeListener(this);
        doubleDutchCheckBox.setOnCheckedChangeListener(this);

        return layout;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String message = "";
        int id = buttonView.getId();

        switch (id){
            case R.id.vanilla_checkBox:
                message = isChecked ? "Vanilla is chosen!" : "";
                break;

            case R.id.chocolate_checkBox:
                message = isChecked ? "Chocolate is chosen!" : "";
                break;

            case R.id.strawberry_checkBox:
                message = isChecked ? "Strawberry is chosen!" : "";
                break;

            case R.id.double_dutch_checkBox:
                message = isChecked ? "Double Dutch is chosen!" : "";
                break;
        }

        if(!message.isEmpty()){
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        }
    }
}
