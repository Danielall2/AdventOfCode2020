package com.sparta.daniel;

import com.sparta.daniel.eight.PuzzleEight;
import com.sparta.daniel.eleven.PuzzleEleven;
import com.sparta.daniel.fifteen.PuzzleFifteen;
import com.sparta.daniel.five.PuzzleFive;
import com.sparta.daniel.four.PuzzleFour;
import com.sparta.daniel.fourteen.PuzzleFourteen;
import com.sparta.daniel.io.CSVReaderInt;
import com.sparta.daniel.io.CSVReaderLong;
import com.sparta.daniel.io.CSVReaderString;
import com.sparta.daniel.nine.PuzzleNine;
import com.sparta.daniel.one.PuzzleOne;
import com.sparta.daniel.six.PuzzleSix;
import com.sparta.daniel.ten.PuzzleTen;
import com.sparta.daniel.thirteen.PuzzleThirteen;
import com.sparta.daniel.three.PuzzleThree;
import com.sparta.daniel.twelve.PuzzleTwelve;
import com.sparta.daniel.two.PuzzleTwo;

import java.util.ArrayList;

public class App {
    public static void main( String[] args ) {

        ArrayList<Integer> AdventData = CSVReaderInt.readAdventData("src/main/resources/AdventDataOne.csv");

        System.out.println("");
        System.out.println("--- Puzzle 1 ---");
        System.out.println("");
        PuzzleOne.exercise1(AdventData);
        PuzzleOne.exercise2(AdventData);

        ArrayList<String> AdventDataTwo = CSVReaderString.readAdventData("src/main/resources/AdventDataTwo.csv");

        System.out.println("");
        System.out.println("--- Puzzle 2 ---");
        System.out.println("");
        PuzzleTwo.numberOfValidPasswordsOne(AdventDataTwo);
        PuzzleTwo.numberOfValidPasswordsTwo(AdventDataTwo);

        ArrayList<String> AdventDataThree = CSVReaderString.readAdventData("src/main/resources/AdventDataThree.csv");

        System.out.println("");
        System.out.println("--- Puzzle 3 ---");
        System.out.println("");
        PuzzleThree.oneRouteNumberOfTrees(AdventDataThree, 3, 1);
        PuzzleThree.multipleRouteCalculation(AdventDataThree);

        ArrayList<String> AdventDataFour = CSVReaderString.readAdventData("src/main/resources/AdventDataFour.csv");

        System.out.println("");
        System.out.println("--- Puzzle 4 ---");
        System.out.println("");
        PuzzleFour.getNumberValidPassports(AdventDataFour);

        ArrayList<String> AdventDataFive = CSVReaderString.readAdventData("src/main/resources/AdventDataFive.csv");

        System.out.println("");
        System.out.println("--- Puzzle 5 ---");
        System.out.println("");
        PuzzleFive.highestSeatID(AdventDataFive);

        ArrayList<String> AdventDataSix = CSVReaderString.readAdventData("src/main/resources/AdventDataSix.csv");

        System.out.println("");
        System.out.println("--- Puzzle 6 ---");
        System.out.println("");
        PuzzleSix.getNumberOfYes(AdventDataSix);
        PuzzleSix.getNumberOfYesPartTwo(AdventDataSix);

        // Gap for Puzzle Seven
        /*





         */

        ArrayList<String> AdventDataEight = CSVReaderString.readAdventData("src/main/resources/AdventDataEight.csv");

        System.out.println("");
        System.out.println("--- Puzzle 8 ---");
        System.out.println("");
        PuzzleEight.calculateAccumulator(AdventDataEight);
        PuzzleEight.findCorrection(AdventDataEight);

        // Need to create another CSV Reader to take long integers

        ArrayList<Long> AdventDataNine = CSVReaderLong.readAdventData("src/main/resources/AdventDataNine.csv");

        System.out.println("");
        System.out.println("--- Puzzle 9 ---");
        System.out.println("");
        PuzzleNine.findInvalidNumberInSequence(AdventDataNine);
        PuzzleNine.getNumberFromSet(AdventDataNine);

        ArrayList<Integer> AdventDataTen = CSVReaderInt.readAdventData("src/main/resources/AdventDataTen.csv");

        System.out.println("");
        System.out.println("--- Puzzle 10 ---");
        System.out.println("");
        PuzzleTen.organiseAdapters(AdventDataTen);
        PuzzleTen.partTwo(AdventDataTen);

        ArrayList<String> AdventDataEleven = CSVReaderString.readAdventData("src/main/resources/AdventDataEleven.csv");

        System.out.println("");
        System.out.println("--- Puzzle 11 ---");
        System.out.println("");
        PuzzleEleven.getSeatsOccupiedAfterFinish(AdventDataEleven);

        ArrayList<String> AdventDataTwelve = CSVReaderString.readAdventData("src/main/resources/AdventDataTwelve.csv");

        System.out.println("");
        System.out.println("--- Puzzle 12 ---");
        System.out.println("");
        PuzzleTwelve.calculatePositionShip(AdventDataTwelve);
        PuzzleTwelve.calculatePositionPartTwo(AdventDataTwelve);

        ArrayList<String> AdventDataThirteen = CSVReaderString.readAdventData("src/main/resources/AdventDataThirteen.csv");

        System.out.println("");
        System.out.println("--- Puzzle 13 ---");
        System.out.println("");
        PuzzleThirteen.getIDOfEarliestBus(AdventDataThirteen);
        // Second part doesn't finish, need to look at it again to see if I can make it quicker or fix the bug thats making it continue indefinitely
        //PuzzleThirteen.getCoincideBusTime(AdventDataThirteen);

        // For Puzzle Fourteen I need to understand the value system (to do with bitmask?)

        ArrayList<String> AdventDataFourteen = CSVReaderString.readAdventData("src/main/resources/AdventDataFourteen.csv");

        System.out.println("");
        System.out.println("--- Puzzle 14 ---");
        System.out.println("");
        PuzzleFourteen.getPartOneAnswer(AdventDataFourteen);

        ArrayList<String> AdventDataFifteen = CSVReaderString.readAdventData("src/main/resources/AdventDataFifteen.csv");

        System.out.println("");
        System.out.println("--- Puzzle 15 ---");
        System.out.println("");
        PuzzleFifteen.getPartOneAnswer(AdventDataFifteen);
        // Second Part Takes too Long
        //PuzzleFifteen.getPartTwoAnswer(AdventDataFifteen);


    }
}
