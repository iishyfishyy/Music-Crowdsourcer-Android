package com.example.ishyfishy.musiccrowdsourcer;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Ishaan on 3/27/2016.
 */
public class GroupLab {

    private ArrayList<Group> mGroups;

    private static GroupLab sGroupLab;
    private Context mAppContext;

    private GroupLab(Context context){
        mAppContext = context;
        mGroups = new ArrayList<Group>();
    }

    public static GroupLab get(Context c){
        if(sGroupLab == null){
            sGroupLab = new GroupLab(c.getApplicationContext());
        }
        return sGroupLab;
    }

    public ArrayList<Group> getGroups(){
        return mGroups;
    }

    public Group getGroup(UUID id){
        for(Group g : mGroups){
            if(g.getID().equals(id))
                return g;
        }
        return null;
    }

    public void add(Group g){
        mGroups.add(g);
    }

}
