package com.arielmagbanua.androiddemos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridViewDemoFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ArrayList<Meme> memes = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.grid_view_demo_layout, container, false);

        memes.add(new Meme("Mag Biko Ta", "biko_ta.jpg"));
        memes.add(new Meme("Advance Mag Isip", "leader_advance_magisip.jpg"));
        memes.add(new Meme("Joker, Everyone Loses Their Minds", "pee_pool.jpg"));
        memes.add(new Meme("What If I Told You", "what_if.jpg"));
        memes.add(new Meme("You Shall Not Pass", "you_shall_not_pass.jpg"));
        memes.add(new Meme("You're Road", "youre_road.jpg"));
        memes.add(new Meme("Perfect Avocado", "avocado.jpeg"));

        GridView memeGrid = layout.findViewById(R.id.meme_gridView);
        MemeAdapter adapter = new MemeAdapter(getActivity(), R.layout.meme_grid_layout, memes);
        memeGrid.setAdapter(adapter);

        memeGrid.setOnItemClickListener(this);
        memeGrid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TextView memeTitleTextview = view.findViewById(R.id.meme_title_textView);
                Toast.makeText(GridViewDemoFragment.this.getActivity(), memeTitleTextview.getText().toString(), Toast.LENGTH_LONG).show();

                return true;
            }
        });

        return layout;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView memeTitleTextview = view.findViewById(R.id.meme_title_textView);
        Toast.makeText(getActivity(), memeTitleTextview.getText().toString(), Toast.LENGTH_LONG).show();
    }
}
