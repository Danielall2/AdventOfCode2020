package com.sparta.daniel.nine;

import java.util.ArrayList;

public class PuzzleNine {

    // So will start with an Array of Integers
    // Want to return an integer
    // Need to run through the list and check for through the sublist of 25 before

    private static final int SECTION = 25;
    private static long invalidNumber = 0;

    public static long findInvalidNumberInSequence (ArrayList<Long> arrayList) {

        boolean checker;

        //System.out.println(arrayList);

        int indexAfterSection;
        for (indexAfterSection = 0; indexAfterSection < arrayList.size() - SECTION; indexAfterSection++) {

            checker = false;

            // Now need to create a loop taking into consideration the numbers must be different

            long numberToCheck = arrayList.get(SECTION+ indexAfterSection);

            for (int index = 0; index < SECTION; index++) {
                for (int indexTwo = 0; indexTwo < SECTION; indexTwo++) {
                    if (!arrayList.get(index + indexAfterSection).equals(arrayList.get(indexTwo + indexAfterSection))) {
                        if ((arrayList.get(index+ indexAfterSection) + arrayList.get(indexTwo+ indexAfterSection)) == numberToCheck) {
                            checker = true;
                        }
                    }
                }
            }

            if (checker == false) {
                System.out.println("Invalid Number : " + numberToCheck);
                invalidNumber = numberToCheck;
                return numberToCheck;
            }

        }

        System.out.println("All data valid");

        return 0;

    }

    // Now need a method which determines the contiguous set of numbers
    // This was very confusing for me, so relied on help again from online
    // Method below is used to check each number, run through all data which borders it
    // Sums the data each time and checks whether it is equal to the invalidNumber


    public static ArrayList<Long> findContiguousSet(ArrayList<Long> arrayList) {

        ArrayList<Long> sumList = new ArrayList<Long>();

        boolean exit = false;

        for (int i = 0; i < arrayList.size(); i++) {

            for (int j=sumList.size()-1; j>=0; j--) {
                sumList.remove(j);
            }
            sumList.add(arrayList.get(i));

            for (int k=i+1; k<arrayList.size(); k++) {
                sumList.add(arrayList.get(k));
                if (sumArray(sumList)==invalidNumber) {
                    exit=true;
                    break;
                }
            }

            if (exit) {
                break;
            }
        }

        return sumList;

    }

    // Method also taken from online used to sum all numbers in the array
    private static long sumArray(ArrayList<Long> listOfNumbers) {
        long sum=0;
        for (int i=0; i<listOfNumbers.size(); i++) {
            sum+=listOfNumbers.get(i);
        }
        return sum;
    }

    // Now need another method to determine the biggest + smallest and sum

    public static long getNumberFromSet (ArrayList<Long> arrayList) {

        findInvalidNumberInSequence(arrayList);
        ArrayList<Long> sumList = findContiguousSet(arrayList);

        // Can't just use Math methods as using long not int

        long max = 0;
        long min = arrayList.get(arrayList.size()-1);

        for (long number : sumList) {
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }

        System.out.println("Max + Min = " + (max + min));

        return max + min;

    }



}
