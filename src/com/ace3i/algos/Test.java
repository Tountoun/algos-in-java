package com.ace3i.algos;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        System.out.println(Algos.palindromeChecker("cdecd", List.of(0, 0, 0, 0), List.of(0, 1, 2, 3), List.of(0, 1, 1, 0)));
        System.out.println(Algos.palindromeChecker("xxdnssuqevu", List.of(0), List.of(10), List.of(3)));
        System.out.println(Algos.palindromeChecker("bcba", List.of(1, 2, 1), List.of(3, 3, 1), List.of(2, 0, 0)));

        System.out.println(DP.longestIncreasingSubsequence(new int[]{5, 2, 1, 3, 6, 9}));

    }
}
