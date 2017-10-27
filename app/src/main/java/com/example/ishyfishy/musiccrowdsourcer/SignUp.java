package com.example.ishyfishy.musiccrowdsourcer;

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

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class SignUp extends AppCompatActivity {

    EditText user=null, pass=null;
    Button signup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user = (EditText) findViewById(R.id.pickuserid);
        pass = (EditText) findViewById(R.id.pickpassid);
        signup_btn = (Button) findViewById(R.id.submitsignup);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usern = user.getText().toString();
                String passw = pass.getText().toString();
                ArrayList<NameValuePair> post_parameters = new ArrayList<NameValuePair>();
                post_parameters.add(new BasicNameValuePair("signupusername", usern));
                post_parameters.add(new BasicNameValuePair("signuppassword", passw));
                try {
                    Integer reply = new Connection().execute(post_parameters).get();
                    if(reply == 1) {
                        Toast.makeText(SignUp.this, "Registered Sucessfully", Toast.LENGTH_LONG).show();
                        Thread.sleep(1000);
                        startActivity(new Intent(SignUp.this, MainActivity.class));
                    } else {
                        Toast.makeText(SignUp.this, "Username Already Exists", Toast.LENGTH_LONG).show();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });


    }

}
