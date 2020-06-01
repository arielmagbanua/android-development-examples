package com.notes.arielmagbanua.simplenotetakingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends ArrayAdapter {
    private Context context = null;
    private int itemLayoutResource = 0;
    private ArrayList<Note> notes = null;

    public NotesAdapter(Context context, int resource, ArrayList<Note> notes) {
        super(context, resource, notes);

        this.context = context;
        this.itemLayoutResource = resource;
        this.notes = notes;
    }

    public void setDataset(ArrayList<Note> notes){
        this.notes = notes;
    }

    @Override
    public Note getItem(int position) {
        return notes.get(position);
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Note note = getItem(position);

        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(this.itemLayoutResource, parent, false);

        TextView titleTextView = layout.findViewById(R.id.note_title);
        TextView createdAtTextView = layout.findViewById(R.id.created_at);

        titleTextView.setText(note.getTitle());
        createdAtTextView.setText(note.getCreatedAt());

        return layout;
    }
}
