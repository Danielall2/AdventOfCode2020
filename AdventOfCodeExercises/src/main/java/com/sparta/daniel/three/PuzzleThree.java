package com.sparta.daniel.three;

import java.util.ArrayList;

public class PuzzleThree {

    public static int oneRouteNumberOfTrees(ArrayList<String> arrayList, int right, int down) {

        // Now need to do above method for each route
        // Probably simpler to rewrite above method with right and down as arguments

        int rightIndex = 0;
        char tree = '#';
        int numberOfTrees = 0;

        for (int index = 0; index < arrayList.size(); index = index + down) {
            String line = arrayList.get(index);

            line = line.repeat(100);

            if (line.charAt(rightIndex) == tree) {
                numberOfTrees++;
            }

            rightIndex = rightIndex + right;


        }

        System.out.println(numberOfTrees);

        return numberOfTrees;


    }

    public static int multipleRouteCalculation(ArrayList<String> arrayList) {
        int first = oneRouteNumberOfTrees(arrayList, 1, 1);
        int second = oneRouteNumberOfTrees(arrayList, 3, 1);
        int third = oneRouteNumberOfTrees(arrayList, 5, 1);
        int fourth = oneRouteNumberOfTrees(arrayList, 7, 1);
        int fifth = oneRouteNumberOfTrees(arrayList, 1, 2);

        System.out.println(first * second * third * fourth * fifth);

        return first * second * third * fourth * fifth;
    }
}
