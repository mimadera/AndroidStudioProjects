package com.example.michal.breslau;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.JsonReader;
import android.view.Window;

import com.example.michal.breslau.Database.EventCategoryRepository;
import com.example.michal.breslau.Database.EventRepository;
import com.example.michal.breslau.Database.FoodCategoryRepository;
import com.example.michal.breslau.Database.FoodRepository;
import com.example.michal.breslau.Database.MonumentsCategoryRepository;
import com.example.michal.breslau.Database.MonumentsRepository;
import com.example.michal.breslau.DatabaseTables.Event;
import com.example.michal.breslau.DatabaseTables.EventsCategory;
import com.example.michal.breslau.DatabaseTables.Food;
import com.example.michal.breslau.DatabaseTables.FoodCategory;
import com.example.michal.breslau.DatabaseTables.Monuments;
import com.example.michal.breslau.DatabaseTables.MonumentsCategory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SplashScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        readJsons();
/*
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() { */
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
   /*         }
        }, 1500); */
    }

    private void readJsons() {
        InputStream eventInputStream = null;
        InputStream foodInputStream = null;
        InputStream monumentInputStream = null;
        try {
            eventInputStream = getAssets().open("event.json");
            addEventsToDatabase(readEventJsonStream(eventInputStream));

            foodInputStream = getAssets().open("food.json");
            addFoodToDatabase(readFoodJsonStream(foodInputStream));

            monumentInputStream = getAssets().open("monuments.json");
            addMonumentsToDatabase(readMonumentJsonStream(monumentInputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
    ***********************************************************************************************
    EVENTS
    ***********************************************************************************************
     */
    private boolean addEventsToDatabase(List<Event> events){
        EventRepository.deleteAllRecords(this);
        for(Event e: events){
            EventRepository.addEvent(this, e);
        }
        return true;
    }

    public List<Event> readEventJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readEventsArray(reader);
        } finally {
            reader.close();
        }
    }

    public List<Event> readEventsArray(JsonReader reader) throws IOException {
        List<Event> events = new ArrayList<>();
        reader.beginArray();
        while (reader.hasNext()) {
            events.add(readEvent(reader));
        }
        reader.endArray();
        return events;
    }

    public Event readEvent(JsonReader reader) throws IOException {
        double longitude = 0.0;
        double latitude = 0.0;
        String eventsName = "";
        String category = "";
        String description = "";
        String photo = "";

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("longitude")) {
                longitude = reader.nextDouble();
            } else if (name.equals("latitude")) {
                latitude = reader.nextDouble();
            } else if (name.equals("eventsName")) {
                eventsName = reader.nextString();
            } else if (name.equals("category")) {
                category = reader.nextString();
            } else if (name.equals("description")) {
                description = reader.nextString();
            } else if (name.equals("photo")) {
                photo = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Event(longitude, latitude, eventsName, getEventCategoryFromName(category),description, photo);
    }

    private EventsCategory getEventCategoryFromName(String categoryName){
        return EventCategoryRepository.findByName(this, categoryName);
    }
    /*
***********************************************************************************************
EVENTS
***********************************************************************************************
 */
    private boolean addFoodToDatabase(List<Food> foods){
        FoodRepository.deleteAllRecords(this);
        for(Food e: foods){
            FoodRepository.addfood(this, e);
        }
        return true;
    }

    public List<Food> readFoodJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readFoodsArray(reader);
        } finally {
            reader.close();
        }
    }

    public List<Food> readFoodsArray(JsonReader reader) throws IOException {
        List<Food> foods = new ArrayList<>();
        reader.beginArray();
        while (reader.hasNext()) {
            foods.add(readFood(reader));
        }
        reader.endArray();
        return foods;
    }

    public Food readFood (JsonReader reader) throws IOException {
        double longitude = 0.0;
        double latitude = 0.0;
        String foodsName = "";
        String category = "";
        String description = "";
        String photo = "";

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("longitude")) {
                longitude = reader.nextDouble();
            } else if (name.equals("latitude")) {
                latitude = reader.nextDouble();
            } else if (name.equals("eventsName")) {
                foodsName = reader.nextString();
            } else if (name.equals("category")) {
                category = reader.nextString();
            } else if (name.equals("description")) {
                description = reader.nextString();
            } else if (name.equals("photo")) {
                photo = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Food(longitude, latitude, foodsName, getFoodCategoryFromName(category),description, photo);
    }

    private FoodCategory getFoodCategoryFromName(String categoryName){
        return FoodCategoryRepository.findByName(this, categoryName);
    }
    /*
***********************************************************************************************
MONUMENTS
***********************************************************************************************
        */
    private boolean addMonumentsToDatabase(List<Monuments> monuments){
        MonumentsRepository.deleteAllRecords(this);
        for(Monuments e: monuments){
            MonumentsRepository.addMonuments(this, e);
        }
        return true;
    }

    public List<Monuments> readMonumentJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readMonumentsArray(reader);
        } finally {
            reader.close();
        }
    }

    public List<Monuments> readMonumentsArray(JsonReader reader) throws IOException {
        List<Monuments> monuments = new ArrayList<>();
        reader.beginArray();
        while (reader.hasNext()) {
            monuments.add(readMonument(reader));
        }
        reader.endArray();
        return monuments;
    }

    public Monuments readMonument(JsonReader reader) throws IOException {
        double longitude = 0.0;
        double latitude = 0.0;
        String monumentsName = "";
        String category = "";
        String description = "";
        String photo = "";

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("longitude")) {
                longitude = reader.nextDouble();
            } else if (name.equals("latitude")) {
                latitude = reader.nextDouble();
            } else if (name.equals("eventsName")) {
                monumentsName = reader.nextString();
            } else if (name.equals("category")) {
                category = reader.nextString();
            } else if (name.equals("description")) {
                description = reader.nextString();
            } else if (name.equals("photo")) {
                photo = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Monuments(longitude, latitude, monumentsName, getMonumentCategoryFromName(category),description, photo);
    }

    private MonumentsCategory getMonumentCategoryFromName(String categoryName){
        return MonumentsCategoryRepository.findByName(this, categoryName);
    }
}