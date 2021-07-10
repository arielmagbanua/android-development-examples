package com.arielmagbanua.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentB extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b_layout, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d("FRAGMENT_TAG", "Fragment B onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d("FRAGMENT_TAG", "Fragment B onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.d("FRAGMENT_TAG", "Fragment B onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.d("FRAGMENT_TAG", "Fragment B onStop()");
    }
}
