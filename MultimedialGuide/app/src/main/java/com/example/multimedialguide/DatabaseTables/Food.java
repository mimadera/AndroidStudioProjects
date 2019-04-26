package com.example.multimedialguide.DatabaseTables;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Foods")
public class Food {


    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false) // this position cannot be nullem
    private double longitude;

    @DatabaseField(canBeNull = false)
    private double latitude;

    @DatabaseField(canBeNull = false)
    private String name;

    @DatabaseField(canBeNull = false)
    private String description;

    @DatabaseField(foreign = true, canBeNull = false)
    private FoodCategory category;

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

    public FoodCategory getCategory() {
        return category;
    }

    public void setCategory(FoodCategory category) {
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

    public Food(){
    }

    public Food(double longitude, double latitude, String name, FoodCategory category, String description, String photo) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.category = category;
        this.description = description;
        this.photo = photo;
    }
}
