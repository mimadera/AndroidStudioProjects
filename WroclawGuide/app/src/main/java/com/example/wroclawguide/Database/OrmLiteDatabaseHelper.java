package com.example.wroclawguide.Database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.wroclawguide.DatabaseTables.Event;
import com.example.wroclawguide.DatabaseTables.EventsCategory;
import com.example.wroclawguide.DatabaseTables.Monuments;
import com.example.wroclawguide.DatabaseTables.MonumentsCategory;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;

public class OrmLiteDatabaseHelper extends OrmLiteSqliteOpenHelper {

    private RuntimeExceptionDao<Event, Long> eventDao;
    private RuntimeExceptionDao<EventsCategory, Long> eventsCategoryDao;
    private RuntimeExceptionDao<Monuments, Long> monumentsDao;
    private RuntimeExceptionDao<MonumentsCategory, Long> monumentsCategoryDao;


    private static OrmLiteDatabaseHelper instance;

    private static final String DATABASE_NAME = "ormLiteDB";
    private static final int DATABASE_VERSION = 2;

    private Context context;

    private OrmLiteDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }


    public static OrmLiteDatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new OrmLiteDatabaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        Log.d("database", "onCreate start");
        recreateTables();
        Log.d("database", "onCreate end");

        fillTables();
    }


    private void fillTables() {

        /*
         ********************* MONUMENTS REPOSITORY *********************
         */

        MonumentsCategory museums = new MonumentsCategory("Muzea");
        MonumentsCategory dwarfs = new MonumentsCategory("Krasnoludki");
        MonumentsCategory monuments = new MonumentsCategory("Zabytki");

        MonumentsCategoryRepository.addMonumentCategory(context, museums);
        MonumentsCategoryRepository.addMonumentCategory(context, dwarfs);
        MonumentsCategoryRepository.addMonumentCategory(context, monuments);

        /*
         ********************* EVENTS REPOSITORY *********************
         */

        EventsCategory concert = new EventsCategory("Koncerty");
        EventCategoryRepository.addEventCateogry(context, concert);

        EventsCategory exhibition = new EventsCategory("Wystawy");
        EventCategoryRepository.addEventCateogry(context, exhibition);

        EventsCategory festival = new EventsCategory("Festiwal");
        EventCategoryRepository.addEventCateogry(context, festival);

        EventsCategory localEvents= new EventsCategory("Imprezy okolicznościowe");
        EventCategoryRepository.addEventCateogry(context, localEvents);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        Log.d("database", "onUpgrade start");
        recreateTables();
        Log.d("database", "onUpgrade end");
    }


    private void recreateTables() {
        try {

            TableUtils.dropTable(connectionSource, Event.class, true);
            TableUtils.createTableIfNotExists(connectionSource, Event.class);
            TableUtils.dropTable(connectionSource, Monuments.class, true);
            TableUtils.createTableIfNotExists(connectionSource, Monuments.class);

            TableUtils.dropTable(connectionSource, EventsCategory.class, true);
            TableUtils.createTableIfNotExists(connectionSource, EventsCategory.class);

            TableUtils.dropTable(connectionSource, MonumentsCategory.class, true);
            TableUtils.createTableIfNotExists(connectionSource, MonumentsCategory.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public RuntimeExceptionDao<Event, Long> getEventDao() {
        if (eventDao == null) {
            eventDao = getRuntimeExceptionDao(Event.class);
        }
        return eventDao;
    }

    public RuntimeExceptionDao<Monuments, Long> getMonumentsDao() {
        if (monumentsDao == null) {
            monumentsDao = getRuntimeExceptionDao(Monuments.class);
        }
        return monumentsDao;
    }

    public RuntimeExceptionDao<EventsCategory, Long> getEventsCategoryDao() {
        if (eventsCategoryDao == null) {
            eventsCategoryDao = getRuntimeExceptionDao(EventsCategory.class);
        }
        return eventsCategoryDao;
    }

    public RuntimeExceptionDao<MonumentsCategory, Long> getMonumentsCategoryDao() {
        if (monumentsCategoryDao == null) {
            monumentsCategoryDao = getRuntimeExceptionDao(MonumentsCategory.class);
        }
        return monumentsCategoryDao;
    }


}

