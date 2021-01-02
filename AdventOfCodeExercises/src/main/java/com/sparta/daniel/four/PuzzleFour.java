package com.sparta.daniel.four;

import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleFour {

    public static int getNumberValidPassports (ArrayList<String> arrayList) {

        ArrayList<String> passports = new ArrayList<>();
        ArrayList<String> separatedPassports = new ArrayList<>();
        int validPassports = 0;
        ArrayList<String> temporary = new ArrayList<>();

        String hairColorCharacters = "0123456789abcdef";
        String numberCharacters = "0123456789";

        // Need to find a way to group strings of same passport together

        int i = 0;

        while (i < arrayList.size()) {

            StringBuilder passportString = new StringBuilder();

            while (arrayList.get(i) != "") {
                passportString.append(arrayList.get(i));
                passportString.append(" ");
                i++;

                if (i == arrayList.size()) {
                    break;
                }

            }

            passports.add(passportString.toString());

            passportString.setLength(0);

        }

        String neededToSplit = passports.get(0);

        String[] neededToSplitTwo = neededToSplit.split("  ");


        int index = 0;

        for (String data : neededToSplitTwo) {
            separatedPassports.add(index, data);
            index++;
        }

        //System.out.println(separatedPassports.size());

        //System.out.println(passports);

        //System.out.println(separatedPassports);

        //System.out.println(separatedPassports.get(0));


        // Method above gets me the passport data separated for each index in the ArrayList of Strings, with all values separated by a space
        // Now need a way of confirming that entries are valid and enough data has been given

        int tag;

        for (String entry : separatedPassports) {



            tag = 0;

            String[] splittedEntries = entry.split(" ");

            // Validation needs to go here by spliiting each by :

            // Remove below if only want first part


            for (String splitted : splittedEntries) {
                String[] splitTheSplitted = splitted.split(":");

//                System.out.println("splitted : " + splitted);
//                System.out.println("splitTheSplitted : " + splitTheSplitted);

                temporary.clear();
                temporary.addAll(Arrays.asList(splitTheSplitted));

//                System.out.println("temporary : " + temporary);

                String left = temporary.get(0);
                String right = temporary.get(1);

                //System.out.println("left : " + left);
                //System.out.println("right : " + right);

                try {

                    if (left.equals("byr")) {
                        if (right.length() == 4) {
                            for (char character : right.toCharArray()) {
                                if (numberCharacters.indexOf(character) != -1) {

                                } else {
                                    tag++;
                                }
                            }
                            if (Integer.parseInt(right) >= 1920 && Integer.parseInt(right) <= 2002) {
                            } else {
                                tag++;
                            }
                        } else {
                            tag++;
                        }
                    }

                    if (left.equals("iyr")) {
                        if (right.length() == 4) {
                            for (char character : right.toCharArray()) {
                                if (numberCharacters.indexOf(character) != -1) {

                                } else {
                                    tag++;
                                }
                            }
                            if (Integer.parseInt(right) >= 2010 && Integer.parseInt(right) <= 2020) {
                            } else {
                                tag++;
                            }
                        } else {
                            tag++;
                        }
                    }

                    if (left.equals("eyr")) {
                        if (right.length() == 4) {
                            for (char character : right.toCharArray()) {
                                if (numberCharacters.indexOf(character) != -1) {

                                } else {
                                    tag++;
                                }
                            }
                            if (Integer.parseInt(right) >= 2020 && Integer.parseInt(right) <= 2030) {
                            } else {
                                tag++;
                            }
                        } else {
                            tag++;
                        }
                    }

                    if (left.equals("hgt")) {
                        String cmOrIn = right.substring(right.length() - 2);
                        //System.out.println("cmOrIn : " + cmOrIn);
                        int height = Integer.parseInt(right.substring(0, right.length() - 2));
                        //System.out.println("height : " + height);
                        if (cmOrIn.equals("cm")) {
                            if (height >= 150 && height <= 193) {
                            } else {
                                tag++;
                            }
                        } else if (cmOrIn.equals("in")) {
                            if (height >= 59 && height <= 76) {
                            } else {
                                tag++;
                            }
                        } else {
                            tag++;
                        }
                    }

                    if (left.equals("hcl")) {
                        if (right.charAt(0) == '#' && right.length() == 7) {
                            for (char character : right.substring(1).toCharArray()) {
                                if (hairColorCharacters.indexOf(character) != -1) {
                                } else {
                                    tag++;
                                }

                            }
                        } else {
                            tag++;
                        }
                    }

                    if (left.equals("ecl")) {
                        if (right.equals("amb") ||
                                right.equals("blu") ||
                                right.equals("brn") ||
                                right.equals("gry") ||
                                right.equals("grn") ||
                                right.equals("hzl") ||
                                right.equals("oth")) {
                        } else {
                            tag++;
                        }
                    }

                    if (left.equals("pid")) {
                        if (right.length() == 9) {
                            for (char character : right.toCharArray()) {
                                if (numberCharacters.indexOf(character) != -1) {

                                } else {
                                    tag++;
                                }
                            }
                        } else {
                            tag++;
                        }
                    }

                } catch (NumberFormatException e) {
                    tag = 100;
                }



            }

            if (tag == 0) {


                if (splittedEntries.length > 6 && splittedEntries.length < 9) {
                    if (entry.contains("byr") &&
                            entry.contains("iyr") &&
                            entry.contains("eyr") &&
                            entry.contains("hgt") &&
                            entry.contains("hcl") &&
                            entry.contains("ecl") &&
                            entry.contains("pid")) {

                        validPassports++;
                    }
                }
            }

            //System.out.println(splittedEntries.length);
        }

        System.out.println("Number of Valid Passports : " + validPassports);

        return validPassports;

    }
}
