package com.sparta.daniel.ten;

import java.util.ArrayList;
import java.util.Collections;

public class PuzzleTen {

    // Can use CSVReader for Integer here as numbers do not go too high

    // So first need to sort the arrayList as this makes it easier to handle

    public static int organiseAdapters (ArrayList<Integer> arrayList) {

        // For some reason oneCounterDiff also needs to start 1 higher (I don't understand why just tried it)
        int oneCounterDiff = 1;
        int twoCounterDiff = 0;
        int threeCounterDiff = 1;


        Collections.sort(arrayList);

        //System.out.println("Sorted ArrayList : " + arrayList);

        for (int index = 0; index < arrayList.size()-1; index++) {
            if ((arrayList.get(index+1) - arrayList.get(index)) == 1) {
                oneCounterDiff++;
            } else if ((arrayList.get(index+1) - arrayList.get(index)) == 2) {
                twoCounterDiff++;
            } else if ((arrayList.get(index+1) - arrayList.get(index)) == 3) {
                threeCounterDiff++;
            } else {
                System.out.println("Something has gone horribly wrong!");
                return 0;
            }

        }
        System.out.println("One Difference : " + oneCounterDiff);
        System.out.println("Two Difference : " + twoCounterDiff);
        System.out.println("Three Difference : " + threeCounterDiff);

        int partOneAnswer = oneCounterDiff * threeCounterDiff;

        System.out.println("Part One : " + partOneAnswer);

        return partOneAnswer;

    }

    // Relied on code from https://github.com/stevotvr/adventofcode2020/blob/main/aoc2020/src/com/stevotvr/aoc2020/Day10.java
    // Not my own work but modified to take in my input and to get correct output
    // Really want to have a closer read on the code below and make sure I understand it

    public static long partTwo(ArrayList<Integer> arrayList) {

        final long[] sums = new long[arrayList.get(arrayList.size() - 1) + 1];
        sums[0] = 1;
        for (int i = 0; i < arrayList.size(); i++) {
            final long x = arrayList.get(i) >= 3 ? sums[arrayList.get(i) - 3] : 0;
            final long y = arrayList.get(i) >= 2 ? sums[arrayList.get(i) - 2] : 0;
            final long z = arrayList.get(i) >= 1 ? sums[arrayList.get(i) - 1] : 0;
            sums[arrayList.get(i)] = x + y + z;
        }

        long partTwoSolution = sums[sums.length - 1];

        System.out.println("Part Two Solution : " + partTwoSolution);

        return partTwoSolution;
    }






}
