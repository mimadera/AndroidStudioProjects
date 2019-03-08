package com.example.michal.breslau.Database;

import android.content.Context;

import com.example.michal.breslau.DatabaseTables.Food;
import com.example.michal.breslau.DatabaseTables.FoodCategory;

import java.util.ArrayList;
import java.util.List;

public class FoodRepository {

    public static List<Food> findAll(Context context) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        return databaseHelper.getFoodDao().queryForAll();
    }

    public static Food findById(Context context, long foodId) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        return databaseHelper.getFoodDao().queryForId(foodId);
    }

    public static void addfood(Context context, Food food) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getFoodDao().create(food);
    }

    public static void updatefood(Context context, Food food) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getFoodDao().update(food);
    }

    public static void deletefood(Context context, Food food) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getFoodDao().delete(food);
    }

    public static void deleteAllRecords(Context context){
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        List<Food> foods = FoodRepository.findAll(context);
        for(Food f: foods){
            deletefood(context, f);
        }
    }

    public static List<Food> filterList(List<Food> preFilterList, FoodCategory foodCategory){
        List<Food> filteredList = new ArrayList();

        if(foodCategory != null){

            for (Food e: preFilterList){
                    /*

                     */
                if (e.getCategory().getId() == foodCategory.getId()){

                    filteredList.add(e);

                }

            }

        }

        return filteredList;
        //argument dla adaptera
    }

}
