package com.sparta.daniel.two;

import java.util.ArrayList;

public class PuzzleTwo {

    // The CSVReader I have created simply returns each entry as a string
    // Need to create methods which will split first by : and a space
    // Then for left side string need to again separate by space, then - to get letter and numbers.

    public static int numberOfValidPasswordsOne(ArrayList<String> array) {

        int validPasswords = 0;
        int index;

        for (String line : array) {
            String[] separated = line.split(":");

            String leftSide = separated[0];
            String rightSide = separated[1].trim();

            String[] separatedLeft = leftSide.split(" ");

            String numbers = separatedLeft[0];
            String character = separatedLeft[1];

            String[] minMax = numbers.split("-");

            int min = Integer.valueOf(minMax[0]);
            int max = Integer.valueOf(minMax[1]);

//            System.out.println(rightSide.toString());
//            System.out.println(character);
//            System.out.println(min);
//            System.out.println(max);

            int lastIndex = -1;
            int count = 0;


            while ((index = rightSide.indexOf(character, lastIndex + 1)) != -1) {
                lastIndex = index;
                count = count + 1;
            }

            if (count >= min && count <= max) {
                validPasswords++;
            }






        }

        System.out.println(validPasswords);

        return validPasswords;

    }

    public static int numberOfValidPasswordsTwo(ArrayList<String> arrayList) {

        int validPasswords = 0;
        int index;

        for (String line : arrayList) {
            String[] separated = line.split(":");

            String leftSide = separated[0];
            String rightSide = separated[1].trim();

            String[] separatedLeft = leftSide.split(" ");

            String numbers = separatedLeft[0];
            String character = separatedLeft[1];

            String[] minMax = numbers.split("-");

            int leftIndex = Integer.valueOf(minMax[0]);
            int rightIndex = Integer.valueOf(minMax[1]);

            // Careful here as indexes are different because advent doesn't include 0

            boolean equals = character.equals(rightSide.substring(leftIndex - 1, leftIndex));
            boolean equals2 = character.equals(rightSide.substring(rightIndex - 1, rightIndex));

            if (equals) {
                if (equals2) {
                } else {
                    validPasswords++;
                }
            } else if (equals2) {
                if (equals) {
                } else {
                    validPasswords++;
                }
            }
        }

        System.out.println(validPasswords);

        return validPasswords;
    }

}
