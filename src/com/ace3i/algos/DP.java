package com.ace3i.algos;

import java.util.Arrays;

public class DP {

    /**
     * Dynamic programming solution
     *
     * @param sequence the sequence of numbers. Example: [5, 2, 1, 3, 6, 9]
     * @return the length of the longest increasing subsequence. For the example above, 4
     */
    public static int longestIncreasingSubsequence(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return 0;

        int sequenceLength = sequence.length;
        int[] dp = new int[sequenceLength];
        Arrays.fill(dp, 1);

        for (int i = 1; i < sequenceLength; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        return Arrays.stream(dp).max().orElse(1);
    }
}
