package com.sparta.daniel.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReaderInt {

    public static ArrayList<Integer> readAdventData(String path) {

        ArrayList<Integer> adventData = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                adventData.add(Integer.valueOf(line));
            }

            return adventData;
        } catch (IOException e) {
            System.out.println("IO Exception Found while Reading AdventDataOne.csv");
        }

        return null;
    }

}
