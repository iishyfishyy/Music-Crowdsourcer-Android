package com.example.ishyfishy.musiccrowdsourcer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ishaan on 3/27/2016.
 */
public class SongAdapter extends ArrayAdapter<Song> {

    ArrayList<Song> songs;

    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, R.layout.song_row_layout, songs);
        this.songs = songs;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View v = inflater.inflate(R.layout.song_row_layout, parent, false);
        Song song = getItem(position);
        TextView textView = (TextView) v.findViewById(R.id.text_view_1);
        final CheckBox checkBox = (CheckBox) v.findViewById(R.id.song_selected_checkbox);
        textView.setText(song.toString());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                songs.get(position).setSelected(isChecked);
            }
        });
        checkBox.setChecked(songs.get(position).isSelected());
        return v;

    }

    public ArrayList<Song> getSelectedSongs(){
        ArrayList<Song> list = new ArrayList<>();
        for(int i = 0 ; i < songs.size(); ++i){
            if(songs.get(i).isSelected())
                list.add(songs.get(i));
        }
        return list;
    }

    public void setAllSelected(boolean b){
        for(int i = 0 ; i < songs.size(); ++i){
           songs.get(i).setSelected(b);
        }
    }

}
