package com.example.ishyfishy.musiccrowdsourcer;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SongSelector extends Activity {

    private ArrayList<Song> mSongList;
    private ListView mSongView;
    private Button mDone;
    private CheckBox mSelectAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_selector);

        mSongView = (ListView) findViewById(R.id.song_list);
        mSongList = new ArrayList<Song>();
        getSongList();

        Collections.sort(mSongList, new Comparator<Song>() {
            public int compare(Song a, Song b) {
                return a.getTitle().compareTo(b.getTitle());
            }
        });

        SongAdapter adapter = new SongAdapter(this, mSongList);
        mSongView.setAdapter(adapter);

        mSelectAll = (CheckBox) findViewById(R.id.select_all_id);
        mDone = (Button) findViewById(R.id.song_select_done);

        mSelectAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ((SongAdapter)mSongView.getAdapter()).setAllSelected(isChecked);
            }
        });

        mDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("songs", ((SongAdapter)mSongView.getAdapter()).getSelectedSongs());
                setResult(RESULT_OK, i);
                finish();
            }
        });

    }

    public void getSongList(){
        ContentResolver music_resolver = getContentResolver();
        Uri music_uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor music_cursor = music_resolver.query(music_uri, null, null, null, null);
        if(music_cursor != null && music_cursor.moveToFirst()){
            int title_column = music_cursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int id_column = music_cursor.getColumnIndex(MediaStore.Audio.Media._ID);
            int artist_column = music_cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            do{
                long id = music_cursor.getLong(id_column);
                String title = music_cursor.getString(title_column);
                String artist = music_cursor.getString(artist_column);
                mSongList.add(new Song(id, title, artist));
            } while (music_cursor.moveToNext());
        }
    }

}
