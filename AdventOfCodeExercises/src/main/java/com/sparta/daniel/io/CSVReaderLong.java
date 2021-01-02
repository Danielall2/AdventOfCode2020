package com.sparta.daniel.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReaderLong {

    public static ArrayList<Long> readAdventData(String path) {

        ArrayList<Long> adventData = new ArrayList<>();

        try {

            // Have to change from bufferedReader as Scanner has ways of checking for long rather than string

//            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
//            String line;

            File fileObject = new File(path);
            Scanner sc = new Scanner(fileObject);

            while ((sc.hasNextLong())) {
                adventData.add(sc.nextLong());
            }

            return adventData;
        } catch (IOException e) {
            System.out.println("IO Exception Found");
        }

        return null;
    }
}
