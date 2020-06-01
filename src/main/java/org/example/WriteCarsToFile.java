package org.example;

import java.io.*;

public class WriteCarsToFile {

    public void writeCarList(String text) throws IOException {
        String path = "src/main/java/org/example/newlist.txt";
        FileWriter fileWriter = new FileWriter(path, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(text);
        bufferedWriter.close();
    }




}
