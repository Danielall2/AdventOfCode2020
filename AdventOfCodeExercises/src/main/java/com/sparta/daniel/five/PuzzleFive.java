package com.sparta.daniel.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PuzzleFive {

    public static ArrayList<Integer> rowList = new ArrayList<>();
    public static ArrayList<Integer> seatIDlIST = new ArrayList<>();

    // highestSeatID will rely on a method which calculates seat ID

    public static int highestSeatID (ArrayList<String> arrayList) {

        int highestID = 0;
        int seatID;

        for (String input : arrayList) {
            seatID = getSeatID(input);
            if (seatID > highestID) {
                highestID = seatID;
            }

        }

        System.out.println("HighestID : " + highestID);
        Collections.sort(rowList);

        for (int i = 1; i < 858; i++) {
            if(!seatIDlIST.contains(i)) {
                System.out.println("Missing ID : " + i);
            }
        }


        //System.out.println("RowList : " + rowList);

        return highestID;

    }

    public static int getSeatID (String code) {
        int[] range = new int[] {0,127};
        int[] rangeEight = new int[] {0,7};

        int row = 0;
        int column = 0;

        for (char character : code.substring(0,6).toCharArray()) {
            if (character == 'F') {
                range[1] = range[1] - ((range[1] - range[0] + 1) / 2);
            } else if (character == 'B') {
                range[0] = range[0] + ((range[1]-range[0] + 1) / 2);
            }
            //System.out.println(Arrays.toString(range));
        }

        if (code.charAt(6) == 'F') {
            row = range[0];
        } else if (code.charAt(6) == 'B') {
            row = range[1];
        }

        rowList.add(row);

        for (char character : code.substring(7,9).toCharArray()) {
            if (character == 'L') {
                rangeEight[1] = rangeEight[1] - ((rangeEight[1] - rangeEight[0] + 1) / 2);
            } else if (character == 'R') {
                rangeEight[0] = rangeEight[0] + ((rangeEight[1]-rangeEight[0] + 1) / 2);
            }
            //System.out.println(Arrays.toString(rangeEight));
        }

        if (code.charAt(9) == 'L') {
            column = rangeEight[0];
        } else if (code.charAt(9) == 'R') {
            column = rangeEight[1];
        }

        int seatID = (row * 8) + column;

        seatIDlIST.add(seatID);

        //System.out.println(Arrays.toString(range));

        //System.out.println(seatID);

        return seatID;

    }

}
