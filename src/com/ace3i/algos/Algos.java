package com.ace3i.algos;

import java.util.Arrays;

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
        int currentNodeId = startNodeId;
        int[] visited = new int[fromIds.length];
        int visitedIndex = 0;

        int nodeIndex = getNodeIndexInFromIds(currentNodeId, fromIds);
        while (nodeIndex != -1) {
            visited[visitedIndex++] = currentNodeId;
            int nextNodeId = toIds[nodeIndex];
            if (isVisited(nextNodeId, visited)) {
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
    private static boolean isVisited(int nodeId, int[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == nodeId)
                return true;
        }
        return false;
    }
}
