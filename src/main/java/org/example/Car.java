package org.example;

import org.example.enums.*;

public class Car {

    private String id;
    private Company company;
    private Color color;
    private Size size;
    private GearType gearType;
    private Availability availability;


    public Car(String id, Company company, Color color, Size size, GearType gearType, Availability availability) {
        this.id = id;
        this.company = company;
        this.color = color;
        this.size = size;
        this.gearType = gearType;
        this.availability = availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public String getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public GearType getGearType() {
        return gearType;
    }

    public Availability getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return id + "," + company + "," + color + "," + size + "," + gearType + "," + availability;
    }
}
