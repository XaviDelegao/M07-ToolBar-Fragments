package com.example.toolbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class TournamentAdapter extends ArrayAdapter<Tournament> {


    public TournamentAdapter(@NonNull Context context, int resource, @NonNull List<Tournament> objects) {
        super(context, resource, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the Tournament object at the current position
        Tournament tournament = getItem(position);
        // Check if an existing view is being reused
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }
        // Lookup views within the list item layout
        TextView tournamentDay = (TextView) convertView.findViewById(R.id.tournament_day);
        TextView tournamentMonth = (TextView) convertView.findViewById(R.id.tournament_month);
        TextView tournamentYear = (TextView) convertView.findViewById(R.id.tournament_year);
        TextView tournamentResult = (TextView) convertView.findViewById(R.id.tournament_result);

        // Populate the data into the template view
        tournamentDay.setText("Dia: " + tournament.getDay());
        tournamentMonth.setText("Mes: " + tournament.getMonth());
        tournamentYear.setText("Año: "+ tournament.getYear());
        tournamentResult.setText("Resultado: " + tournament.getResultat()+ "º");
        // Return the completed view to render on screen
        return convertView;
    }
}
