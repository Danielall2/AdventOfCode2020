package com.sparta.daniel.six;

import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleSix {

    private static final String letterList = "abcdefghijklmnopqrstuvwxyz";

    public static int getNumberOfYes(ArrayList<String> arrayList) {

        int i = 0;
        ArrayList<Integer> arrayOfYes = new ArrayList<>();
        int numberOfYes;

        String letters = "";

        while (i < arrayList.size()) {

            while (!arrayList.get(i).equals("") && arrayList.get(i) != null) {
                letters = letters + (arrayList.get(i));
                i++;

                if (i >= arrayList.size()) {
                    break;
                }

            }

            i++;

            letters = letters + " ";
        }

        String[] separatedLetters = letters.split(" ");

        //System.out.println(Arrays.toString(separatedLetters));

        char[] characters = letterList.toCharArray();


        for (String differentEntries : separatedLetters) {
            numberOfYes = 0;
            for (int letterIndex = 0; letterIndex < 26; letterIndex++) {
                if ((differentEntries.indexOf(characters[letterIndex]) != -1)) {
                    numberOfYes++;
                }
            }
            //System.out.println(numberOfYes);
            arrayOfYes.add(numberOfYes);
        }

        int sum = 0;

        for (int number : arrayOfYes) {
            sum = sum + number;
        }

        System.out.println("Sum for Part One : " + sum);

        return sum;

    }

    // Need to include them as part of a team
    // Ideas, create a counter for number of team members using size of splitter

    public static int getNumberOfYesPartTwo (ArrayList<String> arrayList) {

        int i = 0;
        ArrayList<Integer> arrayOfYes = new ArrayList<>();
        int numberOfYes;
        char[] characters = letterList.toCharArray();
        int counter;

        String letters = "";

        while (i < arrayList.size()) {

            while (!arrayList.get(i).equals("") && arrayList.get(i) != null) {
                letters = letters + (arrayList.get(i));
                letters = letters + " ";
                i++;

                if (i >= arrayList.size()) {
                    break;
                }

            }

            i++;

            letters = letters + " ";
        }

        //System.out.println(letters);

        // Now have teams split by "  " and team members split by " "

        String[] teams = letters.split("  ");

        //System.out.println(Arrays.toString(teams));

        for (String teamAnswers : teams) {
            String[] teamMembers = teamAnswers.split(" ");
            numberOfYes = 0;

            // Need this to keep track of whether all members have answered the question
            int teamSize = teamMembers.length;

            for (int letterIndex = 0; letterIndex < 26; letterIndex++) {
                counter = 0;
                for (String answer : teamMembers) {
                    if ((answer.indexOf(characters[letterIndex]) != -1)) {
                        counter++;
                    }
                }
                if (counter == teamSize) {
                    numberOfYes++;
                }
            }

            arrayOfYes.add(numberOfYes);

        }

        int sum = 0;


        for (int number : arrayOfYes) {
            sum = sum + number;
        }

        System.out.println("Sum for Part Two : " + sum);

        return sum;

    }



}
