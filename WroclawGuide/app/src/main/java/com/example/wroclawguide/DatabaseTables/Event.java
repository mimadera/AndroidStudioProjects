package com.example.wroclawguide.DatabaseTables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Event")
public class Event {


    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false) // this position cannot be null
    private double longitude;

    @DatabaseField(canBeNull = false)
    private double latitude;

    @DatabaseField(canBeNull = false)
    private String name;

    @DatabaseField(foreign = true, canBeNull = false)
    private EventsCategory category;

    @DatabaseField(canBeNull = false)
    private String description;

    @DatabaseField
    private String photo;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventsCategory getCategory() {
        return category;
    }

    public void setCategory(EventsCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public Event(){
    }

    public Event(double longitude, double latitude, String name, EventsCategory category, String description, String photo) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.category = category;
        this.description = description;
        this.photo = photo;
    }
}