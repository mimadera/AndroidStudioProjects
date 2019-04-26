package com.example.wroclawguide.Database;

import android.content.Context;

import com.example.wroclawguide.DatabaseTables.Event;
import com.example.wroclawguide.DatabaseTables.EventsCategory;

import java.util.ArrayList;
import java.util.List;

public class EventRepository {


    public static List<Event> findAll(Context context) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        return databaseHelper.getEventDao().queryForAll();
    }

    public static Event findById(Context context, long eventId) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        return databaseHelper.getEventDao().queryForId(eventId);
    }

    public static void addEvent(Context context, Event event) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getEventDao().create(event);
    }

    public static void updateEvent(Context context, Event event) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getEventDao().update(event);
    }

    public static void deleteEvent(Context context, Event event) {
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        databaseHelper.getEventDao().delete(event);
    }

    public static void deleteAllRecords(Context context){
        OrmLiteDatabaseHelper databaseHelper = OrmLiteDatabaseHelper.getInstance(context);
        List<Event> events = EventRepository.findAll(context);
        for(Event e: events){
            deleteEvent(context, e);
        }
    }

    public static List<Event> filterList(List<Event> preFilterList, EventsCategory eventsCategory){
        List<Event> filteredList = new ArrayList();

        if(eventsCategory != null){

            for (Event e: preFilterList){
                /*

                 */
                if (e.getCategory().getId() == eventsCategory.getId()){

                    filteredList.add(e);

                }

            }

        }

        return filteredList;
        //argument dla adaptera
    }

}
