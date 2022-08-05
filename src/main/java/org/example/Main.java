package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int diceRollArr[] = new int[5];
        int score = 0;
        boolean isSorted = false;
        boolean isTriplet = false;
        int buf;
        int ordinary = 0;

        Scanner in = new Scanner(System.in);

        for (int i = 0; i <= diceRollArr.length - 1; i++) {
            System.out.printf("Enter your %d roll ", i + 1);
            diceRollArr[i] = in.nextInt();
            if (diceRollArr[i] < 1 | diceRollArr[i] > 6) {
                System.out.printf("Enter another argumends ");
                i--;
            }
        }

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < diceRollArr.length - 1; i++) {
                if (diceRollArr[i] > diceRollArr[i + 1]) {
                    isSorted = false;

                    buf = diceRollArr[i];
                    diceRollArr[i] = diceRollArr[i + 1];
                    diceRollArr[i + 1] = buf;
                }
            }
        }
        for (int i = 1; i <= diceRollArr.length - 2; i++) {

            if (diceRollArr[i] == 1 & diceRollArr[i - 1] == 1 & diceRollArr[i + 1] == 1) {
                score += diceRollArr[i] * 1000;
                isTriplet = true;
                break;
            } else if (diceRollArr[i] == diceRollArr[i - 1] & diceRollArr[i] == diceRollArr[i + 1]) {
                score += diceRollArr[i] * 100;
                isTriplet = true;
                break;
            }
        }
        for (int i = 0; i <= diceRollArr.length - 1; i++) {
            if (isTriplet == false) {
                if (diceRollArr[i] == 1) {
                    score += diceRollArr[i] * 100;
                } else if (diceRollArr[i] == 5) {
                    score += diceRollArr[i] * 10;
                }

            }
            else {
                if (diceRollArr[i] == 1) {
                    score += 100;
                    ordinary ++;
                    if(ordinary>=2){
                        break;
                    }
                } else if (diceRollArr[i] == 5) {
                    score += 50;
                    ordinary ++;
                    if(ordinary>=2){
                        break;
                    }

                }
            }
        }
        System.out.println(Arrays.toString(diceRollArr));
        System.out.println("Your score is: " + score);
    }
}
