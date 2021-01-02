package com.sparta.daniel.one;

import java.util.ArrayList;

public class PuzzleOne {

    public static int exercise1 (ArrayList<Integer> array) {
        for(int number: array) {
            for(int number2 : array){
                if(number + number2 == 2020){
                    System.out.println(number*number2);
                    return number*number2;
                }
            }
        }
        return 0;
    }

    public static int exercise2 (ArrayList<Integer> array) {
        for(int number: array) {
            for(int number2 : array) {
                for (int number3: array) {
                    if(number + number2 + number3 == 2020){
                        System.out.println(number*number2*number3);
                        return number*number2;
                    }
                }
            }
        }
        return 0;
    }

}
