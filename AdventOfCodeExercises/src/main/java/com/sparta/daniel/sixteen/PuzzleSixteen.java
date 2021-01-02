package com.sparta.daniel.sixteen;

import java.util.ArrayList;
import java.util.HashMap;

public class PuzzleSixteen {

    public static int getPartOne(ArrayList<String> arrayList) {

        ArrayList<String> fields = new ArrayList<>();
        ArrayList<Integer> minNumbers = new ArrayList<>();
        ArrayList<Integer> maxNumbers = new ArrayList<>();
        ArrayList<Integer> invalidValues = new ArrayList<>();

        int index = 0;
        int counter;
        int value;

        // Can't just do "" need to copy from CSV file and this is what I get (new line)
        while (!arrayList.get(index).equals("")) {

            // Look at rules
            String[] split = arrayList.get(index).split(": ");

            fields.add(split[0]);

            String[] splitRanges = split[1].split(" or ");

            String[] splitNumbersOne = splitRanges[0].split("-");
            String[] splitNumbersTwo = splitRanges[1].split("-");

            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    minNumbers.add(Integer.parseInt(splitNumbersOne[i]));
                    minNumbers.add(Integer.parseInt(splitNumbersTwo[i]));
                } else {
                    maxNumbers.add(Integer.parseInt(splitNumbersOne[i]));
                    maxNumbers.add(Integer.parseInt(splitNumbersTwo[i]));
                }
            }

            index++;

        }

        index++;

        while (!arrayList.get(index).equals("") || !arrayList.get(index).equals("\n") || arrayList.get(index) != null) {
            // Look at own ticket
            if (arrayList.get(index).equals("")) {
                break;
            }
            index++;
        }

        index += 2;

        while (index < arrayList.size()) {
            // Look at nearby tickets
            String[] splitNearbyTickets = arrayList.get(index).split(",");

            for (String ticketNumbers : splitNearbyTickets) {

                counter = 0;

                value = Integer.parseInt(ticketNumbers);

                for (int j = 0; j < minNumbers.size(); j += 2) {
                    if (value >= minNumbers.get(j) && value <= maxNumbers.get(j)) {

                    } else if (value >= minNumbers.get(j + 1) && value <= maxNumbers.get(j + 1)) {

                    } else {
                        counter++;
                    }
                }

                if (counter == fields.size()) {
                    invalidValues.add(value);
                }
            }

            if (arrayList.get(index).equals("")) {
                break;
            }

            index++;

        }

        int sum = 0;

        for (int i = 0; i < invalidValues.size(); i++) {
            sum += invalidValues.get(i);
        }

        System.out.println("Puzzle Sixteen Part One : " + sum);

        return sum;
    }


    public static int getPartTwoAnswer(ArrayList<String> arrayList) {

        // First need to remove all invalid values from arrayList so need part 1

        ArrayList<String> fields = new ArrayList<>();
        ArrayList<Integer> minNumbers = new ArrayList<>();
        ArrayList<Integer> maxNumbers = new ArrayList<>();
        ArrayList<Integer> invalidValues = new ArrayList<>();
        ArrayList<String> validTickets = new ArrayList<>();

        int index = 0;
        int counter;
        int value;
        int validCounter;

        // Can't just do "" need to copy from CSV file and this is what I get (new line)
        while (!arrayList.get(index).equals("")) {

            // Look at rules
            String[] split = arrayList.get(index).split(": ");

            fields.add(split[0]);

            String[] splitRanges = split[1].split(" or ");

            String[] splitNumbersOne = splitRanges[0].split("-");
            String[] splitNumbersTwo = splitRanges[1].split("-");

            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    minNumbers.add(Integer.parseInt(splitNumbersOne[i]));
                    minNumbers.add(Integer.parseInt(splitNumbersTwo[i]));
                } else {
                    maxNumbers.add(Integer.parseInt(splitNumbersOne[i]));
                    maxNumbers.add(Integer.parseInt(splitNumbersTwo[i]));
                }
            }

            index++;

        }

        index++;

        while (!arrayList.get(index).equals("") || !arrayList.get(index).equals("\n") || arrayList.get(index) != null) {
            // Look at own ticket
            if (arrayList.get(index).equals("")) {
                break;
            }
            index++;
        }

        index += 2;

        while (index < arrayList.size()) {

            validCounter = 0;
            // Look at nearby tickets
            String[] splitNearbyTickets = arrayList.get(index).split(",");

            for (String ticketNumbers : splitNearbyTickets) {

                counter = 0;

                value = Integer.parseInt(ticketNumbers);

                for (int j = 0; j < minNumbers.size(); j += 2) {
                    if (value >= minNumbers.get(j) && value <= maxNumbers.get(j)) {
                        continue;
                    } else if (value >= minNumbers.get(j + 1) && value <= maxNumbers.get(j + 1)) {
                        continue;
                    } else {
                        counter++;
                    }
                }

                if (counter == fields.size()) {
                    invalidValues.add(value);
                } else {
                    validCounter++;
                }
            }

            // Checks whether all values are valid, if they are, add to list of valid tickets
            if (validCounter == splitNearbyTickets.length) {
                validTickets.add(arrayList.get(index));
            }

            if (arrayList.get(index).equals("")) {
                break;
            }

            index++;

        }


        // Using validTickets list should only have valid tickets with invalid ones removed

        // This part is way too confusing for me
        // Currently this method checks for whether all values in the column can match to a single field
        // This does not work because I believe some columns can be mapped to multiple fields / ranges
        // This makes it much harder as you would need to determine when they are mapped correctly
        // Not only when they fit that one column

        HashMap<String, Integer> mappingFieldsToColumns = new HashMap<>();

        int valueToCheck;
        int fieldChecker;

        for (int i = 0; i < fields.size(); i++) {

            for (int k = 0; k < minNumbers.size(); k += 2) {

                fieldChecker = 0;

                for (int j = 0; j < validTickets.size(); j++) {

                    valueToCheck = Integer.parseInt(validTickets.get(j).split(",")[i]);

                    if ((valueToCheck >= minNumbers.get(k) &&
                            valueToCheck <= maxNumbers.get(k)) ||
                            (valueToCheck >= minNumbers.get(k + 1) &&
                                    valueToCheck <= maxNumbers.get(k + 1))) {

                        fieldChecker++;

                    } else {
                        break;
                    }

                }

                if (fieldChecker == validTickets.size()) {
                    mappingFieldsToColumns.put(fields.get(((k + 2) / 2) - 1), i);
                    break;
                }

            }

        }

        System.out.println(mappingFieldsToColumns);

        return 0;
    }


}
