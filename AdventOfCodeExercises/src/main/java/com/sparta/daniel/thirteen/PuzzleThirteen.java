package com.sparta.daniel.thirteen;

import java.util.ArrayList;
import java.util.Collections;

public class PuzzleThirteen {

    public static int getIDOfEarliestBus (ArrayList<String> arrayList) {

        ArrayList<Integer> busIDs = new ArrayList<>();

        int startTime = Integer.parseInt(arrayList.get(0));

        String[] split = arrayList.get(1).split(",");

        for (String string : split) {
            if (string.charAt(0) == 'x') {
                continue;
            } else {
                busIDs.add(Integer.parseInt(string));
            }
        }

        int minutesAfter = 0;
        int correctID;

        outerLoop:
        while (true) {

            for (int id : busIDs) {
                if ((startTime + minutesAfter) % id == 0) {
                    correctID = id;
                    break outerLoop;
                }
            }

            minutesAfter++;

        }

        int answer = correctID * minutesAfter;

        System.out.println("Puzzle Thirteen Part 1 : " + answer);

        return answer;

    }


    public static long getCoincideBusTime (ArrayList<String> arrayList) {

        String[] toUse = arrayList.get(1).split(",");

        ArrayList<Long> startTimes = new ArrayList<>();
        ArrayList<Integer> busID = new ArrayList<>();

        long t = 0;

        for (String character : toUse) {
            if (character.charAt(0) != 'x') {
                startTimes.add(t);
                busID.add(Integer.parseInt(character));

            }
            t++;
        }

        int counter;
        long answer;
        int firstID = busID.get(0);

        for (long time = t; true; time++) {
            counter = 0;
            for (int i = 0; i < startTimes.size(); i++) {
                if ((time + startTimes.get(i) % busID.get(i) == 0)) {
                    counter++;
                } else {
                    break;
                }
            }
            if (counter == startTimes.size()) {
                answer = time + Collections.max(busID);
                break;
            }
        }

        System.out.println("Puzzle Thirteen Part 2 : " + answer);

        return answer;


    }




}
