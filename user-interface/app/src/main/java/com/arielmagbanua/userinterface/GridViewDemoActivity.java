package com.arielmagbanua.userinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridViewDemoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<Meme> memes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_demo);

        memes.add(new Meme("Perfect Avocado", "avocado.jpeg"));
        memes.add(new Meme("Mag Biko Ta", "biko_ta.jpg"));
        memes.add(new Meme("Advance Mag Isip", "leader_advance_magisip.jpg"));
        memes.add(new Meme("Joker, Everyone Loses Their Minds", "pee_pool.jpg"));
        memes.add(new Meme("What If I Told You", "what_if.jpg"));
        memes.add(new Meme("You Shall Not Pass", "you_shall_not_pass.jpg"));
        memes.add(new Meme("You're Road", "youre_road.jpg"));

        GridView memeGrid = findViewById(R.id.meme_gridView);
        MemeAdapter adapter = new MemeAdapter(this, R.layout.meme_grid_layout, memes);
        memeGrid.setAdapter(adapter);

        memeGrid.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView memeTitleTextview = view.findViewById(R.id.meme_title_textView);
        Toast.makeText(this, memeTitleTextview.getText().toString(), Toast.LENGTH_LONG).show();
    }
}
