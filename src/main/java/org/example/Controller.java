package org.example;

import org.example.enums.*;

import java.io.IOException;
import java.util.Scanner;

public class Controller {

    static void mainController(Scanner in, ReadWriteFile carList, Car[] car, int j) {
        String action;
        while (true) {

            action = displayMenu(in);

            switch (action) {
                case "a": {
                    addCar(in, carList, car, j);
                    return;
                }
                case "c": {
                    changeAvailabilityManually(in, carList, car, j);
                    return;
                }
                case "l": {
                    showCarList(in, carList, car, j);
                    return;
                }
                case "r": {
                    rentCar(in, carList, car, j);
                    return;
                }
                case "g": {
                    getBackCar(in, carList, car, j);
                    return;
                }
                case "s": {
                    saveCarLIstToFile(in, carList, car, j);
                    return;
                }
                case "d": {
                    addCarsFromFileToList(in, carList, car, j);
                    return;
                }
                case "x": {
                    System.out.println("good bye!");
                    return;
                }
                default: {
                    System.out.println("wrong character");
                    mainController(in, carList, car, j);
                    return;
                }
            }
        }
    }

    private static void addCarsFromFileToList(Scanner in, ReadWriteFile carList, Car[] car, int j) {
        System.out.println("car list was updated from file: \"carlist.txt\"");
        try {
            carList.ReadCarList();
        } catch (IOException e) {
            System.out.println("problem with file");
        }
        for (int i = 0; i < carList.getNumberOfAddedCars(); i++) {
            car[j] = carList.getCarWrote(i);
            j++;
        }
        mainController(in, carList, car, j);
    }

    private static void saveCarLIstToFile(Scanner in, ReadWriteFile carList, Car[] car, int j) {
        System.out.println("cars was added to file: \"listofcreatedcars.txt\"");
        for (int i = 0; i < j; i++) {
            try {
                carList.writeCarList(car[i].toString() + "\n");
            } catch (IOException e) {
                System.out.println("problem with file");
            }
        }
        mainController(in, carList, car, j);
    }

    private static void getBackCar(Scanner in, ReadWriteFile carList, Car[] car, int j) {
        System.out.println("chosen number(index) of a car, which you want to get back:");
        int chosenIndex = in.nextInt();
        if (car[chosenIndex].getAvailability().equals(Availability.AVAILABLE)) {
            System.out.println("you can not get back available car, pleas try again");
            getBackCar(in, carList, car, j);
        } else {
            car[chosenIndex].setAvailability(Availability.AVAILABLE);
            System.out.println("thank you! the car has been backed");
        }
        in.nextLine();
        mainController(in, carList, car, j);
    }

    private static void rentCar(Scanner in, ReadWriteFile carList, Car[] car, int j) {
        System.out.println("chosen number(index) of a car, which you want to rent:");
        int chosenIndex = in.nextInt();
        if (car[chosenIndex].getAvailability().equals(Availability.UNAVAILABLE)) {
            System.out.println("we are sorry, this car is not available. Please, chose other car");
            rentCar(in, carList, car, j);
        } else {
            car[chosenIndex].setAvailability(Availability.UNAVAILABLE);
            System.out.println("enjoy you ride! the car has been rented");
        }
        in.nextLine();
        mainController(in, carList, car, j);
    }

    private static void showCarList(Scanner in, ReadWriteFile carList, Car[] car, int j) {
        System.out.println("List of cars");
        for (int i = 0; i < j; i++) {
            System.out.println("(car index: " + i + ") " + car[i]);
        }
        mainController(in, carList, car, j);
    }

    private static void changeAvailabilityManually(Scanner in, ReadWriteFile carList, Car[] car, int j) {
        System.out.println("change car availability, input number(index) of car\n" +
                "chosen number(index) of a car:");
        int chosenIndex = in.nextInt();
        System.out.println();
        System.out.println("input car availability | AVAILABLE | UNAVAILABLE |");
        in.nextLine();
        String setAvailability = in.nextLine().toUpperCase();
        car[chosenIndex].setAvailability(Availability.valueOf(setAvailability));
        System.out.println("availability of the car was changed");
        mainController(in, carList, car, j);
    }

    private static void addCar(Scanner in, ReadWriteFile carList, Car[] car, int j) {
        System.out.println("add car nr: " + j + " to car list\n" +
                "input car registration:");
        String id = in.nextLine().toUpperCase();
        System.out.println("input car company | MERCEDES | BMW | AUDI | MAZDA | LEXUS |");
        Company company = Company.valueOf(in.nextLine().toUpperCase());
        System.out.println("input car color | RED | YELLOW | ORANGE | BLUE | PURPLE | GRAY | SILVER | WHITE | BLACK |");
        Color color = Color.valueOf(in.nextLine().toUpperCase());
        System.out.println("input car type | SMALL | MEDIUM | LARGE | PREMIUM | SUV | VAN |");
        Size size = Size.valueOf(in.nextLine().toUpperCase());
        System.out.println("input car gear Type | AUTOMATIC | MANUAL |");
        GearType gearType = GearType.valueOf(in.nextLine().toUpperCase());
        System.out.println("input car availability | AVAILABLE | UNAVAILABLE |");
        Availability availability = Availability.valueOf(in.nextLine().toUpperCase());
        car[j] = new Car(id, company, color, size, gearType, availability);
        j++;
        mainController(in, carList, car, j);
    }

    private static String displayMenu(Scanner in) {
        String action;
        System.out.println("__________________________MENU_FOR_CAR_RENTAL_OWNER__________________________\n" +
                "|\t\t\ta - add car | c - change availability | l - car list\t\t\t|\n" +
                "|\t\t    s - save cars to file | d - read a car list form file   \t\t|\n" +
                "|___________________________________________________________________________|\n" +
                "_________________________MENU_FOR_CAR_RENTAL_CLIENT__________________________\n" +
                "|\t l - show car list | r - rent a car | g - get car back  | x - close \t|\n" +
                "|___________________________________________________________________________|\n" +
                "input your choice:");
        action = in.nextLine();
        return action;
    }
}
