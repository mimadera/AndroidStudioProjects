package com.example.michal.breslau;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;

import com.example.michal.breslau.Database.EventCategoryRepository;
import com.example.michal.breslau.Database.EventRepository;
import com.example.michal.breslau.DatabaseTables.Event;
import com.example.michal.breslau.DatabaseTables.EventsCategory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LoaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);
        readJsons();

    }

    private void readJsons() {
        InputStream eventInputStream = null;
        try {
            eventInputStream = getAssets().open("event.json");
            addEventsToDatabase(readEventJsonStream(eventInputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        String category = null;
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
}