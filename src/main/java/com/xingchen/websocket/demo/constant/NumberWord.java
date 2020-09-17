package com.xingchen.websocket.demo.constant;

public class NumberWord {
    private final static String[] ZERO = {};
    private final static String[] ONE = {};
    private final static String[] TWO = {"a", "b", "c"};
    private final static String[] THREE = {"d", "e", "f"};
    private final static String[] FOUR = {"g", "h", "i"};
    private final static String[] FIVE = {"j", "k", "l"};
    private final static String[] SIX = {"m", "n", "o"};
    private final static String[] SEVEN = {"p", "q", "r", "s"};
    private final static String[] EIGHT = {"t", "u", "v"};
    private final static String[] NINE = {"w", "x", "y", "z"};

    public static String[] getByIndex(Integer i) {
        if (i != null && i > -1 && i < 10) {
            switch (i) {
                case 0:
                    return ZERO;
                case 1:
                    return ONE;
                case 2:
                    return TWO;
                case 3:
                    return THREE;
                case 4:
                    return FOUR;
                case 5:
                    return FIVE;
                case 6:
                    return SIX;
                case 7:
                    return SEVEN;
                case 8:
                    return EIGHT;
                case 9:
                    return NINE;
            }
        }
        return new String[]{};
    }

    public static String[] getZERO() {
        return ZERO;
    }

    public static String[] getEIGHT() {
        return EIGHT;
    }

    public static String[] getFIVE() {
        return FIVE;
    }

    public static String[] getFOUR() {
        return FOUR;
    }

    public static String[] getNINE() {
        return NINE;
    }

    public static String[] getONE() {
        return ONE;
    }

    public static String[] getSEVEN() {
        return SEVEN;
    }

    public static String[] getSIX() {
        return SIX;
    }

    public static String[] getTHREE() {
        return THREE;
    }

    public static String[] getTWO() {
        return TWO;
    }
}
