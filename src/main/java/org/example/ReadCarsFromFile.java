package org.example;

import org.example.enums.*;

import java.io.*;

public class ReadCarsFromFile {

    private String[] id = new String[10];
    private Company[] company = new Company[10];
    private Color[] color = new Color[10];
    private Size[] size = new Size[10];
    private GearType[] gearType = new GearType[10];
    private Availability[] availability = new Availability[10];

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

    public void ReadCarList() throws IOException {
        String path = "src/main/java/org/example/carlist.txt";
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int i = 0;
        while((line = bufferedReader.readLine())  != null) {
            String[] split = line.split(",");
            id[i] = split[0];
            company[i] = Company.valueOf(split[1]);
            color[i] = Color.valueOf(split[2]);
            size[i] = Size.valueOf(split[3]);
            gearType[i] = GearType.valueOf(split[4]);
            availability[i] = Availability.valueOf(split[5]);
            i++;
        }
        bufferedReader.close();
    }
}
