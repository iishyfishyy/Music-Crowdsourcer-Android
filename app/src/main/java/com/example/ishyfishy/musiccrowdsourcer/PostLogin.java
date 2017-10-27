package com.example.ishyfishy.musiccrowdsourcer;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;


public class PostLogin extends FragmentActivity {

    Button mNewGroup, mJoinGroup;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_login);

        FragmentManager fm = getFragmentManager();
        Fragment firstFragment = fm.findFragmentById(R.id.fragment_container);

        if(firstFragment == null){
            firstFragment = new FirstFragment();
            fm.beginTransaction().add(R.id.fragment_container, firstFragment).commit();
        }

        mNewGroup = (Button) findViewById(R.id.make_group_id);
        mNewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make a new group here
                Intent i = new Intent(PostLogin.this, NewGroup.class);
                startActivity(i);
            }
        });
        mJoinGroup = (Button) findViewById(R.id.join_group_id);
        mJoinGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //join new group here

            }
        });


    }

}