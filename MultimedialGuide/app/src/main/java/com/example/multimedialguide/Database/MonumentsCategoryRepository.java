package Database;

import android.content.Context;

import com.example.michal.breslau.DatabaseTables.Food;
import com.example.michal.breslau.DatabaseTables.MonumentsCategory;
import com.example.michal.breslau.DatabaseTables.Monuments;
import com.example.michal.breslau.DatabaseTables.MonumentsCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michal on 01.10.2017.
 */

public class MonumentsCategoryRepository  {

    public static List<MonumentsCategory> findAll(Context context) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        return databaseHelper.getMonumentsCategoryDao().queryForAll();
    }

    public static MonumentsCategory findById(Context context, long monumentsId) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        return databaseHelper.getMonumentsCategoryDao().queryForId(monumentsId);
    }

    public static void addMonumentCategory(Context context, MonumentsCategory monumentsCategory) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getMonumentsCategoryDao().create(monumentsCategory);
    }

    public static void updateMonumentCategory(Context context, MonumentsCategory monumentsCategory) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getMonumentsCategoryDao().update(monumentsCategory);
    }

    public static void deleteMonumentCategory(Context context, MonumentsCategory monumentsCategory) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getMonumentsCategoryDao().delete(monumentsCategory);
    }

    public static List<String> findAllNames(Context context) {
        List<MonumentsCategory> tmp = findAll(context);
        List<String> categoriesName = new ArrayList<>();
        for (MonumentsCategory d : tmp) {
            categoriesName.add(d.getName());
        }
        return categoriesName;
    }

    public static MonumentsCategory findByName(Context context, String name) {
        List<MonumentsCategory> tmp = findAll(context);
        MonumentsCategory monumentsCategory = null;
        for (MonumentsCategory e : tmp) {
            if (e.getName().equals(name)) {
                monumentsCategory = e;
                break;
            }
        }
        return monumentsCategory;
    }

}
