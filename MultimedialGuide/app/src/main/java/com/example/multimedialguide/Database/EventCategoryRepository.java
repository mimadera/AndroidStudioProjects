package Database;

import android.content.Context;

import com.example.michal.breslau.DatabaseTables.EventsCategory;
import com.example.michal.breslau.DatabaseTables.Food;
import com.example.michal.breslau.DatabaseTables.EventsCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michal on 01.10.2017.
 */

public class EventCategoryRepository {

    public static List<EventsCategory> findAll(Context context) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        return databaseHelper.getEventsCategoryDao().queryForAll();
    }

    public static EventsCategory findById(Context context, long eventsId) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        return databaseHelper.getEventsCategoryDao().queryForId(eventsId);
    }

    public static void addEventCateogry(Context context, EventsCategory eventCategory) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getEventsCategoryDao().create(eventCategory);
    }

    public static void updateEventCategory(Context context, EventsCategory eventCategory) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getEventsCategoryDao().update(eventCategory);
    }

    public static void deleteEventCategory(Context context, EventsCategory eventCategory) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getEventsCategoryDao().delete(eventCategory);
    }

    public static List<String> findAllNames(Context context) {
        List<EventsCategory> tmp = findAll(context);
        List<String> categoriesName = new ArrayList<>();
        for (EventsCategory d : tmp) {
            categoriesName.add(d.getName());
            /*
            do listy categories name to co Ci getName zwróci ;)
             */
        }
        return categoriesName;
    }

    public static EventsCategory findByName(Context context, String name) {
        List<EventsCategory> tmp = findAll(context);
        EventsCategory eventsCategory = null;
        for (EventsCategory e : tmp) {
            if (e.getName().equals(name)) {
                eventsCategory = e;
                break;
            }
        }
        return eventsCategory;
    }
    
}
