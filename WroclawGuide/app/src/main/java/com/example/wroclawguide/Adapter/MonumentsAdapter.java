package com.example.wroclawguide.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wroclawguide.DatabaseTables.Monuments;
import com.example.wroclawguide.MapsActivity;
import com.example.wroclawguide.R;

import java.util.ArrayList;

public class MonumentsAdapter extends ArrayAdapter<Monuments> {

    private Context context;

    public MonumentsAdapter(ArrayList<Monuments> monuments, Context context) {
        super(context, R.layout.single_list_text_view, monuments);
        this.context = context;
    }


    private static class ViewHolder{
        TextView bodyParameterTextView;
        LinearLayout layout;
    }
    //klasa trzyma referencje do raz znalezionego pola tekstowego unikajac ciaglych referencji do findViewById()

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Monuments dataModel = getItem(position); // pojedyńczuy obiekt ktory chcemy printowac
        ViewHolder viewHolder;
        if(convertView == null) { // jezeli converyView jest nullem tworzymy go
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.single_list_text_view, parent, false);
            //umieszczamy w nim referencje do znalzeionego metoda findViewById pola tekstowego
            viewHolder.bodyParameterTextView = convertView.findViewById(R.id.listTitleTextView);
            viewHolder.layout = convertView.findViewById(R.id.notesLinearLayout); // Layout
            //przypisujemy obiekt ViewHolder do widoku aby wykorzystac go w przyszlosci i nie korzytsac juz z findViewByID
            convertView.setTag(viewHolder);
        } else {
            //jezeli istnieje to wykorzystujemy go z gotowym polem tekstowym
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.bodyParameterTextView.setText(dataModel.getName());
        viewHolder.layout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MapsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("parameterId", dataModel.getId());
                intent.putExtra("repositoryUsed", 3);
                view.getContext().startActivity(intent);

            }
        });
        return convertView;
    }
}