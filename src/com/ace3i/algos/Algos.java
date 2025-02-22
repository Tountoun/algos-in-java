package com.ace3i.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Algos {

    public static Change optimalChange(long amount) {
        int[] checkArray = {2, 4, 5, 6, 7, 8, 9};
        Change change = new Change();

        if (amount <= 1)
            return null;
        if (amount >= 10) {
            if (amount % 2 != 0) {
                change.setBill5(1);
                amount -= 5;
            }
            change.setBill10(amount / 10);
            amount %= 10;
            if (amount == 0)
                return change;
        }
        for (int i = 0; i < checkArray.length; i++) {
            if (checkArray[i] == amount ) {
                if (amount % 2 != 0) {
                    change.setBill5(change.getBill5() + 1);
                    amount -= 5;
                }
                change.setCoins2(amount / 2);
                return change;
            }
        }
        return null;
    }

    public static int findClosestToZero(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int closestToZero = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i]) < Math.abs(closestToZero) ||
                    (Math.abs(nums[i]) == Math.abs(closestToZero) && nums[i] > 0)) {
                closestToZero = nums[i];
            }
        }

        return closestToZero;
    }

    public static int findNetworkEndpoint(int startNodeId, int[] fromIds, int[] toIds) {
        List<Integer> visited = new ArrayList<>();
        int currentNodeId = startNodeId;

        int nodeIndex = getNodeIndexInFromIds(currentNodeId, fromIds);
        while (nodeIndex != -1) {
            visited.add(currentNodeId);
            int nextNodeId = toIds[nodeIndex];
            if (visited.contains(nextNodeId)) {
                return currentNodeId;
            }
            currentNodeId = nextNodeId;
            nodeIndex = getNodeIndexInFromIds(currentNodeId, fromIds);
        }

        return currentNodeId;
    }

    private static int getNodeIndexInFromIds(int nodeId, int[] fromIds) {
        for (int i = 0; i < fromIds.length; i++) {
            if (fromIds[i] == nodeId)
                return i;
        }
        return -1;
    }

    public static String palindromeChecker(String s, List<Integer> startIndexes, List<Integer> endIndexes, List<Integer> subs) {
        String result = "";
        for (int i = 0; i < startIndexes.size(); i++) {
            String str = s.substring(startIndexes.get(i), endIndexes.get(i) + 1);
            int sub = subs.get(i);
            if (str.length() == 1) {
                result += "1";
            } else {
                HashMap<String, Integer> keyValues = new HashMap<>();
                for (int j = 0; j < str.length(); j++) {
                    String letter = String.valueOf(str.charAt(j));
                    if (keyValues.containsKey(letter)) {
                        keyValues.put(letter, keyValues.get(letter) + 1);
                    } else {
                        keyValues.put(letter, 1);
                    }
                }
                long odds = keyValues.values().stream().filter(value -> value % 2 != 0).count();
                if (sub > (odds / 2) || sub == (odds / 2)) {
                    result += "1";
                } else {
                    result += "0";
                }
            }
        }
        return result;
    }

}
