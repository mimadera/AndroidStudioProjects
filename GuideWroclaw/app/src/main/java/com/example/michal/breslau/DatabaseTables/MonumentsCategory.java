package com.example.michal.breslau.DatabaseTables;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Michal on 01.10.2017.
 */

public class MonumentsCategory {

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

    public MonumentsCategory(){

    }

    public MonumentsCategory(String name) {
        this.name = name;
    }
}
