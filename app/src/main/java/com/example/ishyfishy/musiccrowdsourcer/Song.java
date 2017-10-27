package com.example.ishyfishy.musiccrowdsourcer;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Ishaan on 3/27/2016.
 */
public class Song implements Serializable{

    private long mID;
    private String mTitle;
    private String mArtist;
    private boolean isSelected = false;

    public Song(long id, String title, String artist){
        mTitle = title;
        mArtist = artist;
        mID = id;
    }

    public void setSelected(boolean b){
        isSelected = b;
    }

    public boolean isSelected(){
        return isSelected;
    }

    public long getID(){
        return mID;
    }

    public String getTitle(){
        return mTitle;
    }

    public String getArtist(){
        return mArtist;
    }

    public String toString(){
        return mArtist + " - " + mTitle;
    }

}
