package com.example.toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_1:
                // handle action
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void logOut(MenuItem item) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void toPerfil(View view) {
        Intent i = new Intent(this, Perfil.class);
        startActivity(i);
    }

    public void toInscripcion(View view) {
        Intent i = new Intent(this, Torneos.class);
        startActivity(i);
    }

    public void options(MenuItem item) {
        Intent i = new Intent(this, Options.class);
        startActivity(i);
    }

    public void toHistorial(View view) {
        Intent i = new Intent(this, HistorialTorneos.class);
        startActivity(i);
    }
}