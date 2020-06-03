package org.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ReadWriteFile carList = new ReadWriteFile();
        Car[] car = new Car[100];
        int j = 0;

        Controller.mainController(in, carList, car, j);
    }
}
