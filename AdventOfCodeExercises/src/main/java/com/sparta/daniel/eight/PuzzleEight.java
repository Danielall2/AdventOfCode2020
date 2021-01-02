package com.sparta.daniel.eight;

import java.util.ArrayList;
import java.util.HashSet;

public class PuzzleEight {

    // A few notes
    // First need to split the string into the two different sections
    // Just need to include an if condition in the while loop
    // The loop keeps track of a counter of i's which have been used in an arrayList
    // Once the i is used again, break
    // The while loop will have kept track of the accumulator
    // Once while loop is broken, print and return accumulator

    private static int accumulator = 0;

    public static int calculateAccumulator (ArrayList<String> arrayList) {

        ArrayList<String> leftSide = new ArrayList<>();
        ArrayList<String> rightSide = new ArrayList<>();
        HashSet<Integer> storeIndex = new HashSet<>();

        for (String data : arrayList) {
            String[] splitData = data.split(" ");

            leftSide.add(splitData[0]);
            rightSide.add(splitData[1]);
        }



        int index = 0;
        String reader;

        while (index < arrayList.size()) {

            if (storeIndex.contains(index)) {
                System.out.println("Accumulator : " + accumulator);
                return accumulator;
            }


            reader = leftSide.get(index);


            switch (reader) {
                case "acc":
                    accumulator = accumulator + Integer.parseInt(rightSide.get(index));
                    storeIndex.add(index);
                    index++;
                    break;
                case "jmp":
                    storeIndex.add(index);
                    index = index + Integer.parseInt(rightSide.get(index));
                    break;
                case "nop":
                    storeIndex.add(index);
                    index++;
                    break;
            }


        }

        return accumulator;

    }


    public static boolean calculateAccumulatorPartTwo (ArrayList<String> arrayList) {

        ArrayList<String> leftSide = new ArrayList<>();
        ArrayList<String> rightSide = new ArrayList<>();
        HashSet<Integer> storeIndex = new HashSet<>();

        for (String data : arrayList) {
            String[] splitData = data.split(" ");

            leftSide.add(splitData[0]);
            rightSide.add(splitData[1]);
        }



        int index = 0;

        boolean complete = false;

        // Need an index tracker from before they are changed

        int indexBefore = 0;

        String reader;

        while (index != arrayList.size()) {



            if (storeIndex.contains(index)) {
                //System.out.println("Accumulator : " + accumulator);
                return complete;
            }


            reader = leftSide.get(index);


            switch (reader) {
                case "acc":
                    accumulator = accumulator + Integer.parseInt(rightSide.get(index));
                    storeIndex.add(index);
                    indexBefore = index;
                    index++;
                    break;
                case "jmp":
                    storeIndex.add(index);
                    indexBefore = index;
                    index = index + Integer.parseInt(rightSide.get(index));
                    break;
                case "nop":
                    storeIndex.add(index);
                    indexBefore = index;
                    index++;
                    break;
            }


        }

        if (index >= arrayList.size()) {
            System.out.println("Terminated Successfully");
            complete = true;
        }
        //System.out.println("Accumulator for Part Two : " + accumulator);

        return complete;

    }

//    private void findFault(){
//        String[] split;
//
//        for (int i = 0; i < bootcode.size(); i++){
//            accumulator = 0;
//            split = bootcode.get(i).split(" ");
//            if (split[0].equals("nop")){
//                bootcode.set(i,"jmp "+Integer.parseInt(split[1]));
//                if (infiniteCheck()){ break; }
//                bootcode.set(i,"nop "+Integer.parseInt(split[1]));
//            } else if (split[0].equals("jmp")){
//                bootcode.set(i, "nop " + Integer.parseInt(split[1]));
//                if (infiniteCheck()){ break; }
//                bootcode.set(i,"jmp "+Integer.parseInt(split[1]));
//            }
//        }
//    }

    // Method created with help from a code found from reddit (original shown above)

    public static void findCorrection(ArrayList<String> arrayList) {
        String[] split;

        for (int i = 0; i < arrayList.size() ; i++) {
            accumulator = 0;

            split = arrayList.get(i).split(" ");

            if (split[0].equals("nop")) {
                arrayList.set(i, "jmp " + Integer.parseInt(split[1]));
                if (calculateAccumulatorPartTwo(arrayList)) {
                    break;
                }
                arrayList.set(i, "nop " + Integer.parseInt(split[1]));
            } else if (split[0].equals("jmp")) {
                arrayList.set(i, "nop " + Integer.parseInt(split[1]));
                if (calculateAccumulatorPartTwo(arrayList)) {
                    break;
                }
                arrayList.set(i, "jmp " + Integer.parseInt(split[1]));

            }


        }

        System.out.println("Complete Accumulator : " + accumulator);
    }






}
