package com.arielmagbanua.androiddemos;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MemeAdapter extends ArrayAdapter<Meme> {

    private Context context;
    private int itemLayoutResource;
    private ArrayList<Meme> memes = new ArrayList<>();

    public MemeAdapter(@NonNull Context context, int resource, @NonNull List<Meme> memes) {
        super(context, resource, memes);

        this.context = context;
        this.itemLayoutResource = resource;
        this.memes.addAll(memes);
    }

    @Nullable
    @Override
    public Meme getItem(int position) {
        return this.memes.get(position);
    }

    @Override
    public int getCount() {
        return this.memes.size();
    }

    @Override
    public int getPosition(@Nullable Meme item) {
        return this.memes.indexOf(item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Meme meme = getItem(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View memeItemLayout = inflater.inflate(itemLayoutResource, parent, false);

        ImageView memeImageView = memeItemLayout.findViewById(R.id.meme_imageView);
        TextView memeTitle = memeItemLayout.findViewById(R.id.meme_title_textView);

        if(meme.getName() != null){
            memeTitle.setText(meme.getName());
        }

        if(meme.getImageFileName() != null){
            try {
                Bitmap bitmap = getBitmapFromAssets(context, meme.getImageFileName());

                memeImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return memeItemLayout;
    }

    public Bitmap getBitmapFromAssets(Context context, String fileName) throws IOException {
        AssetManager assetManager = context.getAssets();

        InputStream istr = assetManager.open(fileName);
        Bitmap bitmap = BitmapFactory.decodeStream(istr);

        return bitmap;
    }
}
