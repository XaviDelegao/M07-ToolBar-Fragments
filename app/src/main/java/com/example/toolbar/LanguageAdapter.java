package com.example.toolbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class LanguageAdapter extends ArrayAdapter<String> {
    //constructor
    public LanguageAdapter(Context context, String[] languages) {
        super(context, android.R.layout.simple_spinner_item, languages);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        // Personalizar la vista de los elementos del spinner
        TextView v = (TextView) super.getDropDownView(position, convertView, parent);
        v.setTextSize(18);
        v.setPadding(16, 16, 16, 16);
        return v;
    }
}
