package org.example;

import org.example.enums.*;

import java.io.IOException;

public class App {
    public static void main(String[] args) {

        ReadFile carList = new ReadFile();
        Car[] car = new Car[4];

        try {
            carList.ReadCarList();
        } catch (IOException e) {
            System.out.println("problem with file");
        }

        car[0] = new Car("KR21498", Company.MERCEDES, Color.BLACK, Size.PREMIUM, GearType.AUTOMATIC, Availability.AVAILABLE);
        car[1] = new Car(carList.getId(0), carList.getCompany(0), carList.getColor(0), carList.getSize(0), carList.getGearType(0), carList.getAvailability(0));
        car[2] = new Car(carList.getId(1), carList.getCompany(1), carList.getColor(1), carList.getSize(1), carList.getGearType(1), carList.getAvailability(1));
        car[3] = new Car(carList.getId(2), carList.getCompany(2), carList.getColor(2), carList.getSize(2), carList.getGearType(2), carList.getAvailability(2));


        System.out.println(car[0]);
        System.out.println(car[0].getColor());
        System.out.println(car[0].getColor().getHex());



        System.out.println(car[1]);
        System.out.println(car[2]);
        System.out.println(car[3]);


    }
}
