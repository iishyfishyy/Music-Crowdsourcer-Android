package com.example.ishyfishy.musiccrowdsourcer;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    EditText user_editText, pass_editText;
    Button login_btn, signup_btn;
    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user_editText = (EditText) findViewById(R.id.userid);
        pass_editText = (EditText) findViewById(R.id.passid);
        login_btn = (Button) findViewById(R.id.loginid);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = user_editText.getText().toString();
                String pass = pass_editText.getText().toString();
                ArrayList<NameValuePair> post_parameters = new ArrayList<NameValuePair>();
                post_parameters.add(new BasicNameValuePair("username", user));
                post_parameters.add(new BasicNameValuePair("password", pass));
                try {
                    Integer reply = new Connection().execute(post_parameters).get();
                    if(reply == 1) {
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity.this, PostLogin.class));
                    } else {
                        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
        signup_btn = (Button) findViewById(R.id.signupid);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(MainActivity.this, SignUp.class);
                startActivity(signup);
            }
        });
      /*  user = (TextView) findViewById(R.id.user);
        new Thread(){
            public void run(){
                for(int i = 0; i < 100; ++i){
                    final int j = i;
                       try {
                           Thread.sleep(2000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               user.setText("Iteration " + j);
                           }
                       });
                   }
                }
        }.start();*/
    }
}
