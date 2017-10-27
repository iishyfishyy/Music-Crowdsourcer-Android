package com.example.ishyfishy.musiccrowdsourcer;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ishaan on 3/26/2016.
 */
public class FirstFragment extends Fragment {

    ListView mGroupsListView;
    private ArrayList<Group> mGroups;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.groups);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_first, parent, false);

        mGroups = GroupLab.get(getActivity()).getGroups();
        ListAdapter adapter = new ArrayAdapter<Group>(getActivity(), android.R.layout.simple_list_item_1, mGroups);
        mGroupsListView = (ListView) v.findViewById(R.id.groups_list_view);
        mGroupsListView.setAdapter(adapter);
        mGroupsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent i = new Intent(getActivity(), )
            }
        });

        return v;
    }


}
