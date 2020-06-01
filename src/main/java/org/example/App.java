package org.example;

import org.example.enums.*;

import java.io.IOException;

public class App {
    public static void main(String[] args) {

        ReadCarsFromFile carFromList = new ReadCarsFromFile();
        WriteCarsToFile carsToFile = new WriteCarsToFile();
        Car[] car = new Car[4];

        try {
            carFromList.ReadCarList();
        } catch (IOException e) {
            System.out.println("problem with file");
        }

        car[0] = new Car("KR21498", Company.MERCEDES, Color.BLACK, Size.PREMIUM, GearType.AUTOMATIC, Availability.AVAILABLE);
        car[1] = new Car(carFromList.getId(0), carFromList.getCompany(0), carFromList.getColor(0), carFromList.getSize(0), carFromList.getGearType(0), carFromList.getAvailability(0));
        car[2] = new Car(carFromList.getId(1), carFromList.getCompany(1), carFromList.getColor(1), carFromList.getSize(1), carFromList.getGearType(1), carFromList.getAvailability(1));
        car[3] = new Car(carFromList.getId(2), carFromList.getCompany(2), carFromList.getColor(2), carFromList.getSize(2), carFromList.getGearType(2), carFromList.getAvailability(2));


        System.out.println(car[1]);
        System.out.println(car[2]);
        System.out.println(car[3]);

        for (int i = 0; i < 4; i++) {
            try {

                carsToFile.writeCarList(car[i].toString() + "\n");

            } catch (IOException e) {
                System.out.println("problem with file");
            }
        }

    }
}
