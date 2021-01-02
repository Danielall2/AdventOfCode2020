package com.sparta.daniel.twelve;

import java.util.ArrayList;
import java.util.HashMap;

public class PuzzleTwelve {

    // Thinking about this I should Set North, South, East and West as directions in a HashMap
    // These would be assigned to values

    // Angle determined as normal from east line going anticlockwise
    private static int angle = 0;
    private static int verticalValue = 0;
    private static int horizontalValue = 0;
    private static int value;

    // Important to remember these are relative values
    private static int waypointVerticalValue = 1;
    private static int waypointHorizontalValue = 10;

    public static int calculatePositionShip (ArrayList<String> arrayList) {

        HashMap<Integer, Character> directions = new HashMap<>();
        char direction;

        directions.put(0, 'E');
        directions.put(90, 'N');
        directions.put(180, 'W');
        directions.put(270, 'S');

        // Angle can go negative and over 360 so need if conditions to + or - 360 when this happens and to always check

        for (String movement : arrayList) {
            char firstChar = movement.charAt(0);
            String number = movement.substring(1);
            value = Integer.parseInt(number);

            moveShip(firstChar, value);

            if (firstChar == 'L' || firstChar == 'R') {
                if (firstChar == 'L') {
                    angle = angle + value;
                } else {
                    angle = angle - value;
                }

                angle = validityCheck(angle);
            }

            if (firstChar == 'F') {
                direction = directions.get(angle);

                moveShip(direction, value);

            }

        }

        int finalValue = Math.abs(verticalValue) + Math.abs(horizontalValue);

        System.out.println("Puzzle Twelve Part 1 : " + finalValue);

        return finalValue;

    }

    public static void moveShip (char direction, int number) {
        if (direction == 'N') {
            verticalValue = verticalValue + number;
        } else if (direction == 'S') {
            verticalValue = verticalValue - number;
        } else if (direction == 'E') {
            horizontalValue = horizontalValue + number;
        } else if (direction == 'W') {
            horizontalValue = horizontalValue - number;
        }

    }


    public static int validityCheck (int number) {

        if (number >= 360) {
            number = number - 360;
            validityCheck(number);
        } else if (number < 0) {
            number = number + 360;
            validityCheck(number);
        }

        return number;
    }

    public static int calculatePositionPartTwo (ArrayList<String> arrayList) {

        verticalValue = 0;
        horizontalValue = 0;

        for (String movement : arrayList) {
            char firstChar = movement.charAt(0);
            String number = movement.substring(1);
            value = Integer.parseInt(number);

            moveWaypoint(firstChar, value);

            if (firstChar == 'L' || firstChar == 'R') {
                int tempValue = waypointVerticalValue;
                if (firstChar == 'L') {

                    if (value == 90) {
                        waypointVerticalValue = waypointHorizontalValue;
                        waypointHorizontalValue = -1 * tempValue;
                    } else if (value == 180) {
                        waypointVerticalValue = -1 * waypointVerticalValue;
                        waypointHorizontalValue = -1 *waypointHorizontalValue;
                    } else if (value == 270) {
                        waypointVerticalValue = -1 * waypointHorizontalValue;
                        waypointHorizontalValue = tempValue;

                    } else {
                        System.out.println("Missed rotation value");
                    }

                } else {

                    if (value == 90) {
                        waypointVerticalValue = -1 * waypointHorizontalValue;
                        waypointHorizontalValue = tempValue;
                    } else if (value == 180) {
                        waypointVerticalValue = -1 * waypointVerticalValue;
                        waypointHorizontalValue = -1 * waypointHorizontalValue;
                    } else if (value == 270) {
                        waypointVerticalValue = waypointHorizontalValue;
                        waypointHorizontalValue = -1 * tempValue;
                    } else {
                        System.out.println("Missed rotation value");
                    }
                }

            }

            // DON'T MOVE WAYPOINT ONLY NEED RELATIVE VALUE

            if (firstChar == 'F') {

                verticalValue = verticalValue + (waypointVerticalValue * value);
                horizontalValue = horizontalValue + (waypointHorizontalValue * value);

            }

        }

        int finalValue = Math.abs(verticalValue) + Math.abs(horizontalValue);

        System.out.println("Puzzle Twelve Part 2 : " + finalValue);

        return finalValue;

    }

    public static void moveWaypoint (char direction, int number) {
        if (direction == 'N') {
            waypointVerticalValue = waypointVerticalValue + number;
        } else if (direction == 'S') {
            waypointVerticalValue = waypointVerticalValue - number;
        } else if (direction == 'E') {
            waypointHorizontalValue = waypointHorizontalValue + number;
        } else if (direction == 'W') {
            waypointHorizontalValue = waypointHorizontalValue - number;
        }

    }

}
