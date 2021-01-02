package com.sparta.daniel.eleven;

import java.util.ArrayList;

public class PuzzleEleven {

    // Simply need to create a loop where a check is made to see if the arrayList before and after are the same
    // The loop will then iterate if they are different, using the rules given and making sure to keep track
    // of horizontal and vertical index

    private static int numberOfIterations = 0;
    private static int numberOfSeatsOccupied = 0;

    public static int getSeatsOccupiedAfterFinish(ArrayList<String> arrayList) {

//        System.out.println("Iteration : " + numberOfIterations);
//        System.out.println("Number of Seats of previous Iteration : " + numberOfSeatsOccupied);
        numberOfIterations++;

        ArrayList<String> beforeChange = new ArrayList<>();
        ArrayList<String> afterChange = new ArrayList<>();


        for (String s : arrayList) {
            beforeChange.add(s);
            afterChange.add(s);
        }


        int horizontalIndex;
        int verticalIndex;
        int counter = 0;
        numberOfSeatsOccupied = 0;


        for (verticalIndex = 0; verticalIndex < beforeChange.size(); verticalIndex++) {
            for (horizontalIndex = 0; horizontalIndex < arrayList.get(0).length(); horizontalIndex++) {
                int adjacentSeatCounter = 0;
                if (beforeChange.get(verticalIndex).charAt(horizontalIndex) == 'L') {

                    for (int i = -1; i < 2; i++) {
                        if (verticalIndex == 0 && i == -1) {
                            adjacentSeatCounter+=3;
                            continue;
                        } else if (verticalIndex == arrayList.size() - 1 && i == 1) {
                            adjacentSeatCounter+=3;
                            continue;
                        }
                        for (int j = -1; j < 2; j++) {
                            if (horizontalIndex == 0 && j == -1) {
                                adjacentSeatCounter++;
                                continue;
                            }
                            else if (i == 0 && j == 0) {
                                continue;
                            }
                            else if (horizontalIndex == arrayList.get(0).length() - 1 && j == 1) {
                                adjacentSeatCounter++;
                                continue;
                            }
                            else if (beforeChange.get(verticalIndex + i).charAt(horizontalIndex + j) == 'L' ||
                                    beforeChange.get(verticalIndex + i).charAt(horizontalIndex + j) == '.') {
                                adjacentSeatCounter++;
                            }
                        }
                    }

                    if (adjacentSeatCounter == 8) {
                        String newString = afterChange.get(verticalIndex).substring(0, horizontalIndex) + '#' + afterChange.get(verticalIndex).substring(horizontalIndex + 1);
                        afterChange.set(verticalIndex, newString);
                    }


                } else if (beforeChange.get(verticalIndex).charAt(horizontalIndex) == '#') {

                    numberOfSeatsOccupied++;

                    for (int i = -1; i < 2; i++) {
                        if (verticalIndex == 0 && i == -1) {
                            continue;
                        }
                        else if (verticalIndex == arrayList.size() - 1 && i == 1) {
                            continue;
                        }
                        for (int j = -1; j < 2; j++) {
                            if (horizontalIndex == 0 && j == -1) {
                                continue;
                            }
                             else if (horizontalIndex == arrayList.get(0).length() - 1 && j == 1) {
                                continue;
                            }
                            else if (i == 0 && j == 0) {
                                continue;
                            }
                            else if (beforeChange.get(verticalIndex + i).charAt(horizontalIndex + j) == '#') {
                                adjacentSeatCounter++;
                            }
                        }
                    }

                    if (adjacentSeatCounter >= 4) {
                        String newString = afterChange.get(verticalIndex).substring(0, horizontalIndex) + 'L' + afterChange.get(verticalIndex).substring(horizontalIndex + 1);
                        afterChange.set(verticalIndex, newString);
                    }

                }
            }
        }


        for (int i = 0; i < beforeChange.size(); i++) {
            if (beforeChange.get(i) == (afterChange.get(i))) {
                counter++;
            }
        }

        if (counter == beforeChange.size()) {
            System.out.println("Total Iterations : " + numberOfIterations);
            System.out.println("Number of Seats : " + numberOfSeatsOccupied);
//            System.out.println(beforeChange);
//            System.out.println(afterChange);
            return numberOfSeatsOccupied;
        } else {
            getSeatsOccupiedAfterFinish(afterChange);
        }


        return 0;

    }


    // Just reading what I need to do for the second part is giving me a headache
    // Must be a better way of doing it than what I am thinking
    // Maybe go back to original thinking of catching index out of bounds exception?
    // Possibly use a while loop with two (three?) conditions to limit when horizontal and vertical index go out of bounds
    // Also include condition when an empty or occupied seat is seen?
    // Issue for diagonal as need to increase the index's together so that it corresponds to line of sight
    // Need to write a specially conditioned if statement for each of the 8 conditions :(





}
