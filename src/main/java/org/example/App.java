package org.example;

import org.example.enums.*;

import java.io.IOException;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ReadWriteFile carList = new ReadWriteFile();
        Car[] car = new Car[100];
        int j = 0;
        String action = "";


        controller(in, carList, car, j);

//        car[0] = new Car("KR21498", Company.MERCEDES, Color.BLACK, Size.PREMIUM, GearType.AUTOMATIC, Availability.AVAILABLE);
//        car[1] = new Car(carList.getId(0), carList.getCompany(0), carList.getColor(0), carList.getSize(0), carList.getGearType(0), carList.getAvailability(0));
//        car[2] = new Car(carList.getId(1), carList.getCompany(1), carList.getColor(1), carList.getSize(1), carList.getGearType(1), carList.getAvailability(1));
//        car[3] = new Car(carList.getId(2), carList.getCompany(2), carList.getColor(2), carList.getSize(2), carList.getGearType(2), carList.getAvailability(2));
//
//        System.out.println(car[1]);
//        System.out.println(car[2]);
//        System.out.println(car[3]);
    }

    private static void controller(Scanner in, ReadWriteFile carList, Car[] car, int j) {
        String action;
        while (true) {

            System.out.println("____________________________________MENU_____________________________________\n" +
                    "|\t\t\ta - add car | c - change availability | l - car list\t\t\t|\n" +
                    "| g - get car back | s - save cars to file | w - write a car list form file |\n" +
                    "|___________________________________________________________________________|\n" +
                    "input your choice:");

            action = in.nextLine();

            switch(action) {
                case "a": {
                    System.out.println("add car nr: " + j + " to car list:");
                    System.out.println("input car registration:");
                    String id = in.nextLine();
                    System.out.println("input car company | MERCEDES | BMW | AUDI | MAZDA | LEXUS |");
                    Company company = Company.valueOf(in.nextLine());
                    System.out.println("input car color | RED | YELLOW | ORANGE | BLUE | PURPLE | GRAY | SILVER | WHITE | BLACK |");
                    Color color = Color.valueOf(in.nextLine());
                    System.out.println("input car type | SMALL | MEDIUM | LARGE | PREMIUM | SUV | VAN |");
                    Size size = Size.valueOf(in.nextLine());
                    System.out.println("input car gear Type | AUTOMATIC | MANUAL |");
                    GearType gearType = GearType.valueOf(in.nextLine());
                    System.out.println("input car availability | AVAILABLE | UNAVAILABLE |");
                    Availability availability = Availability.valueOf(in.nextLine());
                    car[j] = new Car(id, company, color, size, gearType, availability);
                    j++;
                    controller(in, carList, car, j);
                    return;
                }
                case "c": {
                    System.out.println("change car availability, input number(index) of car");

                    System.out.println("the car has been rented");
                    controller(in, carList, car, j);
                    return;
                }
                case "l": {
                    System.out.println("List of cars");
                    for (int i = 0; i < j; i++) {
                        System.out.println(car[i]);
                    }
                    controller(in, carList, car, j);
                    return;
                }
                case "g": {
                    System.out.println("get car back");
                    controller(in, carList, car, j);
                    return;
                }
                case "s": {
                    System.out.println("car was added to file: \"listofcreatedcars.txt\"");
                    for (int i = 0; i < j; i++) {
                        try {
                            carList.writeCarList(car[i].toString() + "\n");
                        } catch (IOException e) {
                            System.out.println("problem with file");
                        }
                    }
                    controller(in, carList, car, j);
                    return;
                }
                case "w": {
                    System.out.println("write a car list form file");
                    try {
                        carList.ReadCarList();
                    } catch (IOException e) {
                        System.out.println("problem with file");
                    }
                    controller(in, carList, car, j);
                    return;
                }
                default: {
                    System.out.println("wrong character");
                    controller(in, carList, car, j);
                    return;
                }
            }
        }
    }
}
