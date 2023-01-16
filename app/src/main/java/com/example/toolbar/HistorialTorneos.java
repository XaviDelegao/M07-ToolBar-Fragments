package com.example.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HistorialTorneos extends AppCompatActivity {

    List<Tournament> torneos = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_torneos);

        torneos.add(new Tournament(12,"Enero",2021,1));
        torneos.add(new Tournament(19,"Julio",2021,4));
        torneos.add(new Tournament(26,"Julio",2021,2));
        torneos.add(new Tournament(12,"Agosto",2021,3));
        torneos.add(new Tournament(19,"Julio",2022,1));
        torneos.add(new Tournament(26,"Julio",2022,3));
        torneos.add(new Tournament(1,"Diciembre",2022,1));

        ListView historial = findViewById(R.id.tournament_list);
        TournamentAdapter ta = new TournamentAdapter(getApplicationContext(),0,torneos);
        historial.setAdapter(ta);

    }

    public void onSearchClick(View view) {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona mes y año: ");
        View alertView = LayoutInflater.from(this).inflate(R.layout.spinner_alert, null);
        Spinner spinnerMonth = alertView.findViewById(R.id.month);
        String[] months = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};


        Spinner spinnerYear = alertView.findViewById(R.id.year);
        Integer[] years = new Integer[]{2020, 2021, 2022, 2023, 2024};
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, months);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(monthAdapter);

        ArrayAdapter<Integer> yearAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_spinner_item, years);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(yearAdapter);

        builder.setView(alertView);

        builder.setPositiveButton("Limpiar filtros", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Buscar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                List<Tournament> filteredTorunaments = new ArrayList<>();
                for (Tournament t: torneos) {
                    if(t.getMonth() == spinnerMonth.getSelectedItem() && t.getYear() ==Integer.parseInt(spinnerYear.getSelectedItem().toString())){
                        filteredTorunaments.add(t);

                    }
                }

                ListView historial = findViewById(R.id.tournament_list);
                TournamentAdapter ta = new TournamentAdapter(getApplicationContext(),0,filteredTorunaments);
                historial.setAdapter(ta);
                historial.deferNotifyDataSetChanged();

            }
        });
        builder.setCancelable(false);
        builder.show();
    }


}
