package com.example.ishyfishy.musiccrowdsourcer;

import android.os.AsyncTask;

import org.apache.http.NameValuePair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.jar.Attributes;

/**
 * Created by ishyfishy on 3/26/2016.
 */
public class Connection extends AsyncTask<ArrayList<NameValuePair>, Void, Integer> {
    protected Integer doInBackground(ArrayList<NameValuePair>... post_parameters){
        String response = null;
        try{
            String URL = "http://www.mishrai.net/check.php";
            if(post_parameters[0].get(0).getName().contains("signup"))
                URL = "http://www.mishrai.net/signup.php";
            response = HttpHandler.executeHttpPost(URL, post_parameters[0]);
            String res = response.toString();
            res = res.replaceAll("\\s+","");
            return (res.equals("1") ? 1 : res.equals("0") ? 0 : 2);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}