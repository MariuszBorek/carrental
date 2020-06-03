package org.example;

import org.example.enums.*;

import java.io.*;

public class ReadWriteFile {

    private String[] id = new String[100];
    private Company[] company = new Company[100];
    private Color[] color = new Color[100];
    private Size[] size = new Size[100];
    private GearType[] gearType = new GearType[100];
    private Availability[] availability = new Availability[100];
    private int numberOfAddedCars;

    Car[] carWrote = new Car[100];

    public String getId(int i) {
        return id[i];
    }

    public Company getCompany(int i) {
        return company[i];
    }

    public Color getColor(int i) {
        return color[i];
    }

    public Size getSize(int i) {
        return size[i];
    }

    public GearType getGearType(int i) {
        return gearType[i];
    }

    public Availability getAvailability(int i) {
        return availability[i];
    }

    public void ReadCarList() throws IOException { // here you have array from App class
        String path = "src/main/java/org/example/carlist.txt";
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int i = 0;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(",");
            id[i] = split[0];
            company[i] = Company.valueOf(split[1]);
            color[i] = Color.valueOf(split[2]);
            size[i] = Size.valueOf(split[3]);
            gearType[i] = GearType.valueOf(split[4]);
            availability[i] = Availability.valueOf(split[5]);
            carWrote[i] = new Car(id[i], company[i], color[i], size[i], gearType[i], availability[i]);
            i++;
        }
        this.numberOfAddedCars = i;
        bufferedReader.close();
    }

    public void writeCarList(String text) throws IOException {
        String path = "src/main/java/org/example/listofcreatedcars.txt";
        FileWriter fileWriter = new FileWriter(path, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(text);
        bufferedWriter.close();
    }

    public int getNumberOfAddedCars() {
        return numberOfAddedCars;
    }

    public Car getCarWrote(int i) {
        return carWrote[i];
    }
}
