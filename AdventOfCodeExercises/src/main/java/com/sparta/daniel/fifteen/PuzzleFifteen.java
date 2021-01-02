package com.sparta.daniel.fifteen;

import java.util.ArrayList;
import java.util.HashMap;

public class PuzzleFifteen {

    // Don't need this as an array but keeping it for ease of use

    public static int getPartOneAnswer(ArrayList<String> arrayList) {

        // Think HashSet would be useful to store spoken numbers as duplicates are not allowed (except 0 but that should be fine)
        // On second thought, a HashMap would be useful to determine if it is the first time the number has been said

        HashMap<Integer, String> spokenNumbers = new HashMap<>();

        // Need an ArrayList to keep track of order of what order numbers are spoken

        ArrayList<Integer> trackOrder = new ArrayList<>();

        // Need to split the numbers

        String[] split = arrayList.get(0).split(",");

        int parsedNumber;
        int lastNumber;
        int difference = 0;

        for (String number : split) {

            parsedNumber = Integer.parseInt(number);

            spokenNumbers.put(parsedNumber, "FIRST");
            trackOrder.add(Integer.parseInt(number));
        }

//        System.out.println(trackOrder);

        for (int i = split.length; i < 2020; i++) {

//            System.out.println(i);

            lastNumber = trackOrder.get(i - 1);

            if (spokenNumbers.containsKey(lastNumber)) {
                if (spokenNumbers.get(lastNumber).equals("FIRST")) {

                    trackOrder.add(0);

                    spokenNumbers.replace(0, "NOT FIRST");



                } else {

                    for (int j = i - 2; j >= 0; j--) {
                        if (trackOrder.get(j) == lastNumber) {
                            difference = i - j - 1;
                            break;
                        }
                    }

                    trackOrder.add(difference);

                    if (spokenNumbers.containsKey(difference)) {
                        spokenNumbers.replace(difference, "NOT FIRST");
                    } else {
                        spokenNumbers.put(difference, "FIRST");
                    }

                }

            } else {

                trackOrder.add(0);

                spokenNumbers.put(lastNumber, "FIRST");

            }


        }
//        System.out.println(trackOrder.size());
//        System.out.println(trackOrder);

        int veryLastNumber = trackOrder.get(trackOrder.size() - 1);

        System.out.println("Puzzle Fifteen Part One : " + veryLastNumber);

        return veryLastNumber;


    }


    public static int getPartTwoAnswer(ArrayList<String> arrayList) {

        // Think HashSet would be useful to store spoken numbers as duplicates are not allowed (except 0 but that should be fine)
        // On second thought, a HashMap would be useful to determine if it is the first time the number has been said

        HashMap<Integer, String> spokenNumbers = new HashMap<>();

        // Need an ArrayList to keep track of order of what order numbers are spoken

        ArrayList<Integer> trackOrder = new ArrayList<>();

        // Need to split the numbers

        String[] split = arrayList.get(0).split(",");

        int parsedNumber;
        int lastNumber;
        int difference = 0;

        for (String number : split) {

            parsedNumber = Integer.parseInt(number);

            spokenNumbers.put(parsedNumber, "FIRST");
            trackOrder.add(Integer.parseInt(number));
        }

//        System.out.println(trackOrder);

        for (int i = split.length; i < 30000000; i++) {

            lastNumber = trackOrder.get(i - 1);

            if (spokenNumbers.containsKey(lastNumber)) {
                if (spokenNumbers.get(lastNumber).equals("FIRST")) {

                    trackOrder.add(0);

                    spokenNumbers.replace(0, "NOT FIRST");



                } else {

                    for (int j = i - 2; j >= 0; j--) {
                        if (trackOrder.get(j) == lastNumber) {
                            difference = i - j - 1;
                            break;
                        }
                    }

                    trackOrder.add(difference);

                    if (spokenNumbers.containsKey(difference)) {
                        spokenNumbers.replace(difference, "NOT FIRST");
                    } else {
                        spokenNumbers.put(difference, "FIRST");
                    }

                }

            } else {

                trackOrder.add(0);

                spokenNumbers.put(lastNumber, "FIRST");

            }


        }
//        System.out.println(trackOrder.size());
//        System.out.println(trackOrder);

        int veryLastNumber = trackOrder.get(trackOrder.size() - 1);

        System.out.println("Puzzle Fifteen Part One : " + veryLastNumber);

        return veryLastNumber;


    }



}
