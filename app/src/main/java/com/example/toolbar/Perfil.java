package com.example.toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Toolbar toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setTitle("Perfil de Usuario");



    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.profile_options) {
            // Handle settings option click
            return true;
        } else if (id == R.id.profile_edit) {
            // Handle profile option click
            return true;
        } else if (id == R.id.profile_logout) {
            // Handle logout option click
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void logOut(MenuItem item) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void logout(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void options(View view) {
        Intent i = new Intent(this, Options.class);
        startActivity(i);
    }
}