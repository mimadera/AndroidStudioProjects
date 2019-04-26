package com.example.wroclawguide.DatabaseTables;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Michal on 01.10.2017.
 */

public class EventsCategory {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    EventsCategory(){

    }

    public EventsCategory(String name) {
        this.name = name;
    }
}
