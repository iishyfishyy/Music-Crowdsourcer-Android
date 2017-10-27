package com.example.ishyfishy.musiccrowdsourcer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class NewGroup extends Activity {

    private static final int SONG_RETURN_ID = 69;
    EditText mGroupName, mExpireTime, mNumPeople;
    Button mSelectSongs, mInitGroup;
    ArrayList<Song> songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);
        initWidgets();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        if(extras != null){
            songList = (ArrayList<Song>) extras.get("songs");
            if(songList == null){
                Toast.makeText(this, "Error: list is NULL", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void initWidgets(){
        mGroupName = (EditText) findViewById(R.id.group_name_id);
        mExpireTime = (EditText) findViewById(R.id.expire_time_id);
        mNumPeople = (EditText) findViewById(R.id.num_people_id);
        mSelectSongs = (Button) findViewById(R.id.select_song_id);
        mSelectSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NewGroup.this, SongSelector.class);
                startActivityForResult(i, SONG_RETURN_ID);
            }
        });
        mInitGroup = (Button) findViewById(R.id.init_group_id);
        mInitGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String groupName = mGroupName.getText().toString();
                String expireTime;
                String numPeople;
                expireTime = mExpireTime.getText().toString();
                numPeople = mNumPeople.getText().toString();
                if(!expireTime.matches("\\d+") || !numPeople.matches("\\d+"))
                    Toast.makeText(NewGroup.this, "Please enter an INTEGER for the last two fields.", Toast.LENGTH_SHORT).show();
                else {
                    Group g = new Group(groupName, Integer.parseInt(numPeople), Integer.parseInt(expireTime));
                    g.setSongList(songList);
                    GroupLab.get(getApplicationContext()).add(g);
                    Toast.makeText(NewGroup.this, "Group made!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(NewGroup.this, PostLogin.class));
                }
            }
        });
    }

}
