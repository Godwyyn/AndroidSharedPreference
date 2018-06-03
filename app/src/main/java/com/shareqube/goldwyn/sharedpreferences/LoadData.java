package com.shareqube.goldwyn.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoadData extends AppCompatActivity {

    public static final String DEFAULT = "N/A";

    EditText username, password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        username = (EditText) findViewById(R.id.load_username);
        password1 = (EditText) findViewById(R.id.load_password);


    }

    public void load(View view) {

       /* try {
            FileInputStream fos = openFileInput("tutorial.txt");
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while ((read = fos.read()) != -1) {
                buffer.append((char) read);
            }
             String output1 = buffer.substring(0,buffer.indexOf(" "));
            String output2 = buffer.substring(buffer.indexOf(" ")+1);
            username.setText(output1);
            password1.setText(output2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/



        SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
        String name = sharedPreferences.getString("name",DEFAULT);
        String password =  sharedPreferences.getString("password",DEFAULT);

        if (name.equals(DEFAULT) || password.equals(DEFAULT)){

            Toast.makeText(this,"loading details not found",Toast.LENGTH_SHORT).show();

        }
        else {

            username.setText(name);
            password1.setText(password);

            Toast.makeText(this,"loading details successfully",Toast.LENGTH_SHORT).show();
        }

    }


    public void previous(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}


