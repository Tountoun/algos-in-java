package com.ace3i.algos;

public class Change {
    private long coins2 = 0;
    private long bill5 = 0;
    private long bill10 = 0;

    public long getCoins2() {
        return coins2;
    }

    public void setCoins2(long coins2) {
        this.coins2 = coins2;
    }

    public long getBill5() {
        return bill5;
    }

    public void setBill5(long bill5) {
        this.bill5 = bill5;
    }

    public long getBill10() {
        return bill10;
    }

    public void setBill10(long bill10) {
        this.bill10 = bill10;
    }

    @Override
    public String toString() {
        return "Change[" +
                "coins2=" + coins2 +
                ", bill5=" + bill5 +
                ", bill10=" + bill10 +
                ']';
    }
}
