package com.ace3i.algos;

import java.util.Arrays;

public class Algos {

    public static Change optimalChange(long amount) {
        int[] checkArray = {2, 4, 5, 6, 7, 8, 9};
        Change change = new Change();

        if (amount <= 1)
            return null;
        if (amount >= 10) {
            change.setBill10(Math.floorDiv(amount, 10));
            amount %= 10;
            if (amount == 0)
                return change;
        }
        for (int i = 0; i < checkArray.length; i++) {
            if (checkArray[i] == amount ) {
                if (amount % 2 != 0) {
                    change.setBill5(1);
                    amount -= 5;
                }
                change.setCoins2(amount / 2);
                return change;
            }
        }
        return null;
    }
}
