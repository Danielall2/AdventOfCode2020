package com.sparta.daniel.fourteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PuzzleFourteen {

    // Need to understand bitmask / value system

    // Ok think I understand, use this link to understand method of changing decimal to binary :
    // https://www.rapidtables.com/convert/number/decimal-to-binary.html

    public static long getPartOneAnswer(ArrayList<String> arrayList) {

        HashMap<Integer, String> values = new HashMap<>();
        String newMask = "";
        String newValue;

        String bitValue = "";
        String mask = "";
        int memValue;
        int decimalValue;
        String value;

        for (int i = 0; i < 36; i++) {
            bitValue = bitValue + "0";
        }

        for (String input : arrayList) {
            String[] splitted = input.split(" = ");

            newValue = "";

            if (splitted[0].equals("mask")) {
                mask = splitted[1];

                newMask = mask;


            } else {
                memValue = Integer.parseInt(splitted[0].substring(4, splitted[0].length() - 1));

                decimalValue = Integer.parseInt(splitted[1]);

                value = convertToBinary(decimalValue);

                for (int i = 0; i < newMask.length(); i++) {
                    if (newMask.charAt(i) == 'X') {
                        newValue = newValue + value.charAt(i);
                    } else if (newMask.charAt(i) == '0') {
                        newValue = newValue + '0';
                    } else if (newMask.charAt(i) == '1') {
                        newValue = newValue + '1';
                    }
                }
                values.put(memValue, newValue);
            }
        }

        ArrayList<Double> finalValues = new ArrayList<>();
        String finalValue;
        double finalDecimal;

        for (Map.Entry<Integer, String> entry : values.entrySet()) {
            finalValue = entry.getValue();

            finalDecimal = convertToDecimal(finalValue);

            finalValues.add(finalDecimal);

        }

        double sum = 0;

        for (double number : finalValues) {
            sum = sum + number;
        }


        System.out.printf("Puzzle Fourteen Part 1 : %.0f\n", sum);

        System.out.println("Confirmation of Answer as int : " + Math.round(sum));

        return Math.round(sum);

    }

    public static String convertToBinary(int decimal) {

        int quotient;
        int remainder;

        String newString = "";
        String value = "";

        do {
            quotient = decimal / 2;
            remainder = decimal % 2;

            // Issue with changing value as Strings immutable

            newString = remainder + newString;

            decimal = quotient;


        } while (quotient != 0);

        for (int i = 0; i < 36 - newString.length(); i++) {
            value = value + "0";
        }

        value = value + newString;

        return value;

    }


    public static double convertToDecimal(String binary) {

        if (binary.length() != 36) {
            System.out.println("THERE IS A PROBLEM WHEN CONVERTING TO DECIMAL, BINARY LENGTH < 36!");
        }

        double decimal = 0;

        for (int bitCounter = 35; bitCounter >= 0; bitCounter--) {
            if (bitCounter == 35) {
                decimal = decimal + (Integer.parseInt(binary.substring(35)));
            } else {
                decimal = decimal + (Math.pow(2, (35 - bitCounter)) * Integer.parseInt(binary.substring(bitCounter, bitCounter + 1)));
            }
        }

        return decimal;
    }


    // Part 2 involves changing the rules so that X takes priority as well
    // X becomes part of the result and becomes any possible value
    // Also the values aren't changed but the addresses are
    // Then need to calculate all the values same as before

    // I think the only part left to achieve is to let X become anything
    // Cannot think of a way to do it in a for loop as would need for all others to change accordingly when one is changed


    public static int getPartTwoAnswer(ArrayList<String> arrayList) {

        HashMap<String, Integer> values = new HashMap<>();

        int memValue;
        int decimalValue;
        String value;
        String newAddress;
        String mask = "";
        String address;

        for (String input : arrayList) {
            String[] splitted = input.split(" = ");

            newAddress = "";

            if (splitted[0].equals("mask")) {
                mask = splitted[1];

            } else {
                memValue = Integer.parseInt(splitted[0].substring(4, splitted[0].length() - 1));

                decimalValue = Integer.parseInt(splitted[1]);

                address = convertToBinary(memValue);

                for (int i = 0; i < mask.length(); i++) {
                    if (mask.charAt(i) == 'X') {
                        newAddress = newAddress + 'X';
                    } else if (mask.charAt(i) == '0') {
                        newAddress = newAddress + address.charAt(i);
                    } else if (mask.charAt(i) == '1') {
                        newAddress = newAddress + '1';
                    }
                }
                values.put(newAddress, decimalValue);

            }

        }

        HashMap<String, Integer> allAddresses = new HashMap<>();

        // Below won't work as I expected because doesn't account for multiple X's
        // Need a way for it to change all X's for one then make sure its always different.

        // Need to create a method and use recursion so that all the possibilities are accounted for
        // Not quite sure how to do this though.



        return 0;
    }
}
