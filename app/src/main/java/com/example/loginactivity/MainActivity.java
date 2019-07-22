package com.example.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private boolean checkUser(String userName, String password){
        if(userName.equals("user") && password.equals("password")){
            return true;
        }
        return false;
    }

    public void onClick(View v){
        EditText user = (EditText)findViewById(R.id.userName);
        EditText pass = (EditText)findViewById(R.id.password);
        Button button = (Button)findViewById(R.id.button);
        int count = 5;
        String userName = user.getText().toString();
        String password = pass.getText().toString();
        boolean ans = checkUser(userName,password);
        while (count>0 && ans==true){
            count--;
            ans = checkUser(userName,password);
        }
        if (count>=0 && ans==true){
            Intent temp = new Intent(this,HomePage.class);
            startActivity(temp);
        }
        else{
            button.setEnabled(false);
        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
