package com.example.wroclawguide.Database;


import android.content.Context;

import com.example.wroclawguide.DatabaseTables.Monuments;
import com.example.wroclawguide.DatabaseTables.MonumentsCategory;

import java.util.ArrayList;
import java.util.List;

public class MonumentsRepository {

    public static List<Monuments> findAll(Context context) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        return databaseHelper.getMonumentsDao().queryForAll();
    }

    public static Monuments findById(Context context, long MonumentsId) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        return databaseHelper.getMonumentsDao().queryForId(MonumentsId);
    }

    public static void addMonuments(Context context, Monuments monuments) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getMonumentsDao().create(monuments);
    }

    public static void updateMonuments(Context context, Monuments monuments) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getMonumentsDao().update(monuments);
    }

    public static void deleteMonuments(Context context, Monuments monuments) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getMonumentsDao().delete(monuments);
    }

    public static void deleteAllRecords(Context context){
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        List<Monuments> monuments = MonumentsRepository.findAll(context);
        for(Monuments m: monuments){
            deleteMonuments(context, m);
        }
    }

    public static List<Monuments> filterList(List<Monuments> preFilterList, MonumentsCategory monumentsCategory){
        List<Monuments> filteredList = new ArrayList();

        if(monumentsCategory != null){

            for (Monuments e: preFilterList){

                if (e.getCategory().getId() == monumentsCategory.getId()){

                    filteredList.add(e);

                }

            }

        }

        return filteredList;
        //argument dla adaptera
    }
}
