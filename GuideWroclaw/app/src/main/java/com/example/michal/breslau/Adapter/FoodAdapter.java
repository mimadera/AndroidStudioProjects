package com.example.michal.breslau.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.michal.breslau.AttractionsListActivity;
import com.example.michal.breslau.DatabaseTables.Food;
import com.example.michal.breslau.MapsActivity;
import com.example.michal.breslau.R;

import java.util.ArrayList;

/**
 * Created by Michal on 04.10.2017.
 */

public class FoodAdapter extends ArrayAdapter<Food> {
    private Context context;

    public FoodAdapter(ArrayList<Food> food, Context context) {
            super(context, R.layout.single_list_text_view, food);
            this.context = context;
            }

        /*
        optymalizuje proces tworzenia obiektów i gospodarkę pamięcią
        stała liczba obiektów podmieniania danych nie traci zasobów na tworzenie obiketów
         */
    private static class ViewHolder{
        TextView bodyParameterTextView;
        LinearLayout layout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Food dataModel = getItem(position); // pojedyńczu obiekt ktory chcemy printowac
        ViewHolder viewHolder;
        if(convertView == null) { //
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.single_list_text_view, parent, false);
            viewHolder.bodyParameterTextView = convertView.findViewById(R.id.listTitleTextView);
            viewHolder.layout = convertView.findViewById(R.id.notesLinearLayout); // Layout
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.bodyParameterTextView.setText(dataModel.getName());
        viewHolder.layout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MapsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("parameterId", dataModel.getId());
                intent.putExtra("repositoryUsed", 2);
                view.getContext().startActivity(intent);


            }
        });
        return convertView;
    }
}

