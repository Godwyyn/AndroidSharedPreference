package com.shareqube.goldwyn.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        username = (EditText) findViewById(R.id.save_username);
        password = (EditText) findViewById(R.id.save_password);


    }

    public void save(View view){

        SharedPreferences sharedPref = getSharedPreferences("MyData",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("name",username.getText().toString());
        editor.putString("password",password.getText().toString());
        editor.commit();
       /* String input1 = username.getText().toString();
        String input2 = password.getText().toString();
        input1 = input1 + " ";
        File file = null;

        FileOutputStream fos = null;
        try{
            file = getFilesDir();
            fos = openFileOutput("tutorial.txt",MODE_PRIVATE);
            fos.write(input1.getBytes());
            fos.write(input2.getBytes());


        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }*/

        Toast.makeText(this, "Your details has been save" , Toast.LENGTH_SHORT).show();

    }

    public void next(View view){

        Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,LoadData.class);
        startActivity(intent);

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
