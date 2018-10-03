package com.arielmagbanua.activitydemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ButtonDemoFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.button_demo_layout, container, false);

        // find all the buttons
        Button ordinaryButton = layout.findViewById(R.id.ordinary_button);
        ImageButton imageButton = layout.findViewById(R.id.image_button);
        Button buttonWithIconAtLeft = layout.findViewById(R.id.button_with_icon_at_left);
        Button buttonWithIconAtRight = layout.findViewById(R.id.button_with_icon_at_right);

        ordinaryButton.setOnClickListener(this);
        imageButton.setOnClickListener(this);
        buttonWithIconAtLeft.setOnClickListener(this);
        buttonWithIconAtRight.setOnClickListener(this);

        return layout;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.ordinary_button:
                Toast.makeText(getActivity(), "Ordinary Button", Toast.LENGTH_SHORT).show();
                break;

            case R.id.image_button:
                Toast.makeText(getActivity(), "Image Button", Toast.LENGTH_SHORT).show();
                break;

            case R.id.button_with_icon_at_left:
                Toast.makeText(getActivity(), "Button With Left Icon", Toast.LENGTH_SHORT).show();
                break;

            case R.id.button_with_icon_at_right:
                Toast.makeText(getActivity(), "Button with Right Icon", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
