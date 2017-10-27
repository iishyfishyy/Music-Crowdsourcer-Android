package com.example.ishyfishy.musiccrowdsourcer;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Ishaan on 3/27/2016.
 */
public class Group {

    private String mTitle;
    private int mNumPeople, mExpTime;
    private UUID mID;
    private Date date;
    private ArrayList<Song> mSongList;

    public Group(){
        mID = UUID.randomUUID();
        date = new Date();
        mSongList = new ArrayList<Song>();
    }

    public Group(String title, int n, int exp){
        mTitle = title;
        mNumPeople = n;
        mExpTime = exp;
        mSongList = new ArrayList<Song>();
    }

    public void setTitle(String t) { mTitle = t; }
    public String getTitle() { return mTitle; }

    public void setNumPeople(int i)  { mNumPeople = i; }
    public int getNumPeople(){ return mNumPeople; }

    public void setExpTime(int i)  { mExpTime = i; }
    public int getExpireTime() { return mExpTime; }

    public Date getDate() { return date; }
    public UUID getID() { return mID; }

    public String toString(){
        return mTitle;
    }

    public void setSongList(ArrayList<Song> s){
        mSongList = s;
    }

}
