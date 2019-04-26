package Database;

import android.content.Context;

import com.example.michal.breslau.DatabaseTables.Food;
import com.example.michal.breslau.DatabaseTables.FoodCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michal on 01.10.2017.
 */

public class FoodCategoryRepository {

    public static List<FoodCategory> findAll(Context context) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        return databaseHelper.getFoodsCategoryDao().queryForAll();
    }

    public static FoodCategory findById(Context context, long foodsId) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        return databaseHelper.getFoodsCategoryDao().queryForId(foodsId);
    }

    public static void addFoodCategory(Context context, FoodCategory foodsCategory) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getFoodsCategoryDao().create(foodsCategory);
    }

    public static void updateFoodCategory(Context context, FoodCategory foodsCategory) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getFoodsCategoryDao().update(foodsCategory);
    }

    public static void deleteFoodCategory(Context context, FoodCategory foodsCategory) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getFoodsCategoryDao().delete(foodsCategory);
    }

    public static List<String> findAllNames(Context context) {
        List<FoodCategory> tmp = findAll(context);
        List<String> categoriesName = new ArrayList<>();
        for (FoodCategory d : tmp) {
            categoriesName.add(d.getName());
        }
        return categoriesName;
    }

    public static FoodCategory findByName(Context context, String name) {
        List<FoodCategory> tmp = findAll(context);
        FoodCategory foodCategory = null;
        for (FoodCategory e : tmp) {
            if (e.getName().equals(name)) {
                foodCategory = e;
                break;
            }
        }
        return foodCategory;
    }
}
