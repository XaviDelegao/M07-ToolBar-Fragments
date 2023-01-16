package com.example.toolbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Torneos extends AppCompatActivity {
        List<ActiveTournament> activeTournaments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torneos);

        activeTournaments.add(new ActiveTournament("Vanguard", "Sabado","Inscripcion: 5€ \n Formato: Standar \n Premios: Picking por clasificacion",21,"Enero",2023));
        activeTournaments.add(new ActiveTournament("One Piece", "Sabado","Inscripcion: 6€ \n Formato: Standar \n Premios: Picking Top 8 \n Promo winner al ganador \n Promo por participacion",21,"Enero",2023));


        Toolbar ttb = findViewById(R.id.toolbar_ins);
        ttb.setTitle("Vanguard (Sabado)");

        ttb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.info_torneo:
                        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                        builder.setTitle("Informacion del torneo: ");
                        builder.setMessage("Inscripcion: 5€ \n Formato: Standar \n Premios: Picking por clasificacion");


                        builder.show();
                        break;
                    case R.id.insc:
                            Intent intent =new Intent(getApplicationContext(), Inscripcion.class);
                            startActivity(intent);

                        break;
                }
                return true;
            }

        });
        ttb.inflateMenu(R.menu.menu2);

        ListView toolbars = findViewById(R.id.insList);
        InscriptionAdapter ia = new InscriptionAdapter(getApplicationContext(), activeTournaments);
        toolbars.setAdapter(ia);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }


}