package com.softwares.gee.score_counter;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public static final String USER_PREFS = "User_Prefs";
    public static final String USER_NAME = "User_name";
    public static final String USER_AGE = "User_age";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);
        //Carregando o Fragment Inicial do Activity
        FragmentManager FragManager = getFragmentManager();
        FragmentTransaction FragTransaction = FragManager.beginTransaction();
        Initial ini_fragment = new Initial();
        ProfileFragment profile_fragment = new ProfileFragment();

        //Cria Shared Preferences e verifica se encontra algum valor
        //pre-armazenado nelas
        SharedPreferences profile = getSharedPreferences(USER_PREFS, MODE_PRIVATE);
        if(profile.getString(USER_NAME,"").equals(""))
            FragTransaction.replace(android.R.id.content,ini_fragment);
        else
            FragTransaction.replace(android.R.id.content,profile_fragment);
        FragTransaction.commit();
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
