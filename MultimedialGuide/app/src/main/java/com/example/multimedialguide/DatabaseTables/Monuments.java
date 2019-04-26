package com.example.multimedialguide.DatabaseTables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


/**
 * Created by Michal on 30.09.2017.
 */

@DatabaseTable(tableName = "Monuments")
public class Monuments {


    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false) // this position cannot be nullem
    private double longitude;

    @DatabaseField(canBeNull = false)
    private double latitude;

    @DatabaseField(canBeNull = false)
    private String name;

    @DatabaseField(foreign = true, canBeNull = false)
    private MonumentsCategory category;

    @DatabaseField(canBeNull = false)
    private String description;

    @DatabaseField
    private String photo;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MonumentsCategory getCategory() {
        return category;
    }

    public void setCategory(MonumentsCategory category) {
        this.category = category;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
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

    public Monuments(){
    }

    public Monuments(double longitude, double latitude, String name, MonumentsCategory category, String description, String photo) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.category = category;
        this.description = description;
        this.photo = photo;
    }
}
