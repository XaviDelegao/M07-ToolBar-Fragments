package com.example.toolbar;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class InscriptionAdapter extends BaseAdapter {
    private Context context;
    private List<ActiveTournament> tournaments;

    public InscriptionAdapter(Context context, List<ActiveTournament> toolbarTitles) {
        this.context = context;
        this.tournaments = toolbarTitles;
    }



    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the layout for each item of the ListView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.inscription_view, parent, false);
        }
        Toolbar ttb = convertView.findViewById(R.id.toolbar_ins);
        ttb.setTitle(tournaments.get(position).getGame() + "(" + tournaments.get(position).getWeekDay() + ")" );

        ttb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.info_torneo:
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Informacion del torneo: ");
                        builder.setMessage(tournaments.get(position).getInfo());
                        break;
                    case R.id.insc:
                        if(ttb.getTitle() == "Vanguard"){
                            Intent intent =new Intent(context, Inscripcion.class);
                            context.startActivity(intent);
                        }
                        if(ttb.getTitle() == "One Piece"){
                            Intent intent = new Intent(context, InscripcionOP.class);
                            context.startActivity(intent);
                        }
                        break;
                }
                return true;
            }

        });
        ttb.inflateMenu(R.menu.menu2);

        return convertView;
    }

}
